public class Solution6 {

}
class FrequencyCounter {
	public static void main(String[] args) {
		int putCount = 0;
		int getCount = 0;
		int minlen = Integer.parseInt(args[0]);
		OrderedSequentialSearchST<String, Integer> st = 
		new OrderedSequentialSearchST<String, Integer>();
		while (!StdIn.isEmpty()) {
			String word = StdIn.readString();
			if (word.length() < minlen) continue;
			if (!st.contains(word)) {
				st.put(word, 1);
				putCount++;
			}
			else {
				st.put(word, st.get(word) + 1);
				putCount++;
				getCount++;
			}		
		}
		String max = " ";
		st.put(max, 0);
		putCount++;
		for (String word : st.keys()) {
			getCount += 2;
			if (st.get(word) > st.get(max))
				max = word;
		}
		getCount++;
		StdOut.println(max + " " + st.get(max));
		StdOut.println("get() count = " + getCount);
		StdOut.println("put() count = " + putCount);
	}
}