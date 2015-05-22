public class MaxPQ2<Key extends Comparable<Key>> {
	private Key[] a = (Key[]) new Comparable[1];
	private int N = 0;
	public MaxPQ2() {

	}
	public MaxPQ2(int max) {
		resize(max);
	}
	public MaxPQ2(Key[] t) {
		resize(t.length);
		for (int i = 0; i < t.length; i++)
			a[i] = t[i];
	}
	public void insert(Key v) {
		if (N == a.length) resize(2 * a.length);
		int index = N - 1;
		while (index >= 0 && a[index].compareTo(v) > 0) {
			a[index + 1] = a[index];
			index--;
		}
		a[index + 1] = v;
		N++;
	}
	public Key max() {
		return a[N - 1];
	}
	public Key delMax() {
		Key tmp = a[--N];
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
		MaxPQ2<String> maxPQ2 = new MaxPQ2<String>();
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
}