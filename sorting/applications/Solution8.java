import java.util.*;
public class Solution8 {
	public static void main(String[] args) {
		String[] test = {"a", "b", "b", "c", "d", "e", "f"};
		frequency(test);
	}
	public static void frequency(String[] a) {
		class FrequencyHelp implements Comparable<FrequencyHelp> {
			String s;
			int cnt;
			public FrequencyHelp(String s, int i) {
				this.s = s;
				cnt = i;
			}
			public String toString() {
				return s + " " + cnt;
			}
			public int compareTo(FrequencyHelp f) {
				if (cnt == f.cnt) return 0;
				else if (cnt < f.cnt) return -1;
				return 1;
			}

		}

		Arrays.sort(a);
		ArrayList<FrequencyHelp> res = new ArrayList<FrequencyHelp>();
		FrequencyHelp frequencyHelp = new FrequencyHelp(a[0], 1);
		//res.add(new FrequencyHelp(a[0], 1));
		for (int i = 1; i < a.length; i++) {
			if (a[i] == a[i - 1])
				frequencyHelp.cnt++;
			else {
				res.add(frequencyHelp);
				frequencyHelp = new FrequencyHelp(a[i], 1);
			}
		}
		res.add(frequencyHelp);
		Collections.sort(res);
		for (int i = res.size() - 1; i >= 0; i--)
			StdOut.println(res.get(i));
	}
}