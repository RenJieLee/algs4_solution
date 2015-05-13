public class Solution38 {
	public static double timeTrial(int N) {
		int MAX = 1000000;
		int[] a = new int[N];
		for (int i = 0; i < N; i++) a[i] = StdRandom.uniform(-MAX, MAX);
		long time1 = System.currentTimeMillis();
		int cnt = ThreeSum1.count(a);
		time1 = System.currentTimeMillis() - time1;
		long time2 = System.currentTimeMillis();
		cnt = ThreeSum2.count(a);
		time2 = System.currentTimeMillis() - time2; 
		return time2 / 1.0 / time1;
	}

	public static void main(String[] args) {
		for (int i = 125; i > 0; i += i) {
			System.out.printf("%.5f\n", timeTrial(i));
		}
	}
}

class ThreeSum1 {
	public static int count(int[] a) {
		int N = a.length;
		int cnt = 0;
		for (int i = 0; i < N; i++)
			for (int j = i + 1; j < N; j++) 
				for (int k = j + 1; k < N; k++)
					if (a[i] + a[j] + a[k] == 0)
						cnt++;
		return cnt;
	}
	public static void main(String[] args) {
		int[] a = In.readInts(args[0]);
		StdOut.println(count(a));
	}
}

class ThreeSum2 {
	public static int count(int[] a) {
		int N = a.length;
		int cnt = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) 
				for (int k = 0; k < N; k++)
					if (i < j && j < k)
						if (a[i] + a[j] + a[k] == 0)
							cnt++;
		return cnt;
	}
	public static void main(String[] args) {
		int[] a = In.readInts(args[0]);
		StdOut.println(count(a));
	}
}