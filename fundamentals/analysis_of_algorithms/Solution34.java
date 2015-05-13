public class Solution34 {
	static int M;
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		M = Integer.parseInt(args[1]);
		StdOut.println(guess(N));
	}
	public static int guess(int N) {
		int res = 1;
		if (guessCorrect(res)) return res;
		int last = res;
		res = N;
		while (!guessCorrect(res)) {
			if (guessDistance(res, last) == 0) return last + (res - last) / 2;
			else if (guessDistance(res, last) < 0) last += (res - last) / 2;
			else res -= (res - last) / 2;
		}
		return res;
	}
	public static int guessDistance(int res, int last) {
		if (Math.abs(res - M) == Math.abs(M - last)) return 0;
		else if (Math.abs(res - M) < Math.abs(M - last)) return -1;
		else return 1;
	}
	public static boolean guessCorrect(int res) {
		if (res == M) return true;
		return false;
	}
	public static void guessImproved(int N, int M) {

	}
}