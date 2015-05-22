public class Solution29 {
	public static void main(String[] args) {
		PQ.main(args);
	}
}

class PQ<Key extends Comparable<Key>> {

	MaxPQ1<Key> pq1 = new MaxPQ1<Key>();
	MaxPQ2<Key> pq2 = new MaxPQ2<Key>();
	int N = 0;
	public PQ() {
	}
	public PQ(int maxN) {
	}
	public void insert(Key v) {
		pq1.insert(v);
		pq2.insert(v);
		N++;
	}
	public Key delMax() {
		N--;
		return pq1.delMax();
	}
	public Key delMin() {
		N--;
		return pq2.delMin();
	}
	public Key getMax() {
		return pq1.getMax();
	}
	public Key getMin() {
		return pq2.getMin();
	}
	public boolean isEmpty() {
		return N == 0;
	}
	public int size() {
		return N;
	}
	public static void main(String[] args) {
		PQ<String> maxPQ = new PQ<String>();
		maxPQ.insert("fuck");
		maxPQ.insert("you");
		maxPQ.insert("bitch");
		maxPQ.insert("eat");
		
		StdOut.println(maxPQ.delMin());
		StdOut.println(maxPQ.delMax());
		StdOut.println(maxPQ.delMax());
		StdOut.println(maxPQ.delMin());
	}
}

class MaxPQ1<Key extends Comparable<Key>> {
	private Key[] pq = (Key[]) new Comparable[2];
	private int N = 0;
	public MaxPQ1() {

	}
	public MaxPQ1(int maxN) {
		pq = (Key[]) new Comparable[maxN + 1];
	}
	public MaxPQ1(Key[] a) {
		N = a.length;
		pq = (Key[]) new Comparable[N + 1];
		for (int i = 1; i < pq.length; i++)
			pq[i] = a[i - 1];
		for (int k = pq.length / 2; k >= 1; k--)
			sink(k);
	}
	public void resize(int maxN) {
		Key[] tmp = (Key[]) new Comparable[maxN + 1];
		for (int i = 1; i < N + 1; i++)
			tmp[i] = pq[i];
		pq = tmp;
	}
	public void insert(Key v) {
		if (N == pq.length - 1)
			resize(N * 2);
		pq[++N] = v;
		swim(N);
	}
	public Key delMax() {
		Key max = pq[1];
		exch(1, N--);
		pq[N + 1] = null;
		if (N > 0 && N == pq.length / 4) resize(pq.length / 2);
		sink(1);
		return max;
	}
	public Key getMax() {
		return pq[1];
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
		MaxPQ<String> maxPQ = new MaxPQ<String>();
		maxPQ.insert("fuck");
		maxPQ.insert("you");
		maxPQ.insert("bitch");
		maxPQ.insert("eat");
		
		StdOut.println(maxPQ.delMax());
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

class MaxPQ2<Key extends Comparable<Key>> {
	private Key[] pq = (Key[]) new Comparable[2];
	private int N = 0;
	public MaxPQ2() {

	}
	public MaxPQ2(int maxN) {
		pq = (Key[]) new Comparable[maxN + 1];
	}
	public MaxPQ2(Key[] a) {
		N = a.length;
		pq = (Key[]) new Comparable[N + 1];
		for (int i = 1; i < pq.length; i++)
			pq[i] = a[i - 1];
		for (int k = pq.length / 2; k >= 1; k--)
			sink(k);
	}
	public void resize(int maxN) {
		Key[] tmp = (Key[]) new Comparable[maxN + 1];
		for (int i = 1; i < N + 1; i++)
			tmp[i] = pq[i];
		pq = tmp;
	}
	public void insert(Key v) {
		if (N == pq.length - 1)
			resize(N * 2);
		pq[++N] = v;
		swim(N);
	}
	public Key delMin() {
		Key max = pq[1];
		exch(1, N--);
		pq[N + 1] = null;
		if (N > 0 && N == pq.length / 4) resize(pq.length / 2);
		sink(1);
		return max;
	}
	public Key getMin() {
		return pq[1];
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
		return pq[i].compareTo(pq[j]) > 0;
	}
	private void exch(int i, int j) {
		Key t = pq[i]; pq[i] = pq[j]; pq[j] = t;
	}
}