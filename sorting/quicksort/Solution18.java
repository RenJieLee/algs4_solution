import java.util.ArrayList;

public class Solution18 {
	public static void main(String[] args) {
		
	}
}	


class QuickThreeSample {
	public static void sort(Comparable[] a) {
		StdRandom.shuffle(a);
		sort(a, 0, a.length - 1);
	}
	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo) return;
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}
	private static int partition(Comparable[] a, int lo, int hi) {
		int i = lo, j = hi + 1;
		takeSmaple(a, lo, hi);
		Comparable v = a[lo];
		while (true) {
			while (less(a[++i], v)) if (i == hi) break;
			while (less(v, a[--j])) if (j == lo) break;
			if (i >= j) break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}
	private static void takeSmaple(Comparable[] a, int lo, int hi) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(StdRandom.uniform(lo, lo + (hi - lo) / 3));
		list.add(StdRandom.uniform(lo + (hi - lo) / 3, lo + (hi - lo) * 2 / 3));
		list.add(StdRandom.uniform(lo + (hi - lo) * 2 / 3, hi));
		exch(a, lo, getSampleIndex(a, list, 2));
	}
	public static int getSampleIndex(Comparable[] a, ArrayList<Integer> i, int k) {
		//if (i.size() == 1) return i.get(0);
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		ArrayList<Integer> l3 = new ArrayList<Integer>();
		int old = i.remove(0);
		l2.add(old);
		while (!i.isEmpty()) {
			int tmp = i.remove(0);
			if (a[tmp].compareTo(a[old]) == 0) l2.add(tmp);
			else if (a[tmp].compareTo(a[old]) < 0) l1.add(tmp);
			else l3.add(tmp);
		}
		if (l1.size() >= k) return getSampleIndex(a, l1, k);
		else if (l1.size() + l2.size() >= k) return l2.get(0);
		else return getSampleIndex(a, l3, k - l1.size() - l2.size());
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