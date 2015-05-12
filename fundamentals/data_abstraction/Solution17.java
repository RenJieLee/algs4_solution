public class Solution17 {
	public static void main(String[] args) {
		long l1 = (long)(Math.pow(2, 63) - 1);
		StdOut.println(Rational.isOverFlow(l1, 2, "*"));
		Rational r = new Rational(l1, 1);
		Rational r2 = new Rational(2, 6);
		StdOut.println(r);
		StdOut.println(r2);
		StdOut.println(r.plus(r2));
		StdOut.println(r.minus(r2));
		StdOut.println(r.times(r2));
		StdOut.println(r.divides(r2));
	}
}

class Rational {
	private long numerator;
	private long denominator;
	public Rational(long numerator, long denominator) {
		long gcd = gcd(numerator, denominator);
		this.numerator = numerator / gcd;
		this.denominator = denominator / gcd;
	}
	public Rational plus(Rational b) {
		assert !isOverFlow(this.getNumerator(), b.getDenominator(), "*") : "over flow";
		assert !isOverFlow(b.getNumerator(), this.getDenominator(), "*") : "over flow";
		long tmp1 = this.getNumerator() * b.getDenominator();
		long tmp2 = b.getNumerator() * this.getDenominator();
		assert !isOverFlow(tmp1, tmp2, "+") : "over flow";
		assert !isOverFlow(this.getDenominator(), b.getDenominator(), "*") : "over flow";
		long numerator = tmp1 + tmp2;
		long denominator = this.getDenominator() * b.getDenominator();
		return new Rational(numerator, denominator);
	}
	public Rational minus(Rational b) {
		assert !isOverFlow(this.getNumerator(), b.getDenominator(), "*") : "over flow";
		assert !isOverFlow(b.getNumerator(), this.getDenominator(), "*") : "over flow";
		long tmp1 = this.getNumerator() * b.getDenominator();
		long tmp2 = b.getNumerator() * this.getDenominator();
		assert !isOverFlow(tmp1, tmp2, "-") : "over flow";
		assert !isOverFlow(this.getDenominator(), b.getDenominator(), "*") : "over flow";
		long numerator = tmp1 - tmp2;
		long denominator = this.getDenominator() * b.getDenominator();
		return new Rational(numerator, denominator);
	}
	public Rational times(Rational b) {
		assert !isOverFlow(this.getNumerator(), b.getNumerator(), "*") : "over flow";
		assert !isOverFlow(this.getDenominator(), b.getDenominator(), "*") : "over flow";
		long numerator = this.getNumerator() * b.getNumerator();
		long denominator = this.getDenominator() * b.getDenominator();
		return new Rational(numerator, denominator);
	}
	public Rational divides(Rational b) {
		assert !isOverFlow(this.getNumerator(), b.getDenominator(), "*") : "over flow";
		assert !isOverFlow(b.getNumerator(), this.getDenominator(), "*") : "over flow";
		long numerator = this.getNumerator() * b.getDenominator();
		long denominator = this.getDenominator() * b.getNumerator();
		return new Rational(numerator, denominator);
	}
	public long getNumerator() {
		return numerator;
	}
	public long getDenominator() {
		return denominator;
	}
	public String toString() {
		return numerator + "/" + denominator;
	}
	public boolean equals(Object x) {
		if (this == x) return true;
		if (x == null) return false;
		if (this.getClass() != x.getClass()) return false;
		Rational that = (Rational) x;
		if (this.numerator != that.numerator) return false;
		if (this.denominator != that.denominator) return false;
		return true;
	}
	public static long gcd(long p, long q) {
		if (q == 0) return p;
		long r = p % q;
		return gcd(q, r);
	}
	public static boolean isOverFlow(long l1, long l2, String operation) {
		if (operation.equals("+")) {
			if ((l1 < 0 && l2 > 0) || (l1 > 0 && l2 < 0))
				return false;
			if (l1 > 0 && (l1 + l2) < 0)
				return true;
			if (l1 < 0 && (l1 + l2) > 0)
				return true;
		} else if (operation.equals("-")) {
			if ((l1 > 0 && l2 > 0) || (l1 < 0 && l2 < 0))
				return false;
			if (l1 > 0 && (l1 - l2) < 0)
				return true;
			if (l1 < 0 && (l1 - l2) > 0)
				return true;
		} else if (operation.equals("*")) {
			long l1Abs = Math.abs(l1);
			long l2Abs = Math.abs(l2);
			long sum = 0;
			for (int i = 0; i < l2Abs; i++) {
				sum += l1Abs;
				if (sum < 0)
					return true;
			}
		}
		return false;
	}
}