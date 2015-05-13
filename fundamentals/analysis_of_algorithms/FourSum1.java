import java.util.Arrays;

public class FourSum1 {
	public static int count(int[] a) {
		Arrays.sort(a);
		int cnt = 0;
		int N = a.length;
		for (int i = 0; i < N; i++)
			for (int j = i + 1; j < N; j++)
				for (int k = j + 1; k < N; k++)
					for (int l = k + 1; l < N; l++)
						if (a[i] + a[j] + a[k] + a[l] == 0)
							cnt++;
		return cnt;
	}
	public static void main(String[] args) {
		int[] a = In.readInts("1Kints.txt");
		Stopwatch stopwatch = new Stopwatch();
		int n = count(a);
		StdOut.println(n + " " + stopwatch.elapsedTime());
	}
}