
public class Solution13 {
	public static void printTrsMatrix(boolean[][] B) {
		for (int i = 0; i < B[0].length; i++) {
			for (int j = 0; j < B.length; j++) {
				System.out.print(B[j][i] + " ");
			}
			System.out.println();
		}
	}
}