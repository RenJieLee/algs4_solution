import java.util.Iterator;

public class Solution14 {
	public static void main(String[] args) {
		ResizingArrayQueue<String> queue = new ResizingArrayQueue<String>();
		for (String s : ("g o d d a m n , f u c k y o u").split(" "))
			queue.enqueue(s);
		for (String s : queue)
			StdOut.print(s);
	}
}

class ResizingArrayQueue<Item> implements Iterable<Item> {
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
	public void enqueue(Item item) {
		if (N == a.length) resize(2 * a.length);
		for (int i = N; i > 0; i--)
			a[i] = a[i - 1];
		a[0] = item;
		N++;
	}
	public Item dequeue() {
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