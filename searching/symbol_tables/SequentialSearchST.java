public class SequentialSearchST<Key, Value> {
	private Node first;
	private int N;
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
		for (Node x = first; x != null; x = x.next)
			if (key.equals(x.key))
				return x.val;
		return null;
	}
	public void put(Key key, Value val) {
		if (val == null) {
			delete(key);
			return;
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