import java.util.Arrays;

public class Solution8 {
	public static int count(int[] a) {
		Arrays.sort(a);
		int res = 0;
		for (int i = 1; i < a.length; i++) {
			int n = 0;
			while (a[i] == a[i - 1]) {
				i++;
				n++;
				if (i >= a.length)
					break;
			}
			res += countHelp(n);
		}
		return res;
	}
	public static int countHelp(int n) {
		int temp = n;
		for (int i = 1; i < n; i++)
			temp *= i;
		return temp;
	}
	public static void main(String[] args) {
		//int[] a = In.readInts(args[0]);
		int[] a = {7, 1, 1, 1, 4, 4, 2, 2, 2, 2};
		StdOut.println(count(a));
	}
}