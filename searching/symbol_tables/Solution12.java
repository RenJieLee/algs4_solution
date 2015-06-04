import java.util.*;

public class Solution12 {
	public static void main(String[] args) {
		//BinarySearchST<String, Integer> s = new BinarySearchST<String, Integer>(10);
		BinarySearchST.main(args);
	}
}

class BinarySearchST<Key extends Comparable<Key>, Value> {
	private class Item implements Comparable<Item> {
		Key k;
		Value val;
		public Item(Key k, Value val) {
			this.k = k;
			this.val = val;
		}
		public void setVal(Value val) {
			this.val = val;
		}
		public int compareTo(Item i) {
			return k.compareTo(i.k);
		}
	}
	ArrayList<Item> items;
	private int N;
	public BinarySearchST(int capacity) {
		items = new ArrayList<Item>();
	}
	public void put(Key key, Value val) {
		int i = rank(key);
		if (i < N && items.get(i).k.compareTo(key) == 0) {
			items.get(i).setVal(val);
			return;
		}
		//items.remove(i);
		items.add(i, new Item(key, val));
		N++;
	}
	public Value get(Key key) {
		if (isEmpty()) return null;
		int i = rank(key);
		if (i < N && items.get(i).k.compareTo(key) == 0) return items.get(i).val;
		else									  return null;
	}
	public void delete(Key key) {
		//put(key, null);
		if (!contains(key))
			return;
		N--;
		items.remove(rank(key));
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
		return items.get(0).k;
	}
	public Key max() {
		return items.get(N - 1).k;
	}
	public Key floor(Key key) {
		if (contains(key)) return key;
		int i = rank(key);
		if (i == 0) return null;
		return items.get(i - 1).k;
	}
	public Key ceiling(Key key) {
		int i = rank(key);
		return items.get(i).k;
	}
	public int rank(Key key) {
		int lo = 0, hi = N - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int cmp = key.compareTo(items.get(mid).k);
			if (cmp < 0) hi = mid - 1;
			else if (cmp > 0) lo = mid + 1;
			else return mid;
		}
		return lo;
	}
	public Key select(int k) {
		return items.get(k).k;
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
			q.enqueue(items.get(i).k);
		}
		if (contains(hi))
			q.enqueue(items.get(rank(hi)).k);
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