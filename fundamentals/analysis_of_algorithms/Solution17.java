public class Solution17 {
	public static void main(String[] args) {
		double[] test = { 1.3, 4.7, -9, 34, 0.323, 90.44, 0.232, -11};
		for (double d : max(test))
			StdOut.print(d + " ");
	}
	public static double[] max(double[] a) {
		double[] res = new double[2];
		res[0] = a[0];
		res[1] = a[0];
		for (int i = 0; i < a.length; i++) {
			if (a[i] < res[0])
				res[0] = a[i];
			if (a[i] > res[1])
				res[1] = a[i];
		}
		return res;
	}
}