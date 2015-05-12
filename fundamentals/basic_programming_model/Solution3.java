public class Solution3 {
	public static void main(String[] args) {
		int n1 = Integer.parseInt(args[0]);
		int n2 = Integer.parseInt(args[1]);
		int n3 = Integer.parseInt(args[2]);
		if (judgeThreeNumberIsEqual(n1, n2, n3))
			System.out.println("equal");
		else
			System.out.println("not equal");
	}
	public static boolean judgeThreeNumberIsEqual(int n1, int n2, int n3) {
		if (n1 == n2 && n1 == n3)
			return true;
		return false;
	}
}