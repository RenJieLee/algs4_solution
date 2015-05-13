public class Solution12 {
	public static void main(String[] args) {
		int[] a = { -1, 1, 3, 7, 8, 8, 8, 9, 9, 10, 35, 47, 48};
		int[] b = { -1, 1, 1, 7, 8, 8, 8, 9, 11, 35, 48};
		printCommon(a, b);
	}
	public static void printCommon(int[] a, int[] b) {
		for (int i = 0 , j = 0; i < a.length && j < b.length; ) {
			if (a[i] < b[j])
				i++;
			else if (a[i] > b[j])
				j++;
			else {
				StdOut.print(a[i] + " ");
				int tmp = a[i];
				while(i < a.length && a[i] == tmp)
					i++;
				while(j < b.length && b[j] == tmp)
					j++;
			}
		}
	}
}

