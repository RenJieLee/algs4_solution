public class Solution3 {
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		double min = Double.parseDouble(args[1]);
		double max = Double.parseDouble(args[2]);
		Interval2D[] interval2Ds = new Interval2D[N];
		Interval1D[] interval1Ds = new Interval1D[2 * N];
		for (int i = 0; i < interval2Ds.length; i++) {
			interval1Ds[2 * i] = getInterval1D(min, max);
			interval1Ds[2 * i + 1] = getInterval1D(min, max);
			interval2Ds[i] = new Interval2D(interval1Ds[2 * i] , interval1Ds[2 * i + 1]);
			interval2Ds[i].draw();
		}
		for (int i = 0; i < interval2Ds.length - 1; i++)
			for (int j = i + 1; j < interval2Ds.length; j++) {
				
				if (interval2Ds[i].contains(
					new Point2D(interval1Ds[j * 2].left(), 
						interval1Ds[j * 2 + 1].left())) && 
					interval2Ds[i].contains(
					new Point2D(interval1Ds[j * 2].right(), 
						interval1Ds[j * 2 + 1].right())))

					StdOut.println(interval2Ds[i] + " contains " + interval2Ds[j] + "\n");
				
				if (interval2Ds[i].intersects(interval2Ds[j]))
					StdOut.println(interval2Ds[i] + " intersects " + interval2Ds[j] + "\n");
				
			}
	}

	public static Interval1D getInterval1D(double min, double max) {
		while (true) {
			double start = StdRandom.random();
			double end = start + StdRandom.uniform(min, max);
			if (end < 1.0)
				return new Interval1D(start, end);
		}
	}

}