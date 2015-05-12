public class Solution2 {
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		Interval1D[] interval1Ds = new Interval1D[N];
		for (int i = 0; i < N; i++) {
			interval1Ds[i] = new Interval1D(StdIn.readDouble(), StdIn.readDouble());
		}
		for (int i = 0; i < interval1Ds.length - 1; i++)
			for (int j = i + 1; j < interval1Ds.length; j++)
				if (interval1Ds[i].intersects(interval1Ds[j]))
					StdOut.println(interval1Ds[i] + " " + interval1Ds[j]);
	}
}