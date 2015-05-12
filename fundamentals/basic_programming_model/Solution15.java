public class Solution15 {
	public static int[] histogram(int[] a, int M) {
		int[] res = new int[M];
		for (int i = 0; i < a.length; i++) {
			res[a[i]]++;
		}
		return res;
	}

	public static void main(String[] args) {
		int[] a = new int[200];
		for (int i = 0; i < a.length; i++)
			a[i] = StdRandom.uniform(a.length);
		int[] res = histogram(a, a.length);
		int sum = 0;
		for (int i = 0; i < res.length; i++) {
			sum += res[i];
		}
		System.out.println(sum == a.length);
	}
}