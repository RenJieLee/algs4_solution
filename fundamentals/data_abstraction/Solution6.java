public class Solution6 {
	public static boolean isCircularRotation(String s1, String s2) {
		return s1.length() == s2.length() ? 
			(s1.concat(s1).indexOf(s2) != -1 ? true : false) : 
			false;
	}
	public static void main(String[] args) {
		System.out.println(isCircularRotation("ACTGACG", "TGACGAC"));
	}
}