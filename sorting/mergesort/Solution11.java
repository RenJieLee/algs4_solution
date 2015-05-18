public class Solution11 {

}

class MergeImprove {
	private static Comparable[] aux;
	private static Comparable[] save;
	public static void sort(Comparable[] a) {
		aux = new Comparable[a.length];
		sort(a, 0, a.length - 1);
	}
	public static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo) return;
		if (hi - lo < 15) {
			Insertion.sort(a, lo, hi);
			return;
		}
		int mid = lo + (hi - lo) / 2;
		sort(a, lo, mid);
		sort(a, mid + 1, hi);
		if (!less(a[mid + 1], a[mid])) return;
		merge(a, lo, mid, hi);
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

class Insertion {
	public static void sort(Comparable[] a) {
		/*
		int N = a.length;
		for (int i = 1; i < N; i++) {
			for (int j = i; j > 0 && less(a[j], a[j - 1]); j--)
				exch(a, j, j - 1);
		}
		*/
		for (int i = 1; i < a.length; i++) {
			int index = i;
			while (index >= 1 && less(a[index], a[index - 1])) {
				exch(a, index, index - 1);
				index--;
			}
		}		
	}
	public static void sort(Comparable[] a, int lo, int hi) {
		for (int i = lo + 1; i < hi + 1; i++) {
			int index = i;
			while (index >= lo + 1 && less(a[index], a[index - 1])) {
				exch(a, index, index - 1);
				index--;
			}
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