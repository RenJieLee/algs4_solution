public class Solution15 {
	public static void main(String[] args) {
		int k = Integer.parseInt(args[0]);
		Queue<String> queue = new Queue<String>();
		int count = 0;
		while (!StdIn.isEmpty()) {
			queue.enqueue(StdIn.readString());
			count++;
		}
		for (String s : queue) {
			
			if (count == k)
				StdOut.println(s);
			count--;
		}
	}
}