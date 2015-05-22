public class MaxPQ3<Key extends Comparable<Key>> {
	private Node first;
	private int N;
	private class Node {
		Key item;
		Node next;
		public Node(Key item) {
			this.item = item;
		}
	}
	public MaxPQ3() {
	}
	public MaxPQ3(int max) {
	}
	public MaxPQ3(Key[] t) {
		first = new Node(t[0]);
		Node current = first;
		for (int i = 1; i < t.length; i++) {
			current.next = new Node(t[i]);
			current = current.next;
		}
	}
	public void insert(Key v) {
		N++;

		Node fakeHead = new Node(v);
		fakeHead.next = first;
		Node current = fakeHead;
		while (current.next.item.compareTo(v) < 0) current = current.next;
		Node tmp = current.next;
		current.next = new Node(v);
		current.next.next = tmp;
		first = fakeHead.next;
	}
	public Key max() {
		return first.item;
	}
	public Key delMax() {
		N--;
		Key tmp = first.item;
		first = first.next;
		return tmp;
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