public class Solution34 {

}

class IndexMinPQ<Item extends Comparable<Item>> {
	private int[] pq;
	private Item[] keys;
	private int[] qp;
	private int N = 0;
	public IndexMinPQ(int maxN) {
		keys = (Item[]) new Comparable[maxN + 1];
		pq = new int[maxN + 1];
		qp = new int[maxN + 1];
		for (int i = 0; i <= maxN; i++)
			qp[i] = -1;
	}
	public void insert(int k, Item item) {
		N++;
		pq[N] = k;
		qp[k] = N;
		keys[k] = item;
		swim(N);
	}
	public void change(int k, Item item) {
		int index = 1;
		while (pq[index] != k) index++;
		Item tmp = keys[k];
		keys[k] = item;
		if (tmp.compareTo(item) > 0)
			swim(index);
		else 
			sink(index);
	}
	public boolean contains(int k) {
		return qp[k] != -1;
	}
	public void delete(int k) {
		int index = 1;
		while (pq[index] != k) index++;
		exch(index, N--);
		sink(index);
		keys[k] = null;
		qp[k] = -1;
	}
	public Item min() {
		return keys[pq[1]];
	}
	public int minIndex() {
		return pq[1];
	}
	public int delMin() {
		int k = minIndex();
		exch(1, N--);
		sink(1);
		keys[k] = null;
		qp[k] = -1;
		return k;
	}
	public boolean isEmpty() {
		return N == 0;
	}
	public int size() {
		return N;
	}
	private void sink(int k) {
		while (2 * k <= N) {
			int j = 2 * k;
			if (j < N && less(j, j + 1)) j++;
			if (!less(k, j)) break;
			exch(k, j);
			k = j;
		}
	}
	private void swim(int k) {
		while (k > 1 && less(k / 2, k)) {
			exch(k / 2, k);
			k = k / 2;
		}
	}
	private boolean less(int i, int j) {
		return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
	}
	private void exch(int i, int j) {
		int t = pq[i]; pq[i] = pq[j]; pq[j] = t;
	}
	public static void main(String[] args) {
		IndexMinPQ<String> ex = new IndexMinPQ<String>(10);
		ex.insert(5, "fuck");
		ex.insert(6, "you");
		StdOut.println(ex.minIndex());
		StdOut.println(ex.min());
		ex.insert(7, "bitch");
		StdOut.println(ex.minIndex());
		StdOut.println(ex.min());
		ex.change(7, "aban");
		StdOut.println(ex.minIndex());
		StdOut.println(ex.min());
		ex.delete(7);
		StdOut.println(ex.minIndex());
		StdOut.println(ex.min());
		StdOut.println(ex.contains(7));
		StdOut.println(ex.delMin());
		StdOut.println(ex.min());
	}
}