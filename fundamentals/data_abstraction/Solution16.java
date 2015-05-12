public class Solution16 {
	public static void main(String[] args) {
		Rational r = new Rational(2, 4);
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
		long numerator = this.getNumerator() * b.getDenominator() + 
			b.getNumerator() * this.getDenominator();
		long denominator = this.getDenominator() * b.getDenominator();
		return new Rational(numerator, denominator);
	}
	public Rational minus(Rational b) {
		long numerator = this.getNumerator() * b.getDenominator() - 
			b.getNumerator() * this.getDenominator();
		long denominator = this.getDenominator() * b.getDenominator();
		return new Rational(numerator, denominator);
	}
	public Rational times(Rational b) {
		long numerator = this.getNumerator() * b.getNumerator();
		long denominator = this.getDenominator() * b.getDenominator();
		return new Rational(numerator, denominator);
	}
	public Rational divides(Rational b) {
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
}