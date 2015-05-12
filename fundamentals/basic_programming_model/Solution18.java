public class Solution18 {
	public static int mystery(int a, int b) {
		if (b == 0) return 0;
		if (b % 2 == 0) return mystery(a + a, b / 2);
		return mystery(a + a, b / 2) + a;
	}
	public static int mystery2(int a, int b) {
		if (b == 0) return 0;
		if (b % 2 == 0) return mystery(a * a, b / 2);
		return mystery(a * a, b / 2) * a;
	}
	public static void main(String[] args) {
		System.out.println(mystery2(4, 3));
	}
}