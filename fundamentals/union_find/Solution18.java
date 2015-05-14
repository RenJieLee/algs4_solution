import java.util.Iterator;

public class Solution18 {

}

class RandomGrid {
	private class Connection {
		int p;
		int q;
		public Connection(int p, int q) {
			this.p = p;
			this.q = q;
		}
		public String toString() {
			return p + " " + q;
		}
	}
	private  RandomBag<Connection> bag = new RandomBag<Connection>();
	public Connection[] generate(int N) {
		for (int i = 0; i < N * N; i++)
			for (int j = 0; j < N * N; j++)
				bag.add(new Connection(i, j));
		Connection[] res = new Connection[bag.size()];
		int i = 0;
		for (Connection c : bag) {
			res[i++] = c;
		}
		return res;
	}
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		RandomGrid r = new RandomGrid();
		for (Connection c : r.generate(N)) StdOut.println(c);
	}
}

class RandomBag<Item> implements Iterable<Item> {
	private int count;
	private Item[] items = (Item[]) new Object[1];

	public boolean isEmpty() { return count == 0; }
	public int size() { return count; }
	public void add(Item item) {
		if (count == items.length)
			resize();
		items[count++] = item;
	}
	public Iterator<Item> iterator() {
		return new RandomBagIterator();
	}
	public void resize() {
		Item[] temp = (Item[]) new Object[items.length * 2];
		for (int i = 0; i < items.length; i++)
			temp[i] = items[i];
		items = temp;
	}

	class RandomBagIterator implements Iterator<Item> {
		Item[] iteratorItems = (Item[]) new Object[count];
		private int index;
		public RandomBagIterator() {
			for (int i = 0; i < count; i++)
				iteratorItems[i] = items[i];
			StdRandom.shuffle(iteratorItems);
		}
		public boolean hasNext() {
			return index < count;
		}
		public Item next() {
			return iteratorItems[index++];
		}
	}
}