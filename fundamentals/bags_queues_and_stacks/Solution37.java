public class Solution37 {
	public static void main(String[] args) {
		/*
		int N = Integer.parseInt(args[0]);
		int M = Integer.parseInt(args[1]);
		*/
		int N = 7;
		int M = 2;
		Josephus josephus = new Josephus(N, M);
		josephus.execute();
	}
}

class Josephus {
	private int N;
	private int M;
	private Queue<Integer> josephusQueue = new Queue<Integer>();
	public Josephus(int N, int M) {
		this.N = N;
		this.M = M;
		for (int i = 0; i < N; i++)
			josephusQueue.enqueue(i);
	}
	public void execute() {
		while (!josephusQueue.isEmpty()) {
			for (int i = 0; i < M - 1; i++)
				josephusQueue.enqueue(josephusQueue.dequeue());
			StdOut.print(josephusQueue.dequeue() + " ");
		}
	}
}