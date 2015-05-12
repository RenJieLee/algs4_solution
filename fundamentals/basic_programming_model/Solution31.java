public class Solution31 {
	public static void drawCircle(int N, double p) {
		class Point {
			private double x;
			private double y;
			Point(double x, double y) {
				this.x = x;
				this.y = y;
			}
			public double getX() {
				return x;
			}
			public double getY() {
				return y;
			}
		}
		Point[] points = new Point[N];
		double x = 0.5,
			   y = 0.5,
			   r = 0.5;
		StdDraw.circle(x, y, r);
		StdDraw.setPenRadius(0.025);
		for (int i = 0; i < N; i++) {
			points[i] = new Point(0.5 + r * Math.sin(Math.PI * 2 / N * i), 
				1 - (r - r * Math.cos(Math.PI * 2 / N * i)));
			StdDraw.point(points[i].getX(), points[i].getY());
		}
		StdDraw.setPenRadius(0.005);
		for (int i = 0; i < points.length - 1; i++) {
			for (int j = i + 1; j < points.length; j++)
				if (StdRandom.bernoulli(p))
					StdDraw.line(points[i].getX(), points[i].getY(), 
						points[j].getX(), points[j].getY());
		}
	}
	public static void main(String[] args) {
		drawCircle(6, 0.314);
	}
}