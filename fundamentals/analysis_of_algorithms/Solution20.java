public class Solution20 {
	public static int partMaxIndex(int[] a) {
		return partMaxIndexHelp(a, 0, a.length);
	}
	public static int partMaxIndexHelp(int[] a, int start, int end) {
		if (end < start)
			return -1;
		int mid = start + (end - start) / 2;
		if (mid == 0 || mid == a.length - 1)
			return -1;
		if (a[mid] > a[mid - 1] && a[mid] > a[mid + 1])
			return mid;
		int leftRes = partMaxIndexHelp(a, start, mid - 1);
		if (leftRes != -1)
			return leftRes;
		else
			return partMaxIndexHelp(a, mid + 1, end);
	}
	public static void main(String[] args) {
		int[] a = { 1, 2, 4, 10, 16, 26, 7 };
		StdOut.print(partMaxIndex(a) + " ");
		StdOut.print(find(a, 7) + " ");
		
	}
	public static int find(int[] a, int num) {
		int mid = partMaxIndex(a);
		int[] left = new int[mid];
		int[] right = new int[a.length - mid];
		for (int i = 0; i < a.length; i++) {
			if (i < mid)
				left[i] = a[i];
			else
				right[a.length - 1 - i] = a[i];
		}
		int tmp = BinarySearch.rank(num, left);
		if (tmp != -1)
			return tmp;
		tmp = BinarySearch.rank(num, right);
		if (tmp != -1)
			return a.length - 1 - tmp;
		return -1;
	}
}