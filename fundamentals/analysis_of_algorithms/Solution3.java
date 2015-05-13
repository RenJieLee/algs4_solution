public class Solution3 {
	public static void main(String[] args) {
		
	}
}

class DoublingTest {
	public static double timeTrial(int N) {
		int MAX = 1000000;
		int[] a = new int[N];
		for (int i = 0; i < N; i++)
			a[i] = StdRandom.uniform(-MAX, MAX);
		Stopwatch timer = new Stopwatch();
		int cnt = ThreeSum.count(a);
		return timer.elapsedTime();
	}
	public static void main(String[] args) {		
	}
	public static void draw() {
		StdDraw.setXscale(0, 8000.0);
		StdDraw.setYscale(0, 50.0);		
		StdDraw.setPenRadius(0.01);
		for (int N = 250; N < 8000; N += N) {
			double time = timeTrial(N);
			StdDraw.point(N * 1.0, time);
		}
	}
	public static void draw2() {
		StdDraw.setXscale(Math.log(1000.0) / Math.log(2.0), 
			Math.log(8000.0) / Math.log(2.0));
		StdDraw.setYscale(0, Math.log(50.0) / Math.log(2.0));	
		StdDraw.setPenRadius(0.01);
		for (int N = 1000; N < 8000; N += N) {
			double time = timeTrial(N);
			StdDraw.point(Math.log(N * 1.0) / Math.log(2.0), Math.log(time) / Math.log(2.0));
		}
	}
}