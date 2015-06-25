public class Solution12 {

}

class BST<Key extends Comparable<Key>, Value> {
	private Node root;
	private class Node {
		private Key key;
		private Value val;
		private Node left, right;
		public Node(Key key, Value val) {
			this.key = key; this.val = val;
		}
	}
	public boolean contains(Key k) {
		if (get(k) != null) return true;
		return false;
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
		if (x == null) return new Node(key, val);
		int cmp = key.compareTo(x.key);
		if 		(cmp < 0) x.left = put(x.left, key, val);
		else if (cmp > 0) x.right = put(x.right, key, val);
		else x.val = val;
		return x;
	}
	public Key min() {
		return min(root).key;
	}
	public Node min(Node x) {
		if (x.left == null) return x;
		else return min(x.left);
	}
	public Key max() {
		return max(root).key;
	}
	public Node max(Node x) {
		if (x.right == null) return x;
		else return max(x.right);
	}
	public Key floor(Key key) {
		Node x = floor(root, key);
		if (x == null) return null;
		return x.key;
	}
	private Node floor(Node x, Key key) {
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if (cmp == 0) return x;
		if (cmp < 0) return floor(x.left, key);
		Node t = floor(x.right, key);
		if (t != null) return t;
		else return x;
	}
	public Key ceiling(Key key) {
		Node x = ceiling(root, key);
		if (x == null) return null;
		return x.key;
	}
	private Node ceiling(Node x, Key key) {
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if (cmp == 0) return x;
		if (cmp > 0) return ceiling(x.right, key);
		Node t = ceiling(x.left, key);
		if (t != null) return t;
		else return x;
	}
	
	public void deleteMin() {
		root = deleteMin(root);
	}
	public Node deleteMin(Node x) {
		if (x.left == null) return x.right;
		x.left = deleteMin(x.left);
		return x;
	}
	public void deleteMax() {
		root = deleteMax(root);
	}
	public Node deleteMax(Node x) {
		if (x.right == null) return x.left;
		x.right = deleteMax(x.right);
		
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