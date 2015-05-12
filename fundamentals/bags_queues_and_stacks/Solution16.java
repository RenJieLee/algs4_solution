public class Solution16 {
	public static void main(String[] args) {
		Date[] dates = Date.readDates("Solution16Test.txt");
		for (Date d : dates)
			StdOut.println(d);
	}
}

class Date {
	private final int month;
	private final int day;
	private final int year;

	public Date(int m, int d, int y) {
		month = m;
		day = d;
		year = y;
	}
	public Date(String date) {
		String[] fields = date.split("/");
		month = Integer.parseInt(fields[0]);
		day = Integer.parseInt(fields[1]);
		year = Integer.parseInt(fields[2]);
	}
	public int month() {
		return month;
	}
	public int day() {
		return day;
	}
	public int year() {
		return year;
	}
	public String toString() {
		return month() + "/" + day() + "/" + year();
	}
	public static Date[] readDates(String name) {
		In in = new In(name);
		Queue<Date> q = new Queue<Date>();
		while (!in.isEmpty())
			q.enqueue(new Date(in.readString()));
		Date[] res = new Date[q.size()];
		int index = 0;
		for (Date d : q) {
			res[index] = d;
			index++;
		}
		return res;
	}
	public boolean equals(Object x) {
		if (this == x) return true;
		if (x == null) return false;
		if (this.getClass() != x.getClass()) return false;
		Date that = (Date) x;
		if (this.day != that.day) return false;
		if (this.month != that.month) return false;
		if (this.year != that.year) return false;
		return true;
	}
}