import java.util.ArrayList;

public class Solution11 {

}

class ShellSave {
	public static void sort(Comparable[] a) {
		int N = a.length;
		ArrayList<Integer> list = new ArrayList<Integer>();
		//int h = 1;
		//while (h < N / 3) h = 3 * h + 1;
		for (int h = 1; h < N / 3; h = 3 * h + 1) list.add(h);
		for (int i = list.size() - 1; i >= 0; i--) {
			int h = list.get(i);
			for (int j = h; j < N; j++) {
				int index = j;
				while (index >= h && less(a[index], a[index - h])) {
					exch(a, index, index - h);
					index -= h;
				}
			}
		}
		/*
		while (h >= 1) {
			for (int i = h; i < N; i++) {
				int index = i;
				while (index >= h && less(a[index], a[index - h])) {
					exch(a, index, index - h);
					index -= h;
				}
			}
			h /= 3;
		}
		*/
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