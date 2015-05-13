public class Solution23 {
	public static void main(String[] args) {
		int N = 100;
		int F = 40;
		//int F = Integer.parseInt(args[0]);
		boolean[] isCrush = new boolean[N];
		for (int i = 0; i < N; i++)
			if (i < F)
				isCrush[i] = false;
			else
				isCrush[i] = true;
		StdOut.println(judge(isCrush));
	}
	public static int judge(boolean[] isCrush) {
		int low = 0;
		int hi = isCrush.length - 1;
		int mid;
		while (hi >= low) {
			mid = low + (hi - low) / 2;
			if (!isCrush[mid]) {
				if (isCrush[mid + 1])
					return mid;
			}
		}
		return 100;
	}
}