import java.util.Iterator;

public class Solution31 {
	public static void main(String[] args) {
		DoubleNode<String> list = new DoubleNode<String>();
		String[] temp = ("f u c k y o u").split(" ");
		for (String s : temp) {
			list.addLast(s);
		}
		list.addNext(3, "d");
		for (String s: list) {
			StdOut.print(s);
		}
	}
}

class DoubleNode<Item> implements Iterable<Item> {
	static class Node<Item> {
		Item item;
		Node<Item> next;
		Node<Item> pre;
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
	public void addFirst(Item item) {
		count++;
		Node<Item> node = new Node<Item>(item);
		if (first == null) {
			first = node;
			first.pre = node;
			first.next = node;
			return;
		}
		node.next = first;
		node.pre = first.pre;
		first.pre.next = node;
		first.pre = node;
		first = node;
	}
	public void addLast(Item item) {
		count++;
		Node<Item> node = new Node<Item>(item);
		if (first == null) {
			first = node;
			first.pre = node;
			first.next = node;
			return;
		}
		node.next = first;
		node.pre = first.pre;
		first.pre.next = node;
		first.pre = node;
	}
	public void addPre(int n, Item item) {
		if (n == 0) {
			addFirst(item);
			return;
		}
		count++;
		int index = 0;
		Node<Item> current = first;
		while (index < n) {
			current = current.next;
			index++;
		}
		Node<Item> insert = new Node<Item>(item);
		current.pre.next = insert;
		insert.pre = current.pre;
		current.pre = insert;
		insert.next = current;
 	}
 	public void addNext(int n, Item item) {
 		count++;
		int index = 0;
		Node<Item> current = first;
		while (index < n) {
			current = current.next;
			index++;
		}
		Node<Item> insert = new Node<Item>(item);
		current.next.pre = insert;
		insert.next = current.next;
		current.next = insert;
		insert.pre = current;
 	}
	public void deleteItemOfIndex(int n) {
		if (n == 0) {
			deleteFirst();
			return;
		}
		count--;
		int index = 0;
		Node<Item> current = first;
		while (index < n) {
			current = current.next;
			index++;
		}
		current.pre.next = current.next;
		current.next.pre = current.pre;
	}
	public void deleteFirst() {
		if (first == null)
			return;
		count--;
		if (count == 1) {
			first = null;
			return;
		}
		Node<Item> last = first.pre;
		first = first.next;
		last.next = first;
		first.pre = last;
	}
	public void deleteLast() {
		if (first == null)
			return;
		count--;
		if (count == 1) {
			first = null;
			return;
		}
		first.pre.pre.next = first;
		first.pre = first.pre.pre;

	}
	public Iterator<Item> iterator() {
		return new Iterator<Item>() {
			private Node<Item> current = first;
			private int index = 0;
			public Item next() {
				Item item = current.item;
				current = current.next;
				index++;
				return item;
			}
			public boolean hasNext() {
				return index < count;
			}
		};
	}
}