public class Solution19 {

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
		String max = " ";
		st.put(max, 0);
		Queue<String> s = new Queue<String>();
		for (String word : st.keys()) {
			if (st.get(word) > st.get(max)) {
				max = word;
				while (!s.isEmpty())
					s.dequeue();
				s.enqueue(word);
			} else if (st.get(word) == st.get(max)) {
				s.enqueue(word);
			}
		}
		for (String str : s)
			StdOut.println(str + " " + st.get(str));
		//StdOut.println(max + " " + st.get(max));
	}
}