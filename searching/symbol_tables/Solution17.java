public class Solution17 {
}

class BinarySearchST<Key extends Comparable<Key>, Value> {
	private Key[] keys;
	private Value[] vals;
	private int N;
	public BinarySearchST(int capacity) {
		keys = (Key[]) new Comparable[capacity];
		vals = (Value[]) new Object[capacity];

	}
	public void put(Key key, Value val) {
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
		int i = rank(key);
		if (i < N && keys[i].compareTo(key) == 0) return vals[i];
		else									  return null;
	}
	public void delete(Key key) {
		put(key, null);
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
		BinarySearchST<String, Integer> st;
		st = new BinarySearchST<String, Integer>(10);
		for (int i = 0; !StdIn.isEmpty(); i++) {
			String key = StdIn.readString();
			st.put(key, i);
		}
		for (String s : st.keys())
			StdOut.println(s + " " + st.get(s));
	}
	
}