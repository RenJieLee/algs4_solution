public class Solution18 {
	public static int partMinIndex(int[] a) {
		return partMinIndexHelp(a, 0, a.length);
	}
	public static int partMinIndexHelp(int[] a, int start, int end) {
		if (end < start)
			return -1;
		int mid = start + (end - start) / 2;
		if (mid == 0 || mid == a.length - 1)
			return -1;
		if (a[mid] < a[mid - 1] && a[mid] < a[mid + 1])
			return mid;
		int leftRes = partMinIndexHelp(a, start, mid - 1);
		if (leftRes != -1)
			return leftRes;
		else
			return partMinIndexHelp(a, mid + 1, end);
	}
	public static void main(String[] args) {
		int[] a = { 3, 2, 4, 10, 10, 12, 14 };
		StdOut.print(partMinIndex(a) + " ");
	}
}