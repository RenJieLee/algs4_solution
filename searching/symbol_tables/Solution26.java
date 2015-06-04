import java.util.*;

public class Solution26 {

}

class FrequencyCounter {
	public static void main(String[] args) {
		int minlen = Integer.parseInt(args[0]);
		SequentialSearchST<String, Integer> st = 
		new SequentialSearchST<String, Integer>();
		while (!StdIn.isEmpty()) {
			String word = StdIn.readString();
			if (word.length() < minlen) continue;
			if (!st.contains(word)) st.put(word, 1);
			else 					st.put(word, st.get(word) + 1);
		}
		/*
		String max = " ";
		st.put(max, 0);
		for (String word : st.keys()) {
			if (st.get(word) > st.get(max))
				max = word;
		}
		StdOut.println(max + " " + st.get(max));
		*/
		class Tmp {
			private String s;
			private int N;
			public Tmp(String s, int N) {
				this.s = s;
				this.N = N;
			}
			public String toString() {
				return s + " " + N;
			}
		}
		class TmpStringComparator implements Comparator<Tmp> {
			public int compare(Tmp t1, Tmp t2) {
				return t1.s.compareTo(t2.s);
			}
		}
		class TmpIntComparator implements Comparator<Tmp> {
			public int compare(Tmp t1, Tmp t2) {
				if (t1.N == t2.N) return 0;
				else if (t1.N < t2.N) return -1;
				return 1;
			}
		}
		ArrayList<Tmp> a = new ArrayList<Tmp>();
		for (String word : st.keys()) {
			a.add(new Tmp(word, st.get(word)));
		}
		/*
		Collections.sort(a, new TmpStringComparator());
		for (Tmp t : a) {
			StdOut.println(t);
		}
		*/
		Collections.sort(a, new TmpIntComparator());
		for (Tmp t : a) {
			StdOut.println(t);
		}
	}
}