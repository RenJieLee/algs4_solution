public class Solution19 {
	public static int count = 0;
	public static void main(String[] args) {
		int[][] a = new int[100][100];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				//a[i][j] = StdRandom.uniform(0, 10);
				a[i][j] = i + j;
				StdOut.print(a[i][j] + " ");
			}
			StdOut.println();
		}
		Stopwatch stopwatch = new Stopwatch();
		for (int i : partMatrixMinIndex(a))
			StdOut.print(i + " ");
		StdOut.print(" " + stopwatch.elapsedTime() + " " + count);
	}
	public static int[] partMatrixMinIndex(int[][] a) {
		int[] res = new int[2];
		for (int i = 1; i < a.length - 1; i++) {
			int j = Solution18.partMinIndex(a[i]);
			if (j != -1 && 
				a[i][j] < a[i - 1][j] && 
				a[i][j] < a[i + 1][j]) {
				res[0] = i;
				res[1] = j;
				return res;
			}
		}
		res[0] = -1;
		res[1] = -1;
		return res;
	}
}