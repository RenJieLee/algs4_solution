import java.util.*;

public class Solution14 {
	public static void main(String[] args) {
		ArrayList<Domain> list = new ArrayList<Domain>();
		list.add(new Domain("cs.princeton.edu"));
		list.add(new Domain("www.princeton.edu"));
		list.add(new Domain("www.stu.princeton.edu"));
		Collections.sort(list);
		for (Domain d : list)
			StdOut.println(d);
	}
}

class Domain implements Comparable<Domain> {
	String address;
	public Domain(String address) {
		this.address = address;
	}
	public int compareTo(Domain domain) {
		String[] res1 = address.split("\\.");
		String[] res2 = address.split("\\.");
		int n = Math.min(res1.length, res2.length);
		for (int i = 0; i < n; i++) {
			if (res1[i].compareTo(res2[i]) < 0)
				return -1;
			else if (res1[i].compareTo(res2[i]) > 0)
				return 1;
		}
		return res1.length - res2.length;
	}
	public String toString() {
		return address;
	}
}