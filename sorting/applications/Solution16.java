import java.util.*;

public class Solution16 {
	public static void main(String[] args) {
		ArrayList<California> list = new ArrayList<California>();
		list.add(new California("FUCK"));
		list.add(new California("YOU"));
		list.add(new California("JOHN"));
		list.add(new California("AND"));
		list.add(new California("OBAMA"));
		Collections.sort(list);
		for (California c : list)
			StdOut.println(c);
	}
}

class California implements Comparable<California> {
	String name;
	public static ArrayList<String> order;
	static {
		order = new ArrayList<String>();
		order.add("R");
		order.add("W");
		order.add("Q");
		order.add("O");
		order.add("J");
		order.add("M");
		order.add("V");
		order.add("A");
		order.add("H");
		order.add("B");
		order.add("S");
		order.add("G");
		order.add("Z");
		order.add("X");
		order.add("N");
		order.add("T");
		order.add("C");
		order.add("I");
		order.add("E");
		order.add("K");
		order.add("U");
		order.add("P");
		order.add("D");
		order.add("Y");
		order.add("F");
		order.add("L");
	}
	public California(String name) {
		this.name = name;
		
	}
	public int compareTo(California california) {
		if (name.equals(california.name)) return 0;
		int n = Math.min(name.length(), california.name.length());
		for (int i = 0; i < n; i++) {
			if (order.indexOf("" + name.charAt(i)) < 
				order.indexOf("" + california.name.charAt(i)))
				return -1;
			if (order.indexOf("" + name.charAt(i)) > 
				order.indexOf("" + california.name.charAt(i)))
				return 1;
		}
		return name.length() - california.name.length();
	}
	public String toString() {
		return name;
	}
}