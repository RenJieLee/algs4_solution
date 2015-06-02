public class Solution1 {
	public static void main(String[] args) {
		BinarySearchST<String, Double> st = new BinarySearchST<String, Double>(15);
		while (StdIn.hasNextLine()) {
			String[] tmp = StdIn.readLine().split(" ");
			st.put(tmp[0], Double.parseDouble(tmp[1]));
		}
		double res = 0.0;
		for (String s : st.keys())
			res += st.get(s);
		StdOut.println(res / st.size());
	}	
}