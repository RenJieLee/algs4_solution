public class Solution6 {
	public static void main(String[] args) {
		String[] test = {"a", "c", "d", "b", "e", "f"};
		StdOut.println(select(test, 3));
	}
	public static <Key extends Comparable<Key>> Key select(Key[] a, int k) {
		return select(a, k - 1, 0, a.length - 1);
	}
	public static <Key extends Comparable<Key>> Key select(
		Key[] a, int k, int lo, int hi) {
		int j = partition(a, lo, hi);
		if (j == k)
			return a[k];
		else if (j < k)
			return select(a, k, j + 1, hi);
		else
			return select(a, k, lo, j - 1);
	}
	private static <Key extends Comparable<Key>> int partition(
		Key[] a, int lo, int hi) {
		int i = lo, j = hi + 1;
		Key v = a[lo];
		while (true) {
			while (less(a[++i], v)) if (i == hi) break;
			while (less(v, a[--j])) if (j == lo) break;
			if (i >= j) break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}
	private static <Key extends Comparable<Key>> boolean less(
		Key v, Key w) {
		return v.compareTo(w) < 0;
	}
	private static <Key extends Comparable<Key>> void exch(
		Key[] a, int i, int j) {
		Key t = a[i]; a[i] = a[j]; a[j] = t;
	}
}