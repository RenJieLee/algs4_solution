import java.util.Iterator;

public class Solution28<Item> {
	Queue<Item> queue = new Queue<Item>();
	public boolean isEmpty() { return queue.isEmpty(); }
	public int size() { return queue.size(); }
	public void push(Item item) {
		queue.enqueue(item);
	}
	public Item pop() {
		for (int i = 0; i < size() - 1; i++) queue.enqueue(queue.dequeue());
		return queue.dequeue();
	}
	public Item peek() {
		for (int i = 0; i < size() - 1; i++) queue.enqueue(queue.dequeue());
		Item i = queue.dequeue();
		queue.enqueue(i);
		return i;
	}
	public static void main(String[] args) {
		Solution28<String> s = new Solution28<String>();
		s.push("T");
		s.push("T");
		s.push("so");
		s.push("hard");
		StdOut.println(s.peek());
		StdOut.println(s.pop());
		StdOut.println(s.pop());
		StdOut.println(s.pop());
	}
}
class Queue<Item> implements Iterable<Item> {
	private Node first;
	private Node last;
	private int N;
	private class Node {
		Item item;
		Node next;
	}
	public boolean isEmpty() { return first == null; }
	public int size() { return N; }
	public void enqueue(Item item) {
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()) first = last;
		else oldlast.next = last;
		N++;
	}
	public Item dequeue() {
		Item item = first.item;
		first = first.next;
		if (isEmpty()) last = null;
		N--;
		return item;
	}
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	private class ListIterator implements Iterator<Item> {
		private Node current = first;
		public boolean hasNext() {
			return current != null;
		}
		public void remove() { }
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
	public static void main(String[] args) {
		Queue<String> s = new Queue<String>();
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-"))
				s.enqueue(item);
			else if (!s.isEmpty()) {
				StdOut.print(s.dequeue() + " ");
			}
		}
		StdOut.println("(" + s.size() + " left on stack)");
	}
}