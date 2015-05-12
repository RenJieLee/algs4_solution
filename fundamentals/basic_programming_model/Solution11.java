
public class Solution11 {
	public static void drawBooleanMatrix(boolean[][] B) {
		System.out.print("  ");
		for (int i = 0; i < B[0].length; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		for (int i = 0; i < B.length; i++) {
			System.out.print(i + " ");
			for (int j = 0; j < B[i].length; j++)
				if (B[i][j])
					System.out.print("* ");
				else
					System.out.print("  ");
			System.out.println();
		}
	}
	public static void main(String[] args) {
		boolean[][] b = new boolean[8][6];
		for (int i = 0; i < b.length; i++)
			for (int j = 0; j < b[0].length; j++)
				b[i][j] = StdRandom.bernoulli();
		Solution13.printTrsMatrix(b);
		drawBooleanMatrix(b);
	}
}