import java.util.Arrays;

public class Solution14 {
	public static void main(String[] args) {
		int[] a = In.readInts("1Kints.txt");
		Stopwatch stopwatch = new Stopwatch();
		int n = FourSum.count(a);
		StdOut.println(n + " " + stopwatch.elapsedTime());
	}
}

class FourSum {
	public static int count(int[] a) {
		Arrays.sort(a);
		int cnt = 0;
		int N = a.length;
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				cnt += TwoSumFaster.count(a, j + 1, a.length, -a[i] - a[j]);
			}
		}
		return cnt;
	}
}