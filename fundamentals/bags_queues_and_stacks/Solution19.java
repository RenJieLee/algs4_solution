import java.util.Iterator;

public class Solution19<Item> implements Iterable<Item> {
	static class Node<Item> {
		Item item;
		Node<Item> next;
		public Node(Item item) {
			this.item = item;
		}
	}
	private Node<Item> first;
	public void add(Item item) {
		if (first == null) {
			first = new Node<Item>(item);
			return;
		}
		Node<Item> current = first;
		while (current.next != null)
			current = current.next;
		current.next = new Node<Item>(item);
	}
	public void deleteLast() {
		if (first == null)
			return;
		if (first.next == null) {
			first = null;
			return;
		}
		Node<Item> current = first;
		while (current.next.next != null)
			current = current.next;
		current.next = null;
	}
	public Iterator<Item> iterator() {
		return new Iterator<Item>() {
			private Node<Item> current = first;
			public Item next() {
				Item item = current.item;
				current = current.next;
				return item;
			}
			public boolean hasNext() {
				return current != null;
			}
		};
	}
	public static void main(String[] args) {
		Solution19<String> list = new Solution19<String>();
		String[] temp = ("f u c k y o u").split(" ");
		for (String s : temp)
			list.add(s);
		for (String s : list)
			StdOut.print(s);
		StdOut.println();
		list.deleteLast();
		for (String s : list)
			StdOut.print(s);
	}
}