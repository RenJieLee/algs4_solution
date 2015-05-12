import java.util.*;

public class Solution50 {
	public static void main(String[] args) {
		Stack<String> test = new Stack<String>();
		test.push("Fuck");
		test.push("you");
		test.push("bitch");
		for (String s : test)
			test.pop();
	}
}

class Stack<Item> implements Iterable<Item> {
	private Node first;
	private int N;
	int count = 0;
	private class Node {
		Item item;
		Node next;
	}
	public boolean isEmpty() { return first == null; }
	public int size() { return N; }
	public void push(Item item) {
		count++;
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}
	public Item pop() {
		count++;
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}
	public Item peek() {
		return first.item;
	}
	public Iterator<Item> iterator() {
		return new ListIterator(count);
	}
	private class ListIterator implements Iterator<Item> {
		private Node current = first;
		private int count;
		public ListIterator(int n) {
			count = n;
		}
		public boolean hasNext() {
			if (count != Stack.this.count) throw new ConcurrentModificationException();
			return current != null;
		}
		public void remove() { }
		public Item next() {
			if (count != Stack.this.count) throw new ConcurrentModificationException();
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