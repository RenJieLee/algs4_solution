public class Solution8 {
	public static double optCompares(int N) {
		return optComparesHelp(N) * 1.0 / N;
	}
	public static int optComparesHelp(int N) {
		int res = 0;
		int num = 1;
		int t = 1;
		while (N > 0) {
			if (N - t > 0) {
				N -= t;
				res += num * t;
				t *= 2;
				num++;
			} else {
				res += N * num;
				N = 0;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		StdOut.println(optCompares(8));
	}
}
