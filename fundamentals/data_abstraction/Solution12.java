public class Solution12 {
	public static void main(String[] args) {
		SmartDate sd = new SmartDate(4, 27, 2015);
		StdOut.println(sd.dayOfTheWeek());
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
	public int dayOfTheWeek() {
		int sum = 0;
		for (int i = 2000; i < year(); i++)
			if (isLeapYear(i))
				sum += 366;
			else
				sum += 365;
		for (int i = 1; i < month(); i++)
			switch (i) {
				case 1: ;
				case 3: ;
				case 5: ;
				case 7: ;
				case 8: ;
				case 10: ;
				case 12: sum += 31; break;
				case 2: sum += (isLeapYear(year()) ?  29 : 28); break;
				case 4: ;
				case 6: ;
				case 9: ;
				case 11: sum += 30;
			}
		sum += day();
		return (sum + 5) % 7;
	}
	private boolean isLeapYear(int y) {
		if ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0)
			return true;
		else
			return false;
	}
}