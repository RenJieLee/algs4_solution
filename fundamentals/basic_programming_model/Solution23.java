import java.util.Arrays;

public class Solution23 {
	public static int rank(int key, int[] a) {
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if 		(key < a[mid]) hi = mid - 1;
			else if (key > a[mid]) lo = mid + 1;
			else 					 return mid;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] whitelist = In.readInts(args[0]);
		boolean judge = true;
		if (args[1].equals("+"))
			judge = true;
		else if (args[1].equals("-"))
			judge = false;
		Arrays.sort(whitelist);
		while (!StdIn.isEmpty()) {
			int key = StdIn.readInt();
			if (judge && rank(key, whitelist) == -1)
				StdOut.println(key);
			if (!judge && rank(key, whitelist) >= 0)
				StdOut.println(key);
		}
	}
}