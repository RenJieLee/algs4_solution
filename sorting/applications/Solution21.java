import java.util.*;

public class Solution21 {
	public static void main(String[] args) {
		ArrayList<Vector> list = new ArrayList<Vector>();
		Vector v1 = new Vector(1);
		v1.add(9);
		Vector v2 = new Vector(2);
		v2.add(10);
		v2.add(9);
		Vector v3 = new Vector(3);
		v3.add(10);
		v3.add(8);
		v3.add(11);
		list.add(v1);
		list.add(v2);
		list.add(v3);
		Collections.sort(list);
		for (Vector v : list)
			StdOut.println(v);
	}
}

class Vector implements Comparable<Vector> {
	private int dimension;
	private int[] save;
	private int i;
	public Vector(int dimension) {
		this.dimension = dimension;
		save = new int[dimension];
	}
	public void add(int index) {
		if (i <= dimension)
			save[i++] = index;
	}
	public String toString() {
		String res = "";
		for (int i = 0; i < dimension; i++) {
			res += "dimension " + (i + 1) + " is " + save[i] + "\n";
		}
		return res;
	}

	public int compareTo(Vector v) {
		int n = Math.min(dimension, v.dimension);
		for (int i = 0; i < n; i++) {
			if (save[i] < v.save[i])
				return -1;
			else if (save[i] > v.save[i])
				return 1;
		}
		return dimension - v.dimension;
	}

}