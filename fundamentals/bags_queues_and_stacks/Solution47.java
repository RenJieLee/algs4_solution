public class Solution47 {
	public static <Item> Stack<Item> catenation(Stack<Item> s1, Stack<Item> s2) {
		Stack<Item> tmp = new Stack<Item>();
		while (!s2.isEmpty()) tmp.push(s2.pop());
		while (!s1.isEmpty()) s2.push(s1.pop());
		while (!tmp.isEmpty()) s1.push(tmp.pop());
		while (!s2.isEmpty()) s1.push(s2.pop());
		return s1;
	}
}