public class Solution20 {
	public static void main(String[] args) {
		Merge.main(args);
	}
}

class Merge {
	private static int[] aux;

	public static int[] sort(Comparable[] a) {
		aux = new int[a.length];
		int[] perm = new int[a.length];
		for (int i = 0; i < a.length; i++) perm[i] = i;
		sort(a, 0, a.length - 1, perm);
		return perm;
	}
	public static void sort(Comparable[] a, int lo, int hi, int[] perm) {
		if (hi <= lo) return;
		int mid = lo + (hi - lo) / 2;
		sort(a, lo, mid, perm);
		sort(a, mid + 1, hi, perm);
		merge(a, lo, mid, hi, perm);
	}
	public static void merge(Comparable[] a, int lo, int mid, int hi, int[] perm) {
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) aux[k] = perm[k];
		for (int k = lo; k <= hi; k++) {
			if      			 (i > mid) perm[k] = aux[j++];
			else if 			 ( j > hi) perm[k] = aux[i++];
			else if (less(a[aux[j]], a[aux[i]])) perm[k] = aux[j++];
			else 						   perm[k] = aux[i++];
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
		int[] perm = sort(a);
		assert isSorted(a);
		//show(a);
		for (int i = 0; i < perm.length; i++)
			StdOut.print(a[perm[i]] + " ");
	}
}