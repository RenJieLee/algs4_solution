public class MaxPQ4<Key extends Comparable<Key>> {
	private Node first;
	private int N;
	private class Node {
		Key item;
		Node next;
		public Node(Key item) {
			this.item = item;
		}
	}
	public MaxPQ4() {
	}
	public MaxPQ4(int max) {
	}
	public MaxPQ4(Key[] t) {
		first = new Node(t[0]);
		Node current = first;
		for (int i = 1; i < t.length; i++) {
			current.next = new Node(t[i]);
			current = current.next;
		}
	}
	public void insert(Key v) {
		N++;
		Node tmp = new Node(v);
		tmp.next = first;
		first = tmp;
	}
	public Key max() {
		Key max = first.item;
		Node current = first;
		while (current != null)
			if (current.item.compareTo(max) > 0)
				max = current.item;
		return max;
	}
	public Key delMax() {
		N--;
		Node fakeHead = new Node(max());
		fakeHead.next = first;
		Node current = fakeHead;
		while (current.next.item.compareTo(fakeHead.item) != 0)
			current = current.next;
		current.next = current.next.next;
		return fakeHead.item;
	}
	public boolean isEmpty() {
		return N == 0;
	}
	public int size() {
		return N;
	}
	public static void main(String[] args) {
		MaxPQ2<String> maxPQ2 = new MaxPQ2<String>();
		maxPQ2.insert("P");
		maxPQ2.insert("Q");
		maxPQ2.insert("E");
		StdOut.println(maxPQ2.delMax());
		maxPQ2.insert("X");
		maxPQ2.insert("A");
		maxPQ2.insert("M");
		StdOut.println(maxPQ2.delMax());
		maxPQ2.insert("P");
		maxPQ2.insert("L");
		maxPQ2.insert("E");
		StdOut.println(maxPQ2.delMax());
	}
}