

public class Solution30 {
	public static boolean[][] getMatrix(int N, int M) {
		boolean[][] res = new boolean[N][M];
		for (int i = 0; i < res.length; i++)
			for (int j = 0; j < res[0].length; j++)
				if (Solution24.gcd(i, j) == 1)
					res[i][j] = true;
				else
					res[i][j] = false;
		return res;
	}
	public static void main(String[] args) {
		Solution11.drawBooleanMatrix(getMatrix(8, 7));
	}
}