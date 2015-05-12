public class Solution27 {
	static long count = 0;
	public static double binomial(int N, int k, double p) {
		count++;
		if (N == 0 && k == 0) return 1.0;
		if (N < 0 || k < 0) return 0.0;
		return (1.0 - p) * binomial(N - 1, k, p) + p * binomial(N - 1, k - 1, p);
	}
	public static void main(String[] args) {
		double sum = 0.0;
		for (int i = 0; i <= 100; i++)
			sum += binomialChanged(100, i, 0.25);

		System.out.println(sum);
		System.out.println(binomialChanged(100, 50, 0.25));
		//System.out.println(count);
	}
	public static double binomialChanged(int N, int k, double p) {
		if (k == 0) return Math.pow((1 - p), N * 1.0);
		double[][] tmp = new double[N][k + 1];
		tmp[0][0] = 1.0;
		for (int i = 1; i < tmp[0].length; i++) {
			tmp[0][i] = 0.0;
		}
		for (int i = 1; i < tmp.length; i++) {
			tmp[i][0] = Math.pow((1 - p), i * 1.0);
		}
		for (int i = 1; i < tmp.length; i++) {
			for (int j = 1; j < tmp[0].length; j++) {
				tmp[i][j] = (1.0 - p) * tmp[i - 1][j] + p * tmp[i - 1][j - 1];
			}
		}
		return (1.0 - p) * tmp[N - 1][k] + p * tmp[N - 1][k - 1];
	}
}