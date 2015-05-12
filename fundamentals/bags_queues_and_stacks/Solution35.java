import java.util.Iterator;

public class Solution35 {
	public static void main(String[] args) {
		RandomQueue<String> list = new RandomQueue<String>();
		String[] temp = ("f u c k y o u").split(" ");
		for (String s : temp) {
			list.enqueue(s);
		}
		while (!list.isEmpty())
			StdOut.print(list.dequeue());
	}
}

class RandomQueue<Item> implements Iterable<Item> {
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
		a[N++] = item;
	}
	public Item dequeue() {
		if (N == 1) {
			N--;
			return a[0];
		}
		int rand = StdRandom.uniform(N - 1);
		Item item = a[rand];
		a[rand] = a[N - 1];
		a[N - 1] = item;

		
		a[--N] = null;

		if (N > 0 && N == a.length / 4) resize(a.length / 2);
		return item;
	}
	public Item sample() {
		int rand = StdRandom.uniform(N - 1);
		Item tmp = a[rand];
		a[rand] = a[N - 1];
		a[N - 1] = tmp;

		return a[N - 1];
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