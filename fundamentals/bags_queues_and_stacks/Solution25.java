import java.util.Iterator;

public class Solution25<Item> implements Iterable<Item> {
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
	public Node<Item> getFirst() {
		return first;
	}
	public static boolean find(Solution25<String> list, String string) {
		for (String s : list)
			if (s.equals(string))
				return true;
		return false;
	}
	public static <Item> void removeAfter(Node<Item> node) {
		if (node == null)
			return;
		if (node.next == null)
			return;
		node.next = node.next.next;
	}
	public static <Item> void insertAfter(Node<Item> n1, Node<Item> n2) {
		if (n1 == null || n2 == null)
			return;
		Node<Item> current = n2;
		while (current.next != null)
			current = current.next;
		current.next = n1.next;
		n1.next = n2;
	}
	public static void main(String[] args) {
		Solution25<String> list = new Solution25<String>();
		Solution25<String> list2 = new Solution25<String>();
		String[] temp = ("f u c k y o u").split(" ");
		for (String s : temp) {
			list.add(s);
			list2.add(s);
		}
		insertAfter(list.getFirst(), list2.getFirst().next.next);
		for (String s : list)
			StdOut.print(s);
	}
}


//Solution25