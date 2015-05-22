public class Solution26 {
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
	public boolean isEmpty() {
		return N == 0;
	}
	public int size() {
		return N;
	}
	private void sink(int k) {
		Key tmp = pq[k];
		//StdOut.println("k in sink(int k): " + pq[k]);
		while (2 * k <= N) {
			int j = 2 * k;

			if (j < N && less(j, j + 1)) j++;
			if (tmp.compareTo(pq[j]) >= 0) break;
			//exch(k, j);
			pq[k] = pq[j];
			k = j;
		}
		pq[k] = tmp;
	}
	private void swim(int k) {
		Key tmp = pq[k];
		while (k > 1 && pq[k / 2].compareTo(tmp) < 0) {
			pq[k] = pq[k / 2];
			k = k / 2;
		}
		pq[k] = tmp;
	}
	private boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}
	private void exch(int i, int j) {
		Key t = pq[i]; pq[i] = pq[j]; pq[j] = t;
	}
	public static void main(String[] args) {
		MaxPQ<String> maxPQ = new MaxPQ<String>(10);
		maxPQ.insert("fuck");
		maxPQ.insert("you");
		maxPQ.insert("bitch");
		maxPQ.insert("eat");
		
		StdOut.println(maxPQ.delMax());
		StdOut.println(maxPQ.delMax());
		StdOut.println(maxPQ.delMax());
		StdOut.println(maxPQ.delMax());
	}
}