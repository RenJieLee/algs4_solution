import java.util.Arrays;

public class Solution16 {
	public static void main(String[] args) {
		double[] test = { 1.3, 4.7, -9, 34, 0.323, 90.44, 0.232, -11};
		for (double d : min(test))
			StdOut.print(d + " ");
	}
	public static double[] min(double[] a) {
		Arrays.sort(a);
		double[] res = new double[2];
		res[0] = a[0];
		res[1] = a[1];
		double min = a[1] - a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] - a[i - 1] < min) {
				min = a[i] - a[i - 1];
				res[1] = a[i];
				res[0] = a[i - 1];
			}
		}
		return res;
	}
}