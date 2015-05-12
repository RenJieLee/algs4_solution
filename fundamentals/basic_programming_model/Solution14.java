public class Solution14 {
	public static int lg(int N) {
		if (N <= 0)
			throw new RuntimeException();
		if (N == 1)
			return 0;
		else if (N == 2)
			return 1;
		else 
			return 1 + lg(N / 2);
	}
	public static void main(String[] args) {
		System.out.println(lg(1));
		System.out.println(lg(2));
		System.out.println(lg(3));
		System.out.println(lg(4));
		System.out.println(lg(15));
		System.out.println(lg(2147483647));
	}
}