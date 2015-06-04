public class Solution22 {
	public static void main(String[] args) {
		ArrayST.main(args);
	}
}

class ArrayST<Key, Value> {
	Key[] keys;
	Value[] vals;
	private int N = 0;
	public ArrayST(int capacity) {
		keys = (Key[]) new Object[capacity];
		vals = (Value[]) new Object[capacity];
	}
	public Value get(Key key) {
		for (int i = 0; i < N; i++) {
			if (keys[i].equals(key)) {
				Value valTmp = vals[i];
				Key keyTmp = keys[i];
				for (int j = i; j >= 1; j--) {
					keys[j] = keys[j - 1];
					vals[j] = vals[j - 1];
				}
				keys[0] = keyTmp;
				vals[0] = valTmp;
				return valTmp;
			}
		}
		return null;
	}
	public void put(Key key, Value val) {
		for (int i = 0; i < N; i++) {
			if (keys[i].equals(key)) {
				vals[i] = val;
				return;
			}
		}
		keys[N] = key;
		vals[N++] = val;
	}
	public void delete(Key key) {
		int i = 0;
		while (i < N && !keys[i].equals(key))
			i++;
		if (i == N)
			return;
		N--;
		for (int j = i; j < N; j++) {
			keys[j] = keys[j + 1];
			vals[j] = vals[j + 1];
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
		for (int i = 0; i < N; i++)
			res.enqueue(keys[i]);
		return res;
	}
	public static void main(String[] args) {
		ArrayST<String, Integer> st = new ArrayST<String, Integer>(10);
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
		st.get("AB");
		for(String key : st.keys())
			StdOut.println(key);
	}
}