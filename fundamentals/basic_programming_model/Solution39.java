import java.util.Arrays;

public class Solution39 {
	public static void main(String[] args) {
		int T = Integer.parseInt(args[0]);
		int sum1 = 0;
		int sum2 = 0;
		int sum3 = 0;
		int sum4 = 0;
		for (int i = 0; i < T; i++) {
			sum1 += testHelp(1000);
			sum2 += testHelp(10000);
			sum3 += testHelp(100000);
			sum4 += testHelp(1000000);
		}
		System.out.println(sum1 / T);
		System.out.println(sum2 / T);
		System.out.println(sum3 / T);
		System.out.println(sum4 / T);
	}
	public static int testHelp(int N) {
		int[] tmp1 = new int[N];
		int[] tmp2 = new int[N];
		for (int i = 0; i < N; i++) {
			tmp1[i] = StdRandom.uniform(1000000);
			tmp2[i] = StdRandom.uniform(1000000);
		}
		Arrays.sort(tmp1);
		Arrays.sort(tmp2);
		tmp1 = Solution28.delete(tmp1);
		tmp2 = Solution28.delete(tmp2);
		int count = 0;
		for (int i : tmp1)
			if (Solution28.rank(i, tmp2) >= 0)
				count++;
		return count;
	}
}