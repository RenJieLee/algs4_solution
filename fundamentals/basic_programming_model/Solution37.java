public class Solution37 {
	public static void main(String[] args) {
		int M = Integer.parseInt(args[0]);
		int N = Integer.parseInt(args[1]);
		int[] tmp = new int[M];
		reback(tmp);
		int[][] judge = new int[M][M];
		for (int i = 0; i < N; i++) {
			shuffleBad(tmp);
			for (int j = 0; j < tmp.length; j++) {
				judge[tmp[j]][j]++;
			}
			reback(tmp);
		}

		for (int i = 0; i < judge.length; i++) {
			for (int j = 0; j < judge[0].length; j++)
				System.out.print(judge[i][j] * 1.0 / (N / M) + " ");
			System.out.println();
		}

	}
	public static void shuffle(int[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			int r = i + StdRandom.uniform(N - i);
			int temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}
	public static void shuffleBad(int[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			int r = StdRandom.uniform(N);
			int temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}
	public static void reback(int[] a) {
		for (int i = 0; i < a.length; i++) {
			a[i] = i;
		}
	}
}