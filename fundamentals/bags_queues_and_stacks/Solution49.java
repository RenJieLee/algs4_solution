import java.util.Iterator;

public class Solution49<Item> {
	private Stack<Item> first = new Stack<Item>();
	private Stack<Item> second = new Stack<Item>();
	private boolean notDequeu = true;
	public void enqueue(Item item) {
		first.push(item);		
	}
	public boolean isEmpty() { return second.isEmpty() && first.isEmpty(); }
	public int size() { return second.size() + first.size(); }
	public Item dequeue() {
		if (notDequeu) {
			while (!first.isEmpty()) second.push(first.pop());
			notDequeu = false;
			return second.pop();
		} else {
			if (second.size() == 1) notDequeu = true;
			return second.pop();
		}
	}
	public static void main(String[] args) {
		Solution49<String> s = new Solution49<String>();
		s.enqueue("fuck");
		s.enqueue("you");
		StdOut.println(s.dequeue());
		s.enqueue("bitch");
		StdOut.println(s.dequeue());
		StdOut.println(s.dequeue());
	}
}
class Stack<Item> implements Iterable<Item> {
	private Node first;
	private int N;
	private class Node {
		Item item;
		Node next;
	}
	public boolean isEmpty() { return first == null; }
	public int size() { return N; }
	public void push(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}
	public Item pop() {
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}
	public Item peek() {
		return first.item;
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
		Stack<String> s = new Stack<String>();
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-"))
				s.push(item);
			else if (!s.isEmpty()) {
				StdOut.print(s.pop() + " ");
			}
		}
		StdOut.println("(" + s.size() + " left on stack)");
	}
}