public class ST<Key extends Comparable<Key>, Value> {
	public ST() {}
	public void put(Key key, Value val) {}
	public Value get(Key key) {}
	public void delete(Key key) {
		put(key, null);
	}
	public boolean contains(Key key) {
		return get(key) != null;
	}
	public boolean isEmpty() {
		return size() == 0;
	}
	public int size() {}
	public Key min() {}
	public Key max() {}
	public Key floor(Key key) {}
	public Key ceiling(Key key) {}
	public int rank(Key key) {}
	public Key select(int k) {}
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
	public Iterable<Key> keys(Key lo, Key hi) {}
	public Iterable<Key> keys() {
		return keys(min(), max());
	}
	public static void main(String[] args) {
		ST<String, Integer> st;
		st = new ST<String, Integer>();
		for (int i = 0; !StdIn.isEmpty(); i++) {
			String key = StdIn.readString();
			st.put(key, i);
		}
		for (String s : st.keys())
			StdOut.println(s + " " + st.get(s));
	}
}

/*
public class ST<Key, Value> {
	public Value get(Key key) {
	}
	public void put(Key key, Value val) {
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
	}
	public Iterable<Key> keys() {
	}
}
*/