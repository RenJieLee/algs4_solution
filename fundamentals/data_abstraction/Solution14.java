public class Solution14 {

}

class Transaction {
	String who;
	Date when;
	double amount;
	public Transaction(String who, Date when, double amount) {
		this.who = who;
		this.when = when;
		this.amount = amount;
	}
	public Transaction(String transaction) {

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