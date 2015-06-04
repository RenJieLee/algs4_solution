public class Solution7 {

}

class FrequencyCounter {
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		OrderedSequentialSearchST<Integer, Integer> st = 
		new OrderedSequentialSearchST<Integer, Integer>();
		for (int i = 0; i < N; i++) {
			Integer tmp = (int)(Math.random() * 1000);
			if (!st.contains(tmp))
				st.put(tmp, 1);
			else
				st.put(tmp, st.get(tmp) + 1);
		}
		Integer max = -1;
		st.put(max, 0);
		for (Integer word : st.keys()) {
			if (st.get(word) > st.get(max))
				max = word;
		}
		StdOut.println(max + " " + st.get(max));
		StdOut.println("different num count is " + (st.size() - 1));
	}
}