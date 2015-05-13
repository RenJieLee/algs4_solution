public class Solution37 {
	public static double timeTrial(int N) {
		long tmp1 = System.currentTimeMillis();
		FixedCapacityStack<Integer> f1 = new FixedCapacityStack<Integer>(N);
		for (int i = 0; i < N; i++) {
			f1.push(i);
		}
		for (int i = 0; i < N; i++) {
			f1.pop();
		}
		tmp1 = System.currentTimeMillis() - tmp1;
		long tmp2 = System.currentTimeMillis();
		FixedCapacityStackOfInts f2 = new FixedCapacityStackOfInts(N);
		for (int i = 0; i < N; i++) {
			f2.push(i);
		}
		for (int i = 0; i < N; i++) {
			f2.pop();
		}
		tmp2 = System.currentTimeMillis() - tmp2;
		return tmp1 / 1.0 / tmp2;
	}
	public static void main(String[] args) {
		for (int i = 125; true; i += i) {
			System.out.printf("%.5f\n", timeTrial(i));
		}
	}
}

class FixedCapacityStackOfInts {
	private int[] a;
	private int N;
	public FixedCapacityStackOfInts(int cap) {
		a = new int[cap];
	}
	public boolean isEmpty() {
		return N == 0;
	}
	public int size() {
		return N;
	}
	public void push(int i) {
		a[N++] = i;
	}
	public int pop() {
		return a[--N];
	}
}
class FixedCapacityStack<Item> {
	private Item[] a;
	private int N;
	public FixedCapacityStack(int cap) {
		a = (Item[])new Object[cap];
	}
	public boolean isEmpty() {
		return N == 0;
	}
	public int size() {
		return N;
	}
	public void push(Item i) {
		a[N++] = i;
	}
	public Item pop() {
		return a[--N];
	}
}