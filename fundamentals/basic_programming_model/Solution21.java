public class Solution21 {
	public static void main(String[] args) {
		while (StdIn.hasNextLine()) {
			String[] tmp = StdIn.readLine().split(" ");
			String name = tmp[0];
			int n1 = Integer.parseInt(tmp[1]);
			int n2 = Integer.parseInt(tmp[2]);
			System.out.printf("%s %d %d %.3f\n", name, n1, n2, n1 * 1.0 / n2);
		}
	}

}