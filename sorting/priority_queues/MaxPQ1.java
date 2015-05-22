public class MaxPQ1<Key extends Comparable<Key>> {
	private Key[] a = (Key[]) new Comparable[1];
	private int N = 0;
	public MaxPQ1() {

	}
	public MaxPQ1(int max) {
		resize(max);
	}
	public MaxPQ1(Key[] t) {
		resize(t.length);
		for (int i = 0; i < t.length; i++)
			a[i] = t[i];
	}
	public void insert(Key v) {
		if (N == a.length) resize(2 * a.length);
		a[N++] = v;
	}
	public Key max() {
		Key k = a[N - 1];
		for (int i = N - 2; i >= 0; i--)
			if (a[i].compareTo(k) > 0)
				k = a[i];
		return k;
	}
	public Key delMax() {
		int index = N - 1;
		for (int i = N - 2; i >= 0; i--)
			if (a[i].compareTo(a[index]) > 0)
				index = i;
		Key tmp = a[index];
		a[index] = a[--N];
		a[N] = null;
		if (N > 0 && N == a.length / 4) resize(a.length / 2);

		return tmp;
	}
	public boolean isEmpty() {
		return N == 0;
	}
	public int size() {
		return N;
	}
	private void resize(int max) {
		Key[] temp = (Key[]) new Comparable[max];
		for (int i = 0; i < N; i++)
			temp[i] = a[i];
		a = temp;
	}
	public static void main(String[] args) {
		MaxPQ1<String> maxPQ1 = new MaxPQ1<String>();
		maxPQ1.insert("P");
		maxPQ1.insert("Q");
		maxPQ1.insert("E");
		StdOut.println(maxPQ1.delMax());
		maxPQ1.insert("X");
		maxPQ1.insert("A");
		maxPQ1.insert("M");
		StdOut.println(maxPQ1.delMax());
		maxPQ1.insert("P");
		maxPQ1.insert("L");
		maxPQ1.insert("E");
		StdOut.println(maxPQ1.delMax());
	}
}