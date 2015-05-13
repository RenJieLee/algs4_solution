import java.util.Arrays;

public class Solution39 {
	public static void main(String[] args) {
		DoublingRatio.main(args);
	}
}

class DoublingRatio {
	public static double timeTrial(int N) {
		int MAX = 1000000;
		int[] a = new int[N];
		for (int i = 0; i < N; i++) a[i] = StdRandom.uniform(-MAX, MAX);
		long time = System.currentTimeMillis();
		int cnt = ThreeSumFaster.count(a);
		return (System.currentTimeMillis() - time) / 1000.0;
	}

	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		double prev = 0.0;
		for (int j = 0; j < N; j++) prev += timeTrial(125);
		for (int i = 250; true; i += i) {
			double time = 0.0;
			for (int j = 0; j < N; j++) time += timeTrial(i);
			StdOut.printf("%6d %7.1f", i, time / N);
			StdOut.printf("%5.1f\n", time / prev);
			prev = time;
		}
	}
}

class ThreeSumFaster {
	public static int count(int[] a) {
		Arrays.sort(a);
		int N = a.length;
		int cnt = 0;
		for (int i = 0; i < N; i++)
			cnt += TwoSumFaster.count(a, i + 1, a.length, -a[i]); 
		return cnt;
	}
}

class TwoSumFaster {
	public static int count(int[] a) {
		int N = a.length;
		int cnt = 0;
		for (int i = 0, j = a.length - 1; j > i; ) {
			if (a[i] + a[j] > 0)
				j--;
			else if (a[i] + a[j] < 0)
				i++;
			else {
				cnt++;
				if (a[j] == a[j - 1])
					j--;
				else if (a[i] == a[i + 1])
					i++;
				else {
					j--;
					i++;
				}
			}
		}
		return cnt;
	}
	public static int count(int[] a, int start, int end, int num) {
		int cnt = 0;
		for (int i = start, j = end - 1; j > i; ) {
			if (a[i] + a[j] > num)
				j--;
			else if (a[i] + a[j] < num)
				i++;
			else {
				cnt++;
				if (a[j] == a[j - 1])
					j--;
				else if (a[i] == a[i + 1])
					i++;
				else {
					j--;
					i++;
				}
			}
		}
		return cnt;
	}
}