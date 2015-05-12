import java.util.Iterator;

public class Solution20<Item> implements Iterable<Item> {
	static class Node<Item> {
		Item item;
		Node<Item> next;
		public Node(Item item) {
			this.item = item;
		}
	}
	private int count;
	private Node<Item> first;
	public void add(Item item) {
		count++;
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
		delete(count);
	}
	public void delete(int k) {
		if (k > count)
			return;
		if (k == 0)
			first = first.next;
		int index = 0;
		Node<Item> current = first;
		while (current.next != null) {
			index++;
			if (index == (k - 1)) {
				current.next = current.next.next;
				count--;
				return;
			}
			current = current.next;
		}
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
		Solution20<String> list = new Solution20<String>();
		String[] temp = ("f u c k y o u").split(" ");
		for (String s : temp)
			list.add(s);
		for (String s : list)
			StdOut.print(s);
		StdOut.println();
		list.delete(3);
		for (String s : list)
			StdOut.print(s);
	}
}

//Solution20