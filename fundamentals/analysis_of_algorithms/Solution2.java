public class Solution2 {
	public static void main(String[] args) {
		
	}
}

class ThreeSum {
	public static int count(int[] a) {
		int N = a.length;
		int cnt = 0;
		for (int i = 0; i < N; i++)
			for (int j = i + 1; j < N; j++) {
				if (isOverFlow(a[i], a[j]))
					continue;
				for (int k = j + 1; k < N; k++) {
					if (isOverFlow(a[i] + a[j], a[k]))
						continue;
					if (a[i] + a[j] + a[k] == 0)
						cnt++;
				}
			}
		return cnt;
	}
	public static void main(String[] args) {
		int[] a = In.readInts(args[0]);
		StdOut.println(count(a));
	}
	public static boolean isOverFlow(int l1, int l2) {
		if ((l1 < 0 && l2 > 0) || (l1 > 0 && l2 < 0))
			return false;
		if (l1 > 0 && (l1 + l2) < 0)
			return true;
		if (l1 < 0 && (l1 + l2) > 0)
			return true;
		return false;
	}
}