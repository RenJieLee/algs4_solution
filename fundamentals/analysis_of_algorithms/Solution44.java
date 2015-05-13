import java.util.HashSet;

public class Solution44 {
	public static void main(String[] args) {
		//int N = Integer.parseInt(args[0]);
		for (int i = 125; i > 0; i += i) {
			StdOut.printf("%d %d\n", getAll(i), i);
		}
	}
	public static int getOne(int N) {
		HashSet<Integer> hash = new HashSet<Integer>();
		int i = 0;
		while (true) {
			int tmp = StdRandom.uniform(0, N);
			if (hash.contains(tmp)) break;
			hash.add(tmp);
			i++;
		}
		return i;
	}	
	public static int getAll(int N) {
		HashSet<Integer> hash = new HashSet<Integer>();
		int i = 0;
		while (true) {
			int tmp = StdRandom.uniform(0, N);
			if (hash.size() == N) break;
			hash.add(tmp);
			i++;
		}
		return i;
	}
}