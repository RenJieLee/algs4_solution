import java.util.Arrays;

public class Solution10 {
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
	public static int rankLessCount(int key, int[] a) {
		int index = rank(key, a);
		while (a[--index] == key)
			;
		return ++index;
	}
	public static int rankSameCount(int key, int[] a) {
		int index = rankLessCount(key, a);
		while (a[++index] == key)
			;
		return index - rankLessCount(key, a);
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