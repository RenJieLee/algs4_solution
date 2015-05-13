import java.util.Arrays;

public class Solution15 {
	public static void main(String[] args) {
		int[] a = In.readInts("4Kints.txt");
		Stopwatch stopwatch = new Stopwatch();
		int n = ThreeSumFaster.count(a);
		StdOut.println(n + " " + stopwatch.elapsedTime());
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