import java.util.Arrays;

public class Solution9 {
	public static int rank(int key, int[] a, Counter cn) {
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			cn.increment();
			if 		(key < a[mid]) hi = mid - 1;
			else if (key > a[mid]) lo = mid + 1;
			else 					 return mid;
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] whitelist = In.readInts(args[0]);
		Arrays.sort(whitelist);
		Counter cn = new Counter("Search total");
		while (!StdIn.isEmpty()) {
			int key = StdIn.readInt();
			if (rank(key, whitelist, cn) == -1)
				StdOut.println(key);
		}
		StdOut.println(cn);
	}
}