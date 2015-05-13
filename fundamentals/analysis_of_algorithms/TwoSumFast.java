import java.util.Arrays;

public class TwoSumFast {
	public static int count(int[] a) {
		Arrays.sort(a);
		int N = a.length;
		int cnt = 0;
		for (int i = 0; i < N; i++)
			if (a[i] <= 0 && BinarySearch.rank(-a[i],a) > i)
				cnt++;
		return cnt;
	}
	public static void main(String[] args) {
		int[] a = In.readInts("8Kints.txt");
		Stopwatch stopwatch = new Stopwatch();
		int n = count(a);
		StdOut.println(n + " " + stopwatch.elapsedTime());
	}
}