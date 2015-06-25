public class Solution14 {

}
class BST<Key extends Comparable<Key>, Value> {
	private Node root;
	private class Node {
		private Key key;
		private Value val;
		private Node left, right;
		private int N;
		public Node(Key key, Value val, int N) {
			this.key = key; this.val = val; this.N = N;
		}
	}
	public boolean contains(Key k) {
		if (get(k) != null) return true;
		return false;
	}
	public int size() {
		return size(root);
	}
	private int size(Node x) {
		if (x == null) return 0;
		else 		   return x.N;
	}
	public Value get(Key key) {
		return get(root, key);
	}
	private Value get(Node x, Key key) {
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if 		(cmp < 0) return get(x.left, key);
		else if (cmp > 0) return get(x.right, key);
		else return x.val;
	}
	public void put(Key key, Value val) {
		root = put(root, key, val);
	}
	public Node put(Node x, Key key, Value val) {
		if (x == null) return new Node(key, val, 1);
		int cmp = key.compareTo(x.key);
		if 		(cmp < 0) x.left = put(x.left, key, val);
		else if (cmp > 0) x.right = put(x.right, key, val);
		else x.val = val;
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	public Key min() {
		return min(root).key;
	}
	public Node min(Node x) {
		if (x == null) return null;
		Node t = x;
		while (t.left != null) t = t.left;
		return t;
	}
	public Key max() {
		return max(root).key;
	}
	public Node max(Node x) {
		if (x == null) return null;
		Node t = x;
		while (t.right != null) t = t.right;
		return t;
	}
	public Key floor(Key key) {
		if (root == null) return null;
		Node t = root;
		while (t != null) {
			int cmp = key.compareTo(t.key);
			if 		(cmp == 0) return t.key;
			else if (cmp < 0) {
				t = t.left;
			}
			else {
				if (t.right == null || min(t.right).key.compareTo(key) > 0) {
					return t.key;
				} else {
					t = t.right;
				}
			}
		}
		return null;
	}
	
	public Key ceiling(Key key) {
		if (root == null) return null;
		Node t = root;
		while (t != null) {
			int cmp = key.compareTo(t.key);
			if 		(cmp == 0) return t.key;
			else if (cmp > 0) {
				t = t.right;
			}
			else {
				if (t.left == null || max(t.left).key.compareTo(key) < 0) {
					return t.key;
				} else {
					t = t.left;
				}
			}
		}
		return null;
	}
	public Key select(int k) {
		Node t = root;
		while (t != null) {
			int r = size(t.left);
			if 		(r > k) t = t.left;
			else if (r < k) {
				k -= (r + 1);
				t = t.right;
			}
			else return t.key;
		}
		return null;
		//return select(root, k).key;
	}
	
	public int rank(Key key) {
		Node t = root;
		int res = 0;
		while (t != null) {
			int cmp = key.compareTo(t.key);
			if (cmp < 0) t = t.left;
			else if (cmp > 0) {
				res += size(t.left) + 1;
				t = t.right;
			}
			else return res + size(t.left);
		}
		return res;
	}
	public void deleteMin() {
		root = deleteMin(root);
	}
	public Node deleteMin(Node x) {
		if (x.left == null) return x.right;
		x.left = deleteMin(x.left);
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	public void deleteMax() {
		root = deleteMax(root);
	}
	public Node deleteMax(Node x) {
		if (x.right == null) return x.left;
		x.right = deleteMax(x.right);
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	public void delete(Key key) {
		root = delete(root, key);
	}
	private Node delete(Node x, Key key) {
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if 		(cmp < 0) x.left = delete(x.left, key);
		else if (cmp > 0) x.right = delete(x.right, key);
		else {
			if (x.right == null) return x.left;
			if (x.left == null) return x.right;
			Node t = x;
			x = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
		}
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	public Iterable<Key> keys() {
		return keys(min(), max());
	}
	public Iterable<Key> keys(Key lo, Key hi) {
		Queue<Key> queue = new Queue<Key>();
		keys(root, queue, lo, hi);
		return queue;
	}
	private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
		if (x == null) return;
		int cmplo = lo.compareTo(x.key);
		int cmphi = hi.compareTo(x.key);
		if (cmplo < 0) keys(x.left, queue, lo, hi);
		if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);
		if (cmphi > 0) keys(x.right, queue, lo, hi);
	}
}