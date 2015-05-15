public class Solution18 {
	public static void main(String[] args) {
		InsertionDrawTrack.main(args);
	}
}

class SelectionDrawTrack {
	public static void sort(Double[] a) {
		int N = a.length;
		//show(a);
		for (int i = 0; i < N; i++) {
			int min = i;
			for (int j = i + 1; j < N; j++) {
				if (less(a[j], a[min])) min = j;
			}
			show(a, i, min);
			exch(a, i, min);
			
		}
	}
	public static void show(Double[] a, int index, int min) {
		StdDraw.clear();
		//StdDraw.setXscale(0, a.length);
		StdDraw.setPenColor(StdDraw.RED);
		for (int i = 0; i < a.length; i++) {
			if (i == min) StdDraw.setPenColor(StdDraw.RED);
			else if (i < index) StdDraw.setPenColor(StdDraw.GRAY);
			else StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.filledRectangle((2 * i + 1) * 1.0 / 2.0 / a.length, a[i] / 2, 
				1.0 / 2.0 / a.length, a[i] / 2);
		}
		try {
			Thread.sleep(200);	
		} catch (Exception e) {

		}
		//StdDraw.show(5);
		
	}
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i]; a[i] = a[j]; a[j] = t;
	}
	public static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++)
			if (less(a[i], a[i - 1])) return false;
		return true;
	}
	public static void main(String[] args) {
		Double[] nums = new Double[100];
		for (int i = 0; i < nums.length; i++) nums[i] = StdRandom.uniform();
		sort(nums);
	}
}

class InsertionDrawTrack {
	public static void sort(Double[] a) {
		/*
		int N = a.length;
		for (int i = 1; i < N; i++) {
			for (int j = i; j > 0 && less(a[j], a[j - 1]); j--)
				exch(a, j, j - 1);
		}
		*/
		//show(a);
		for (int i = 1; i < a.length; i++) {
			int index = i;
			while (index >= 1 && less(a[index], a[index - 1])) {
				exch(a, index, index - 1);
				//show(a);
				index--;
			}
			show(a, index, i);
		}		
	}
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i]; a[i] = a[j]; a[j] = t;
	}
	public static void show(Double[] a, int index, int max) {
		StdDraw.clear();
		//StdDraw.setXscale(0, a.length);
		//StdDraw.setPenColor(StdDraw.RED);
		for (int i = 0; i < a.length; i++) {
			if (index == i) StdDraw.setPenColor(StdDraw.RED);
			else if (i > index && i <= max) StdDraw.setPenColor(StdDraw.BLACK);
			else StdDraw.setPenColor(StdDraw.GRAY);
			StdDraw.filledRectangle((2 * i + 1) * 1.0 / 2.0 / a.length, a[i] / 2, 
				1.0 / 2.0 / a.length, a[i] / 2);
		}
		try {
			Thread.sleep(200);	
		} catch (Exception e) {

		}
		//StdDraw.show(5);
		
	}
	public static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++)
			if (less(a[i], a[i - 1])) return false;
		return true;
	}
	public static void main(String[] args) {
		Double[] nums = new Double[100];
		for (int i = 0; i < nums.length; i++) nums[i] = StdRandom.uniform();
		sort(nums);
	}
}