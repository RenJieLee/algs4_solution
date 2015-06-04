public class Solution30 {

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
		int rand = (int)(Math.random() * N);
		assert rand == rank(select(rand));
	}
	public Value get(Key key) {
		if (isEmpty()) return null;
		int i = rank(key);
		if (i < N && keys[i].compareTo(key) == 0) return vals[i];
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
		int rand = (int)(Math.random() * N);
		assert rand == rank(select(rand));
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