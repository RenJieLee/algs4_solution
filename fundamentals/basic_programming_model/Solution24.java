public class Solution24 {
	public static int euclid(int p, int q) {
		return euclid(p, q, 0);
	}
	public static int euclid(int p, int q, int count) {
		for (int i = 0; i < count; i++)
			System.out.print("\t");
		System.out.println(p + " " + q);
		if (q == 0) return p;
		int r = p % q;
		return euclid(q, r, ++count);
	}
	public static int gcd(int p, int q) {
		if (q == 0) return p;
		int r = p % q;
		return gcd(q, r);
	}
	public static void main(String[] args) {
		euclid(1111111, 1234567);
	}
}