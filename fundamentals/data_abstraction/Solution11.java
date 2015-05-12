public class Solution11 {
	public static void main(String[] args) {
		SmartDate sd = new SmartDate(12, 33, 2014);
		StdOut.println(sd);
	}
}

class SmartDate {
	private final int value;
	public SmartDate(int m, int d, int y) {
		if (d > 31 || d < 1 || m > 12 || m < 1)
			throw new RuntimeException("Init is wrong");
		value = y * 512 + m * 32 + d;
	}
	public int month() {
		return (value / 32) % 16;
	}
	public int day() {
		return value % 32;
	}
	public int year() {
		return value / 512;
	}
	public String toString() {
		return month() + "/" + day() + "/" + year();
	}
}