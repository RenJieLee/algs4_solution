import java.util.Iterator;

public class Solution19 {
	public static void main(String[] args) {
		RandomGrid.main(args);
	}
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
		WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N * N);
		StdDraw.setXscale(-1, N);
		StdDraw.setYscale(-1, N);
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.setPenRadius(.005);
		RandomGrid r = new RandomGrid();
		Connection[] connections = r.generate(N);

		for (Connection c : connections) {
			if (uf.connected(c.p, c.q)) continue;
			int p = uf.find(c.p);
			int q = uf.find(c.q);
			uf.union(c.p, c.q);
			StdDraw.line(p % N, p / N, q % N, p / N);
			StdDraw.line(q % N, p / N, q % N, q / N);
		}
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

class WeightedQuickUnionUF {
	private int[] id;
	private int[] sz;
	private int count;
	public WeightedQuickUnionUF(int N) {
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++) id[i] = i;
		sz = new int[N];
		for (int i = 0; i < N; i++) sz[i] = 1;
	}
	public int count() {
		return count;
	}
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	public int find(int p) {
		while (p != id[p]) p = id[p];
		return p;
	}
	public void union(int p, int q) {
		int i = find(p);
		int j = find(q);
		if (i == j) return;
		if (sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		} else {
			id[j] = i;
			sz[i] += sz[j];
		}
		count--;
	}
	public static void main(String[] args) {
		int N = StdIn.readInt();
		WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if (uf.connected(p, q)) continue;
			uf.union(p, q);
			StdOut.println(p + " " + q);
		}
		StdOut.println(uf.count() + "components");
	}
}