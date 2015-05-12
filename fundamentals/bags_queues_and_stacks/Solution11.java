public class Solution11 {
	public static void main(String[] args) {
		String[] temp = ("( ( 1 2 + ) ( ( 3 4 - ) ( 5 6 - ) * ) * )").split(" ");
		//String[] temp = ("1 + 2 ) * 4 )").split(" ");
		if (!StdIn.isEmpty()) {
			temp = StdIn.readAll().split(" ");
		}
		Stack<Integer> vals = new Stack<Integer>();
		for (String s : temp) {
			if 		(s.equals("(") || s.equals(")")) ;
			else if (s.equals("+")) {
				int n = vals.pop();
				vals.push(vals.pop() + n);
			} 
			else if (s.equals("-")) {
				int n = vals.pop();
				vals.push(vals.pop() - n);
			} 
			else if (s.equals("*")) {
				int n = vals.pop();
				vals.push(vals.pop() * n);
			} 
			else if (s.equals("/")) {
				int n = vals.pop();
				vals.push(vals.pop() / n);
			} 
			else vals.push(Integer.parseInt(s));
		}
		StdOut.println(vals.pop());
	}
}