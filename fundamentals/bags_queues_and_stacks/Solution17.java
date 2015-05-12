public class Solution17 {

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
		String[] fields = transaction.split(" ");
		who = fields[0];
		when = new Date(fields[1]);
		amount = Double.parseDouble(fields[2]);
	}
	public static Transaction[] readTransactions(String name) {
		In in = new In(name);
		Queue<Transaction> q = new Queue<Transaction>();
		while (in.hasNextLine())
			q.enqueue(new Transaction(in.readLine()));
		Transaction[] res = new Transaction[q.size()];
		int index = 0;
		for (Transaction d : q) {
			res[index] = d;
			index++;
		}
		return res;
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