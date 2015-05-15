import java.util.ArrayList;

public class Solution12 {
	public static void doubleTest() {
		for (int i = 100; true; i *= 10) {
			Double[] test = new Double[i];
			for (int j = 0; j < i; j++) test[j] = StdRandom.uniform();
			ShellSaveCount.sort(test);
		}
	}
	public static void main(String[] args) {
		Solution12.doubleTest();
	}
}

class ShellSaveCount {
	public static void sort(Comparable[] a) {
		int N = a.length;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int h = 1; h < N / 3; h = 3 * h + 1) list.add(h);
		for (int i = list.size() - 1; i >= 0; i--) {
			int h = list.get(i);
			int count  = 0;
			for (int j = h; j < N; j++) {
				int index = j;
				count++;
				while (index >= h && less(a[index], a[index - h])) {
					exch(a, index, index - h);
					index -= h;
					count++;
				}
			}
			StdOut.println(h + " " + count / a.length);
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