public class Solution19 {
	public static long F(int N) {
		if (N == 0) return 0;
		if (N == 1) return 1;
		return F(N - 1) + F(N - 2);
	}
	public static void main(String[] args) {
		for (int N = 0; N < 50; N++)
			StdOut.println(N + " " + FChanged(N));
	}
	public static long FChanged(int N) {
		if (N == 0) return 0;
		if (N == 1) return 1;
		long[] tmp = new long[N];
		tmp[0] = 0;
		tmp[1] = 1;
		for (int i = 2; i < tmp.length; i++)
			tmp[i] = tmp[i - 1] + tmp[i - 2];
		return tmp[N - 1] + tmp[N - 2];
	}
}