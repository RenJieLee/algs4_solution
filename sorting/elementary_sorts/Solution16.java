import java.util.HashMap;
import java.util.Arrays;

public class Solution16 {
}
class CheckExample {
	public static void sort(Comparable[] a) {

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
		Arrays.sort(a);
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