import java.util.Iterator;

public class Solution27<Item> implements Iterable<Item> {
	static class Node<Item> {
		Item item;
		Node<Item> next;
		public Node(Item item) {
			this.item = item;
		}
		public String toString() {
			return item + "";
		}
		public Item getItem() {
			return item;
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
	public static boolean find(Solution27<String> list, String string) {
		for (String s : list)
			if (s.equals(string))
				return true;
		return false;
	}
	public static void remove(Solution27<String> list, String string) {
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
	public static <Item> Item max(Node<Item> n) {
		Node<Item> max = n;
		while (n != null) {
			if (n.item instanceof Comparable) {
				if (((Comparable)n.item).compareTo((Object)max.item) > 0)
					max = n;
			}
			n = n.next;
		}
		return max.getItem();
	}
	public static void main(String[] args) {
		Solution27<String> list = new Solution27<String>();
		String[] temp = ("f u f c k y f f f o u f").split(" ");
		for (String s : temp) {
			list.add(s);
		}
		StdOut.println(max(list.getFirst()));
		remove(list, "f");
		for (String s : list)
			StdOut.print(s);
	}
}

//Solution27