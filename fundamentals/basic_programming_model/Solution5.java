public class Solution5 {
	public static void testTwoDouble(double x, double y) {
		if (x > 0 && x < 1 && y > 0 && y < 1)
			System.out.println("true");
		else
			System.out.println("false");
	}
	public static void main(String[] args) {
		testTwoDouble(0.4, 0.314);
		testTwoDouble(0.1, 3.14);
	}
}