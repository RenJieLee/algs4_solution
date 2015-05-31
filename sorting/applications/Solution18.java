import java.util.HashMap;
import java.util.Arrays;

public class Solution18 {
	public static void main(String[] args) {
		CheckExample.main(args);
	}
}
class CheckExample {
	public static void sortAndCheck(Comparable[] a) {
		class SaveIndex implements Comparable<SaveIndex> {
			Comparable c;
			int i;
			public SaveIndex(Comparable c, int i) {
				this.c = c;
				this.i = i;
			}
			public int compareTo(SaveIndex s) {
				if (c.compareTo(s.c) > 0)
					return 1;
				else if (c.compareTo(s.c) < 0)
					return -1;
				else if (i < s.i)
					return -1;
				else if (i > s.i)
					return 1;
				return 0;
			}
		}
		SaveIndex[] tmp = new SaveIndex[a.length];
		for (int i = 0; i < a.length; i++)
			tmp[i] = new SaveIndex(a[i], i);
		sort(tmp);
		for (int i = 0; i < a.length; i++)
			a[i] = tmp[i].c;
	}
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
	public static boolean check(Comparable[] a) {
		HashMap<Comparable, Integer> hashMap = new HashMap<Comparable, Integer>();
		for (Comparable c : a) {
			if (hashMap.get(c) == null) {
				hashMap.put(c, 1);
			} else {
				hashMap.put(c, hashMap.get(c) + 1);
			}
		}
		sortAndCheck(a);
		if (!isSorted(a)) return false;
		for (Comparable c : a) {
			if (hashMap.get(c) == null) {
				//hashMap.put(c, -1);
				return false;
			} else {
				hashMap.put(c, hashMap.get(c) - 1);
			}
		}
		for (Integer i : hashMap.values()) if (i != 0) return false;
		class SaveIndex implements Comparable<SaveIndex> {
			Comparable c;
			int i;
			public SaveIndex(Comparable c, int i) {
				this.c = c;
				this.i = i;
			}
			public int compareTo(SaveIndex s) {
				return c.compareTo(s.c);
			}
		}
		SaveIndex[] tmp = new SaveIndex[a.length];
		for (int i = 0; i < a.length; i++)
			tmp[i] = new SaveIndex(a[i], i);
		sortAndCheck(tmp);
		for (int i = 1; i < a.length; i++) {
			if (tmp[i].c.compareTo(tmp[i - 1].c) == 0)
				if (tmp[i].i < tmp[i - 1].i)
					return false;
		}
		return true;
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
		StdOut.println(check(a));
		assert isSorted(a);
		show(a);
	}
}