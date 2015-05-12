public class FixedCapacityStack<Item> {
	private Item[] a;
	private int N;
	public FixedCapacityStack(int cap) {
		a = (Item[]) new Object[cap];
	}
	public boolean isEmpty() {
		return N == 0;
	}
	public int size() {
		return N;
	}
	public void push(Item item) {
		a[N++] = item;
	}
	public Item pop() {
		return a[--N];
	}
	public static void main(String[] args) {
		FixedCapacityStack<String> s;
		s = new FixedCapacityStack<String>(100);
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-"))
				s.push(item);
			else if (!s.isEmpty()) {
				StdOut.print(s.pop() + " ");
			}
		}
		StdOut.println("(" + s.size() + " left on stack)");
	}
}