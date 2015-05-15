public class Solution27 {
	public static void main(String[] args) {
		SortCompare.main(args);
	}
}

class SortCompare {
	public static double time(String alg, Double[] a) {
		Stopwatch timer = new Stopwatch();
		switch (alg) {
			case "Insertion": Insertion.sort(a); break;
			case "Selection": Selection.sort(a); break;
			case "InsertionNotExch": InsertionNotExch.sort(a); break;
			case "Shell": Shell.sort(a); break;
		}
		return timer.elapsedTime();
	}
	public static double timeRandomInput(String alg, int N, int T) {
		double total = 0.0;
		Double[] a = new Double[N];
		for (int t = 0; t < T; t++) {
			for (int i = 0; i < N; i++) a[i] = StdRandom.uniform();
			total += time(alg, a);
		}
		return total;
	}
	public static void main(String[] args) {
		/*
		String alg1 = args[0];
		String alg2 = args[1];
		int N = Integer.parseInt(args[2]);
		int T = Integer.parseInt(args[3]);
		*/
		String alg1 = "Shell";
		String alg2 = "Insertion";
		
		int T = 100;
		for (int N = 128; N > 0; N += N) {
			double t1 = timeRandomInput(alg1, N, T);
			double t2 = timeRandomInput(alg2, N, T);
			StdOut.printf("For %d random Doubles\n 	%s is ", N, alg1);
			StdOut.printf("%.1f times faster than %s\n", t2 / t1, alg2);	
		}
		
	}
}

class Stopwatch {
	private final long start;
	public Stopwatch() {
		start = System.currentTimeMillis();
	}
	public double elapsedTime() {
		long now = System.currentTimeMillis();
		return (now - start) / 1000.0;
	}
}