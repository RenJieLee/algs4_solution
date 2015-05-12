import java.util.ArrayList;

public class Solution9 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		String[] temp = ("1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )").split(" ");
		//String[] temp = ("1 + 2 ) * 4 )").split(" ");
		if (!StdIn.isEmpty()) {
			temp = StdIn.readAll().split(" ");
		}
		for (int i = 0; i < temp.length; i++) {
			list.add(temp[i]);
			if (temp[i].equals(")")) {
				Stack<String> ops = new Stack<String>();
				Stack<Integer> vals = new Stack<Integer>();
				Stack<String> parse = new Stack<String>();
				for (int j = list.size() - 2; j >= 0; j--) {
					String s = list.get(j);
					if 		(s.equals(")")) parse.push(")");
					else if	(s.equals("+")) ops.push(s);
					else if (s.equals("-")) ops.push(s);
					else if (s.equals("*")) ops.push(s);
					else if (s.equals("/")) ops.push(s);
					else if (s.equals("(")) {
						String op = ops.pop();
						int v = vals.pop();
						if 		(op.equals("+")) v = v + vals.pop();
						else if (op.equals("-")) v = v - vals.pop();
						else if (op.equals("*")) v = v * vals.pop();
						else if (op.equals("/")) v = v / vals.pop();
						parse.pop();
						vals.push(v);
					}
					else vals.push(Integer.parseInt(s));
					/*
					if (j == 0 && ops.size() == 1 && vals.size() == 2) {
						list.add(0, "(");
						break;
					}
					*/
					if (ops.size() == 1 && vals.size() == 2 && parse.size() == 0) {
						list.add(j, "(");
						break;
					}
				}
				
			}
		}
		for (String s : list) {
			StdOut.print(s + " ");
		}
	}
}