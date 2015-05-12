import java.util.Iterator;

public class Solution30<Item> implements Iterable<Item> {
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
	public static boolean find(Solution30<String> list, String string) {
		for (String s : list)
			if (s.equals(string))
				return true;
		return false;
	}
	public static void remove(Solution30<String> list, String string) {
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
	public static <Item> Item recurMax(Node<Item> n) {
		if (n == null)
			return null;
		return recurMaxHelp(n, n.item);
	}
	public static <Item> Node<Item> reverse(Node<Item> x) {
		Node<Item> first = x;
		Node<Item> reverse = null;
		while (first != null) {
			Node<Item> second = first.next;
			first.next = reverse;
			reverse = first;
			first = second;
		}
		return reverse;
	}
	public static <Item> Item recurMaxHelp(Node<Item> n, Item item) {
		if (n == null)
			return item;
		if (n.item instanceof Comparable) {
			if (((Comparable)n.item).compareTo((Object)item) > 0)
				item = n.item;
		}
		return recurMaxHelp(n.next, item);
	}
	public static void main(String[] args) {
		Solution30<String> list = new Solution30<String>();
		String[] temp = ("f u c k y o u").split(" ");
		for (String s : temp) {
			list.add(s);
		}
		Node<String> first = reverse(list.getFirst());
		while (first != null) {
			StdOut.print(first.item);
			first = first.next;
		}
	}
}

//Solution30