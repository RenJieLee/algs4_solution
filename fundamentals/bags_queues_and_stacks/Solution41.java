import java.util.Iterator;

public class Solution41 {
	public static void main(String[] args) {
		QueueChanged<String> list = new QueueChanged<String>();
		String[] temp = ("f u c k y o u").split(" ");
		for (String s : temp) {
			list.enqueue(s);
		}
		QueueChanged<String> test = new QueueChanged<String>(list);
		for (String s : test)
			StdOut.print(s);
		StdOut.println();
		while (!list.isEmpty())
			StdOut.print(list.dequeue());
	}
}

class QueueChanged<Item> implements Iterable<Item> {
	private Node first;
	private Node last;
	private int N;
	private class Node {
		Item item;
		Node next;
	}
	public QueueChanged() {

	}
	public QueueChanged(QueueChanged<Item> q) {
		//Queue<Item> tmp = new Queue<Item>();
		int cnt = q.size();
		for (int i = 0; i < cnt; i++) {
			Item temp = q.dequeue();
			q.enqueue(temp);
			enqueue(temp);
		}
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