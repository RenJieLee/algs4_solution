public class Solution25 {

}

class BinarySearchST<Key extends Comparable<Key>, Value> {
	private Key[] keys;
	private Value[] vals;
	private Key mostKey;
	private Value mostVal;
	private int mostCount = 0;
	private int N;
	public BinarySearchST(int capacity) {
		keys = (Key[]) new Comparable[capacity];
		vals = (Value[]) new Object[capacity];

	}
	public void put(Key key, Value val) {
		if (mostCount == 0) {
			mostKey = key;
			mostVal = val;
			mostCount = 1;
		} else if (mostKey.compareTo(key) == 0) {
			mostCount++;
		} else if (mostKey.compareTo(key) != 0) {
			mostCount--;
		}// change
		int i = rank(key);
		if (i < N && keys[i].compareTo(key) == 0) {
			vals[i] = val;
			return;
		}
		for (int j = N; j > i; j--) {
			keys[j] = keys[j - 1];
			vals[j] = vals[j - 1];
		}
		keys[i] = key;
		vals[i] = val;
		N++;
	}
	public Value get(Key key) {
		if (isEmpty()) return null;
		if (mostKey.compareTo(key) == 0) {
			mostCount++;
			return mostVal;
		} else if (mostKey.compareTo(key) != 0) {
			mostCount--;
		}
		int i = rank(key);
		if (i < N && keys[i].compareTo(key) == 0) {
			if (mostCount <= 0) {
				mostKey = key;
				mostVal = vals[i];
				mostCount = 1;
			}
			return vals[i];
		}
		else									  return null;
	}
	public void delete(Key key) {
		//put(key, null);
		if (!contains(key))
			return;
		N--;
		for (int i = rank(key); i < N; i++) {
			keys[i] = keys[i + 1];
			vals[i] = vals[i + 1];
		}
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
		return keys[0];
	}
	public Key max() {
		return keys[N - 1];
	}
	public Key floor(Key key) {
		if (contains(key)) return key;
		int i = rank(key);
		if (i == 0) return null;
		return keys[i - 1];
	}
	public Key ceiling(Key key) {
		int i = rank(key);
		return keys[i];
	}
	public int rank(Key key) {
		int lo = 0, hi = N - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int cmp = key.compareTo(keys[mid]);
			if (cmp < 0) hi = mid - 1;
			else if (cmp > 0) lo = mid + 1;
			else return mid;
		}
		return lo;
	}
	public Key select(int k) {
		return keys[k];
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
		for (int i = rank(lo); i < rank(hi); i++) {
			q.enqueue(keys[i]);
		}
		if (contains(hi))
			q.enqueue(keys[rank(hi)]);
		return q;
	}
	public Iterable<Key> keys() {
		return keys(min(), max());
	}
	public static void main(String[] args) {
		BinarySearchST<String, Integer> st = new BinarySearchST<String, Integer>(10);
		st.put("fuck", 0);
		st.put("you", 1);
		st.put("AB", 2);
		st.put("bitch", 3);
		StdOut.println(st.get("bitch"));
		StdOut.println(st.size());
		st.delete("hey");
		StdOut.println(st.size());
		st.delete("you");
		StdOut.println(st.size());
		for(String key : st.keys())
			StdOut.println(key);
	}
	
}

class SequentialSearchST<Key, Value> {
	private Node first;
	private int N;
	private Node mostNode;
	private int mostCount;
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
	public Value get(Key key) {
		if (isEmpty())
			return null;
		if (mostNode.key.equals(key)) {
			mostCount++;
			return mostNode.val;
		}
		else if (!mostNode.key.equals(key)) {
			mostCount--;
		}
		for (Node x = first; x != null; x = x.next)
			if (key.equals(x.key)) {
				if (mostCount <= 0) {
					mostNode = new Node(key, x.val, null);
					mostCount = 1;
				}
				return x.val;
			}
		return null;
	}
	public void put(Key key, Value val) {
		if (val == null) {
			delete(key);
			return;
		}
		if (mostCount == 0) {
			mostNode = new Node(key, val, null);
		} else if (mostNode.key.equals(key)) {
			mostCount++;
		} else if (!mostNode.key.equals(key)) {
			mostCount--;
		}
		for (Node x = first; x != null; x = x.next)
			if (key.equals(x.key)) {
				x.val = val;
				return;
			}
		N++;
		first = new Node(key, val, first);
	}
	public void delete(Key key) {
		//put(key, null);
		Node fakeHead = new Node(first.key, first.val, first);
		for (Node x = fakeHead; x.next != null; x = x.next)
			if (x.next.key.equals(key)) {
				x.next = x.next.next;
				N--;
				return;
			}
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
	public Iterable<Key> keys() {
		Queue<Key> res = new Queue<Key>();
		for (Node x = first; x != null; x = x.next)
			res.enqueue(x.key);
		return res;
	}
	public static void main(String[] args) {
		SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
		st.put("fuck", 0);
		st.put("you", 1);
		st.put("bitch", 2);
		StdOut.println(st.get("bitch"));
		StdOut.println(st.size());
		st.delete("hey");
		StdOut.println(st.size());
		st.delete("you");
		StdOut.println(st.size());
		for(String key : st.keys())
			StdOut.println(key);
	}
}