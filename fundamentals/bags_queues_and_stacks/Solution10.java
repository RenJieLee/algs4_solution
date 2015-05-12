import java.util.ArrayList;

public class Solution10 {
	public static void main(String[] args) {
		//ArrayList<String> list = new ArrayList<String>();
		String[] temp = ("( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )").split(" ");
		//String[] temp = ("1 + 2 ) * 4 )").split(" ");
		if (!StdIn.isEmpty()) {
			temp = StdIn.readAll().split(" ");
		}
		for (int i = 0; i < temp.length - 1; i++) {
			if (temp[i].equals("+") || temp[i].equals("-") || 
				temp[i].equals("*") || temp[i].equals("/")) {
				//Stack<String> parse = new Stack<String>();
				int count = 0;
				for (int j = i + 1; j < temp.length; j++) {
					if (temp[j].equals(")"))
						count++;
					else if (temp[j].equals("("))
						count--;
					if (count == 1) {
						evaluatePostfixHelp(temp, i, j - 1);
						break;
					}
				}
			}
		}
		String res = "";
		for (String s : temp)
			res += (s + " ");
		StdOut.println(res);
	}
	public static void evaluatePostfixHelp(String[] s, int start, int end) {
		String tmp = s[start];
		for (int i = start; i < end; i++)
			s[i] = s[i + 1];
		s[end] = tmp;
	}
}