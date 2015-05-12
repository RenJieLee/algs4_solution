public class Solution35 {
	public static void main(String[] args) {
		int SIDES = 6;
		double[] dist = new double[2 * SIDES + 1];
		for (int i = 1; i <= SIDES; i++)
			for (int j = 1; j <= SIDES; j++)
				dist[i + j] += 1.0;
		for (int k = 2; k <= 2 * SIDES; k++) {
			dist[k] /= 36.0;
			//System.out.println(dist[k]);
		}
		int N = 1000000;//Integer.parseInt(args[0]);
		int[] temp = new int[N];
		for (int i = 0; i < N; i++)
			temp[i] = (int)(Math.random() * 6 + 1) + (int)(Math.random() * 6 + 1);
		int[] his = Solution15.histogram(temp, 13);
		for (int i = 2; i < his.length; i++) {
			System.out.println(his[i] + " " + his[i] * 1.0 / N);
			double sub = his[i] * 1.0 / N - dist[i];
			StdOut.printf("%.6f\n", sub);
		}
	}
}