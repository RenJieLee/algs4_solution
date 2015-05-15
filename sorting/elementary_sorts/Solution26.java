public class Solution26 {
	public static double time1(Double[] a) {
		Stopwatch timer = new Stopwatch();
		Insertion.sort(a);
		return timer.elapsedTime();
	}
	public static double time2(double[] a) {
		Stopwatch timer = new Stopwatch();
		InsertionDouble.sort(a);
		return timer.elapsedTime();
	}
	public static void main(String[] args) {
		
		int N = 1000;
		int T = 100;
		double t1 = 0.0;
		double t2 = 0.0;
		Double[] a = new Double[N];
		double[] b = new double[N];
		for (int t = 0; t < T; t++) {
			for (int i = 0; i < N; i++) {
				a[i] = StdRandom.uniform();
				b[i] = a[i];
			}
			t1 += time1(a);
			t2 += time2(b);
		}
		StdOut.printf("For %d random Doubles\n unpack is ", N);
		StdOut.printf("%.1f times faster than pack\n", t1 / t2);
	}
}

class InsertionDouble {
	public static void sort(double[] a) {
		for (int i = 1; i < a.length; i++) {
			int index = i;
			while (index >= 1 && a[index] < a[index - 1]) {
				exch(a, index, index - 1);
				index--;
			}
		}		
	}
	private static void exch(double[] a, int i, int j) {
		double t = a[i]; a[i] = a[j]; a[j] = t;
	}
	private static void show(double[] a) {
		for (int i = 0; i < a.length; i++) StdOut.print(a[i] + " ");
		StdOut.println();
	}
	public static boolean isSorted(double[] a) {
		for (int i = 1; i < a.length; i++)
			if (a[i] < a[i - 1]) return false;
		return true;
	}
	public static void main(String[] args) {
	}
}