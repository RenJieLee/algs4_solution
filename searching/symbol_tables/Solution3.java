public class Solution3 {

}

class OrderedSequentialSearchST<Key extends Comparable<Key>, Value> {
	private Node first;
	private int N = 0;
	private class Node {
		Key key;
		Value val;
		Node next;
		public Node(Key key, Value val, Node next) {
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}
	public OrderedSequentialSearchST() {}
	public void put(Key key, Value val) {
		Node fakeHead = new Node(null, null, first);
		Node x = fakeHead;
		for (; x.next != null; x = x.next) {
			if (x.next.key.compareTo(key) == 0) {
				x.next.val = val;
				first = fakeHead.next;
				return;
			}
			else if (x.next.key.compareTo(key) > 0) {
				N++;
				x.next = new Node(key, val, x.next);
				first = fakeHead.next;
				return;
			}
		}
		N++;
		x.next = new Node(key, val, null);
		first = fakeHead.next;
	}
	public Value get(Key key) {
		for (Node x = first; x != null; x = x.next) {
			if (x.key.compareTo(key) == 0)
				return x.val;
		}
		return null;
	}
	public void delete(Key key) {
		Node fakeHead = new Node(first.key, first.val, first);
		for (Node x = fakeHead; x.next != null; x = x.next) {
			if (x.next.key.compareTo(key) == 0) {
				N--;
				x.next = x.next.next;
				return;
			}
		}
		//put(key, null);
	}
	public boolean contains(Key key) {
		return get(key) != null;
	}
	public boolean isEmpty() {
		return size() == 0;
	}
	public int size() {
		return N;
	}
	public Key min() {
		return first.key;
	}
	public Key max() {
		Node tmp = first;
		while (tmp.next != null)
			tmp = tmp.next;
		return tmp.key;
	}
	public Key floor(Key key) {
		if (first.key.compareTo(key) > 0)
			return null;
		Node fakeHead = new Node(first.key, first.val, first);
		Node x = fakeHead;
		while (x.next != null && x.next.key.compareTo(key) <= 0)
			x = x.next;
		return x.key;
	}
	public Key ceiling(Key key) {
		if (max().compareTo(key) < 0)
			return null;
		Node x = first;
		while (x != null && x.key.compareTo(key) < 0)
			x = x.next;
		return x.key;
	}
	public int rank(Key key) {
		int res = 0;
		Node x = first;
		while (x != null && x.key.compareTo(key) < 0) {
			x = x.next;
			res++;
		}
		return res;
	}
	public Key select(int k) {
		if (k < 0 || k >= N) return null;
		Node x = first;
		while (k != 0) {
			k--;
			x = x.next;
		}
		return x.key;
	}
	public void deleteMin() {
		delete(min());
	}
	public void deleteMax() {
		delete(max());
	}
	public int size(Key lo, Key hi) {
		if (hi.compareTo(lo) < 0)
			return 0;
		else if (contains(hi))
			return rank(hi) - rank(lo) + 1;
		else
			return rank(hi) - rank(lo);
	}
	public Iterable<Key> keys(Key lo, Key hi) {
		Queue<Key> q = new Queue<Key>();
		Node x = first;
		while (x != null && x.key.compareTo(lo) < 0)
			x = x.next;
		//q.enqueue(x.key);
		while (x != null && x.key.compareTo(hi) <= 0) {
			q.enqueue(x.key);
			x = x.next;
		}
		return q;
	}
	public Iterable<Key> keys() {
		return keys(min(), max());
	}
	public static void main(String[] args) {
		
	}
}