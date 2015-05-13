import java.util.Iterator;

public class Solution43 {
	public static double timeTrial(int N) {
		long time1 = System.currentTimeMillis();
		Stack<Integer> stack1 = new Stack<Integer>();
		for (int i = 0; i < N; i++) stack1.push(i);
		for (int i = 0; i < N; i++) stack1.pop();
		time1 = System.currentTimeMillis() - time1;
		long time2 = System.currentTimeMillis();
		ResizingArrayStack<Integer> stack2 = new ResizingArrayStack<Integer>();
		for (int i = 0; i < N; i++) stack2.push(i);
		for (int i = 0; i < N; i++) stack2.pop();
		time2 = System.currentTimeMillis() - time2;
		return time1 / 1.0 / time2;
	}
	public static void main(String[] args) {
		for (int i = 125; i > 0; i += i) StdOut.printf("%.5f\n", timeTrial(i));
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

class ResizingArrayStack<Item> implements Iterable<Item> {
	private Item[] a = (Item[]) new Object[1];
	private int N = 0;
	public boolean isEmpty() { return N == 0; }
	public int size() { return N; }
	private void resize(int max) {
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < N; i++)
			temp[i] = a[i];
		a = temp;
	}
	public void push(Item item) {
		if (N == a.length) resize(2 * a.length);
		a[N++] = item;
	}
	public Item pop() {
		Item item = a[--N];
		a[N] = null;

		if (N > 0 && N == a.length / 4) resize(a.length / 2);
		return item;
	}

	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}
	private class ReverseArrayIterator implements Iterator<Item> {
		private int i = N;
		public boolean hasNext() { return i > 0; }
		public Item next() { return a[--i]; }
		public void remove() {}
	}
}