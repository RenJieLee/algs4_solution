public class Solution20 {
	public static double getLn(int N) {
		if (N == 1)
			return 0;
		return Math.log(N) + getLn(N - 1);
	}
	public static void main(String[] args) {
		System.out.println(getLn(4));
		System.out.println(Math.log(24));
	}
}