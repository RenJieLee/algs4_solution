import java.util.Arrays;

public class Solution22 {
	public static int rank(int key, int[] a) {
		return rank(key, a, 0, a.length - 1, 0);
	}

	public static int rank(int key, int[] a, int lo, int hi, int count) {
		if (lo > hi) return -1;
		int mid = lo + (hi - lo) / 2;
		for (int i = 0; i < count; i++)
			System.out.print("\t");
		System.out.println(lo + " " + hi);
		if (key < a[mid]) return rank(key, a, lo, mid - 1, ++count);
		else if (key > a[mid]) return rank(key, a, mid + 1, hi, ++count);
		else return mid;
	}

	public static void main(String[] args) {
		int[] whitelist = In.readInts(args[0]);
		Arrays.sort(whitelist);
		while (!StdIn.isEmpty()) {
			int key = StdIn.readInt();
			if (rank(key, whitelist) == -1)
				StdOut.println(key);
		}
	}
}