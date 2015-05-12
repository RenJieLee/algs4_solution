import java.util.Iterator;

public class Solution26<Item> implements Iterable<Item> {
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
		if (k == 0) {
			first = first.next;
			return;
		}
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
	public static boolean find(Solution26<String> list, String string) {
		for (String s : list)
			if (s.equals(string))
				return true;
		return false;
	}
	public static void remove(Solution26<String> list, String string) {
		Node<String> first = list.getFirst();
		if (first == null)
			return;
		Node<String> current = first;
		while (current.next != null) {
			while (current.next.item.equals(string)) {
				current.next = current.next.next;
				if (current.next == null)
					break;
			}
			current = current.next;
			if (current == null)
				break;
		}
		if (first.item.equals(string))
			list.delete(0);
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
		Solution26<String> list = new Solution26<String>();
		String[] temp = ("f u f c k y f o u f").split(" ");
		for (String s : temp) {
			list.add(s);
		}
		remove(list, "f");
		for (String s : list)
			StdOut.print(s);
	}
}
//Solution26