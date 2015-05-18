public class Solution23 {
	public static void main(String[] args) {
		SortCompare.main(args);
	}
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
class Merge {
	private static Comparable[] aux;
	public static void sort(Comparable[] a) {
		aux = new Comparable[a.length];
		sort(a, 0, a.length - 1);
	}
	public static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo) return;
		int mid = lo + (hi - lo) / 2;
		sort(a, lo, mid);
		sort(a, mid + 1, hi);
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

class SortCompare {
	public static double time(String alg, Double[] a) {
		Stopwatch timer = new Stopwatch();
		switch (alg) {
			case "Merge": Merge.sort(a); break;
			case "MergeImprove": MergeImprove.sort(a); break;
		}
		return timer.elapsedTime();
	}
	public static double timeRandomInput(String alg, int N, int T) {
		double total = 0.0;
		Double[] a = new Double[N];
		for (int t = 0; t < T; t++) {
			for (int i = 0; i < N; i++) a[i] = StdRandom.uniform();
			total += time(alg, a);
		}
		return total;
	}
	public static void main(String[] args) {
		/*
		String alg1 = args[0];
		String alg2 = args[1];
		int N = Integer.parseInt(args[2]);
		int T = Integer.parseInt(args[3]);
		*/
		String alg1 = "MergeImprove";
		String alg2 = "Merge";
		int N = 1000000;
		int T = 10;
		double t1 = timeRandomInput(alg1, N, T);
		double t2 = timeRandomInput(alg2, N, T);
		StdOut.printf("For %d random Doubles\n 	%s is ", N, alg1);
		StdOut.printf("%.1f times faster than %s\n", t2 / t1, alg2);
	}
}

class Stopwatch {
	private final long start;
	public Stopwatch() {
		start = System.currentTimeMillis();
	}
	public double elapsedTime() {
		long now = System.currentTimeMillis();
		return (now - start) / 1000.0;
	}
}