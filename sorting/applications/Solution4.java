import java.util.Arrays;

public class Solution4 {
	public static void main(String[] args) {
		String[] test = {"f", "f", "t", "g", "g", "h"};
		for (String s : dedup(test))
			StdOut.println(s);		
	}

	public static String[] dedup(String[] a) {
		if (a == null || a.length <= 1) return a;
		Arrays.sort(a);
		int cnt = 0;
		for (int i = 1; i < a.length; i++) {
			if (a[i].equals(a[i - 1])) {
				cnt++;
			}
		}
		String[] res = new String[a.length - cnt];
		int index = 0;
		res[index++] = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i].equals(a[i - 1])) {
				continue;
			}
			res[index++] = a[i];
		}
		return res;
	}
}

