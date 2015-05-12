import java.util.ArrayList;

public class Solution32 {
	public static void drawHis(int N, double l, double r, double[] inp) {
		int[] his = new int[N];
		double judge = (r - l) / N;
		for (double d : inp) {
			if (d <= l || d >= r)
				;
			else {
				his[(int)((d - l) / judge)]++;
			}
		}
		double max = (double)StdStats.max(his);
		for (int i = 0; i < N; i++) {
			double x = 1.0 * i / N;
			double y = his[i] / max / 2.0;
			double rw = 0.5 / N;
			double rh = his[i] / max / 2.0;
			StdDraw.filledRectangle(x, y, rw, rh);
		}
	}
	public static void main(String[] args) {
		
		
		ArrayList<Double> list = new ArrayList<Double>();
		while (!StdIn.isEmpty())
			list.add(StdIn.readDouble());
		double[] inp = new double[list.size()];
		int cnt = 0;
		for (double d : list) {
			inp[cnt] = d;
			cnt++;
		}
		int N = Integer.parseInt(args[0]);
		double l = Double.parseDouble(args[1]);
		double r = Double.parseDouble(args[2]);
		drawHis(N, l, r, inp);
		
	}
}