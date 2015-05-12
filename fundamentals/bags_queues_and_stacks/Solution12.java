public class Solution12 {
	public static Stack<String> copy(Stack<String> stack) {
		Stack<String> temp = new Stack<String>();
		Stack<String> res = new Stack<String>();
		for (String item : stack)
			temp.push(item);
		for (String item : temp)
			res.push(item);
		return res;
	}

	public static void main(String[] args) {
		String[] test = ("fuck you bitch, go fuck yourself").split(" ");
		Stack<String> s1 = new Stack<String>();
		for (String s : test)
			s1.push(s);
		for (String s : s1)
			StdOut.print(s + " ");
		StdOut.println();
		for (String s : copy(s1))
			StdOut.print(s + " ");
		StdOut.println();
		for (String s : s1)
			StdOut.print(s + " ");

	}
}