public class Solution9 {

}

class FrequencyCounter {
	public static void main(String[] args) {
		int minlen = Integer.parseInt(args[0]);
		OrderedSequentialSearchST<String, Integer> st = 
		new OrderedSequentialSearchST<String, Integer>();
		String last = "";
		int N = 0;
		while (!StdIn.isEmpty()) {
			String word = StdIn.readString();
			if (word.length() < minlen) continue;
			N++;
			last = word;
			if (!st.contains(word)) st.put(word, 1);
			else 					st.put(word, st.get(word) + 1);
		}
		StdOut.println("last word is " + last + 
			" before this we handle " + (N - 1) + " word");
		String max = " ";
		st.put(max, 0);
		for (String word : st.keys()) {
			if (st.get(word) > st.get(max))
				max = word;
		}
		StdOut.println(max + " " + st.get(max));
	}
}