import java.util.*;

public class Solution19 {
	public static int count;
	public static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	private static Comparable[] aux;
	public static int sort(Comparable[] a) {
		aux = new Comparable[a.length];
		sort(a, 0, a.length - 1);
		return count;
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
		//
		aux = new Comparable[a.length];
		//
		for (int k = lo; k <= hi; k++) aux[k] = a[k];
		for (int k = lo; k <= hi; k++) {
			if      			 (i > mid) a[k] = aux[j++];
			else if 			 ( j > hi) {
				map.put(i, j - mid - 1);
				a[k] = aux[i++];
			}
			else if (less(aux[j], aux[i])) {
				//count += j - mid;
				map.put(i, j - mid);
				a[k] = aux[j++];
			}
			else 						   a[k] = aux[i++];
		}
		for (Integer t : map.values()) {
			count += t;
		}
		
		map.clear();
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
		String[] i = {"E", "X", "A", "M", "P", "L", "E"};
		StdOut.println(count);
		//merge(i, 0, 1, 4);
		sort(i);
		StdOut.println(count);
	}
}