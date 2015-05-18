public class Solution16 {
	private static Comparable[] aux;
	public static void sort(Comparable[] a) {
		int N = a.length;
		aux = new Comparable[N];
		int start = 0;
		while (true) {
			//int start = 0;
			int end = start + 1;
			while (end < N && !less(a[end], a[end - 1])) end++;
			int mid = end - 1;
			if (mid == N - 1) break;
			end++;
			while (end < N && !less(a[end], a[end - 1])) end++;
			end--;
			merge(a, start, mid, end);
			if (end == N -1) {
				start = 0;
			} else {
				start = end + 1;
			}
		}
	}
	public static void merge(Comparable[] a, int lo, int mid, int hi) {
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) aux[k] = a[k];
		for (int k = lo; k <= hi; k++) {
			if      			 (i > mid) a[k] = aux[j++];
			else if 			 ( j > hi) a[k] = aux[i++];
			else if (less(aux[j], aux[i])) a[k] = aux[j++];
			else 						   a[k] = aux[i++];
		}
	}
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i]; a[i] = a[j]; a[j] = t;
	}
	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) StdOut.print(a[i] + " ");
		StdOut.println();
	}
	public static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++)
			if (less(a[i], a[i - 1])) return false;
		return true;
	}
	public static void main(String[] args) {
		String[] a = In.readStrings();
		sort(a);
		assert isSorted(a);
		show(a);
	}
}