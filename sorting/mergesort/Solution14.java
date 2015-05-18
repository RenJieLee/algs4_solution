import java.util.Iterator;

public class Solution14 {
	public static <T extends Comparable> Queue<T> sort(Queue<T> q1, 
		Queue<T> q2) {
		Queue<T> res = new Queue<T>();
		T t1 = q1.dequeue();
		T t2 = q2.dequeue();
		while (!q1.isEmpty() && !q2.isEmpty()) {
			if (less(t1, t2)) {
				res.enqueue(t1);
				t1 = q1.dequeue();
			} else {
				res.enqueue(t2);
				t2 = q2.dequeue();
			}
		}		
		if (q1.isEmpty()) {
			while (!q2.isEmpty()) {
				if (t1 != null && less(t1, t2)) {
					res.enqueue(t1);
					t1 = null;	
				} else {
					res.enqueue(t2);
					t2 = q2.dequeue();
				}
			}
			if (t1 != null) {
				if (less(t1, t2)) {
					res.enqueue(t1);
					res.enqueue(t2);
				} else {
					res.enqueue(t2);
					res.enqueue(t1);
				}
			} else {
				res.enqueue(t2);
			}
			
			return res;
		} else {
			while (!q1.isEmpty()) {
				if (t2 != null && less(t2, t1)) {
					res.enqueue(t2);
					t2 = null;	
				} else {
					res.enqueue(t1);
					t1 = q1.dequeue();
				}
			}
			if (t2 != null) {
				if (less(t1, t2)) {
					res.enqueue(t1);
					res.enqueue(t2);
				} else {
					res.enqueue(t2);
					res.enqueue(t1);
				}
			} else {
				res.enqueue(t1);
			}
			return res;
		}

	}
	public static void main(String[] args) {
			Queue<String> q1 = new Queue<String>();
			q1.enqueue("k");
			//q1.enqueue("cde");
			//q1.enqueue("qq");
			Queue<String> q2 = new Queue<String>();
			//q2.enqueue("bb");
			//q2.enqueue("damn");
			//q2.enqueue("h");
			q2.enqueue("sb");
			for (String s : sort(q1, q2)) {
				StdOut.println(s + " ");
			}
			
		}
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
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