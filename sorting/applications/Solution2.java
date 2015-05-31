import java.util.*;

public class Solution2 {
	public static void getCompoundString(ArrayList<String> list) {
		ArrayList<String> pre = new ArrayList<String>();
		ArrayList<String> tail = new ArrayList<String>();
		Collections.sort(list);
		for (int i = 1; i < list.size(); i++)
			if (list.get(i).startsWith(list.get(i - 1)))
				pre.add(list.get(i - 1));
		Collections.sort(list, new ReverseStringComparator());
		for (int i = 1; i < list.size(); i++)
			if (list.get(i).endsWith(list.get(i - 1)))
				tail.add(list.get(i - 1));
		for (int i = 0; i < pre.size(); i++)
			for (int j = 0; j < tail.size(); j++)
				if (list.contains(pre.get(i) + tail.get(j)))
					StdOut.println(pre.get(i) + tail.get(j));
	}
	static class ReverseStringComparator implements Comparator<String> {
		public int compare(String s1, String s2) {
			if (s1 == s2) return 0;
			int n = Math.min(s1.length(), s2.length());
			for (int i = 1; i <= n; i++) {
				if (s1.charAt(s1.length() - i) < s2.charAt(s2.length() - i))
					return -1;
				else if (s1.charAt(s1.length() - i) > s2.charAt(s2.length() - i))
					return 1;
			}
			return s1.length() - s2.length();
		}
	}
	public static void main(String[] args) {
		ArrayList<String> test = new ArrayList<String>();
		test.add("after");
		test.add("thought");
		test.add("kill");
		test.add("people");
		test.add("killpeople");
		test.add("afterthought");
		getCompoundString(test);
		
	}
}