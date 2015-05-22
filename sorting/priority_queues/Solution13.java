public class Solution13 {
	public static void main(String[] args) {
		MaxPQ.main(args);
	}
}

class MaxPQ<Key extends Comparable<Key>> {
	private Key[] pq;
	private int N = 0;
	public MaxPQ(int maxN) {
		pq = (Key[]) new Comparable[maxN + 1];
	}
	public void insert(Key v) {
		pq[++N] = v;
		swim(N);
	}
	public Key delMax() {
		Key max = pq[1];
		exch(1, N--);
		pq[N + 1] = null;
		sink(1);
		return max;
	}
	public Key max() {
		return pq[1];
	}
	public boolean isEmpty() {
		return N == 0;
	}
	public int size() {
		return N;
	}
	private void sink(int k) {
		pq[N + 1] = max();
		while (2 * k <= N) {
			int j = 2 * k;
			if (less(j, j + 1)) j++;
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
		return pq[i].compareTo(pq[j]) < 0;
	}
	private void exch(int i, int j) {
		Key t = pq[i]; pq[i] = pq[j]; pq[j] = t;
	}
	public static void main(String[] args) {
		MaxPQ<String> maxPQ2 = new MaxPQ<String>(10);
		maxPQ2.insert("P");
		maxPQ2.insert("Q");
		maxPQ2.insert("E");
		StdOut.println(maxPQ2.delMax());
		maxPQ2.insert("X");
		maxPQ2.insert("A");
		maxPQ2.insert("M");
		StdOut.println(maxPQ2.delMax());
		maxPQ2.insert("P");
		maxPQ2.insert("L");
		maxPQ2.insert("E");
		StdOut.println(maxPQ2.delMax());
	}
	/*
	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int k = N / 2; k >= 1; k--)
			sink(a, k, N);
		while (N > 1) {
			exch(a, 1, N--);
			sink(a, 1, N);
		}
	}
	*/
}