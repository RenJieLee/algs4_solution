import java.util.ArrayList;

public class Solution21 {

}
class Transaction implements Comparable<Transaction> {
	String who;
	Date when;
	double amount;
	public Transaction(String who, Date when, double amount) {
		this.who = who;
		this.when = when;
		this.amount = amount;
	}
	public Transaction(String transaction) {
		String[] fields = transaction.split(" ");
		who = fields[0];
		when = new Date(fields[1]);
		amount = Double.parseDouble(fields[2]);
	}
	public static Transaction[] readTransactions(String name) {
		In in = new In(name);
		ArrayList<Transaction> q = new ArrayList<Transaction>();
		while (in.hasNextLine())
			q.add(new Transaction(in.readLine()));
		Transaction[] res = new Transaction[q.size()];
		int index = 0;
		for (Transaction d : q) {
			res[index] = d;
			index++;
		}
		return res;
	}
	public int compareTo(Transaction t) {
		if (this.amount > t.amount) return 1;
		else if (this.amount < t.amount) return -1;
		return 0;
	}

	public String who() {
		return who;
	}
	public Date when() {
		return when;
	}
	public double amount() {
		return amount;
	}
	public String toString() {
		return who + " " + when + " " + amount;
	}
	public boolean equals(Object x) {
		if (this == x) return true;
		if (x == null) return false;
		if (this.getClass() != x.getClass()) return false;
		Transaction that = (Transaction) x;
		if (!this.who.equals(that.who)) return false;
		if (!this.when.equals(that.when)) return false;
		if (this.amount != that.amount) return false;
		return true;
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