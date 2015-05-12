import java.util.Arrays;

public class Solution1 {
	
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		Point2D[] points = new Point2D[N];
		for (int i = 0; i < N; i++) {
			points[i] = new Point2D(Math.random(), Math.random());
			points[i].draw();
		}
		Arrays.sort(points);
		double minDistance = points[1].distanceTo(points[0]);
		int minIndex0 = 0;
		int minIndex1 = 1;
		
		for (int i = 1; i < points.length; i++) {
			double distance = points[i].distanceTo(points[i - 1]);
			if (distance < minDistance) {
				minDistance = distance;
				minIndex0 = i - 1;
				minIndex1 = i;
			}
		}

		StdDraw.setPenColor(StdDraw.RED);
		points[minIndex0].drawTo(points[minIndex1]);
	}
}