public class Solution25 {
}

class InsertionNotExch {
	public static void sort(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			Comparable t = a[i];
			int index = i;
			while (index >= 1 && less(a[i], a[index - 1])) {
				index--;
			}
			for (int j = i; j > index; j--) {
				a[j] = a[j - 1];
			}
			a[index] = t;
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