public class Solution19 {
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
	public MaxPQ(Key[] a) {
		N = a.length;
		pq = (Key[]) new Comparable[N + 1];
		for (int i = 1; i < pq.length; i++)
			pq[i] = a[i - 1];
		for (int k = pq.length / 2; k >= 1; k--)
			sink(k);
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
		return pq[i].compareTo(pq[j]) < 0;
	}
	private void exch(int i, int j) {
		Key t = pq[i]; pq[i] = pq[j]; pq[j] = t;
	}
	public static void main(String[] args) {
		String[] test = "go fuck yourself bitch".split(" ");
		MaxPQ<String> maxPQ = new MaxPQ<String>(test);
		StdOut.println(maxPQ.delMax());
		StdOut.println(maxPQ.delMax());
		StdOut.println(maxPQ.delMax());
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