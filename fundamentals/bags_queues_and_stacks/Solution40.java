import java.util.Iterator;

public class Solution40 {
	public static void main(String[] args) {		
		MoveToFront<String> moveToFront = new MoveToFront<String>();
		moveToFront.add("f");
		moveToFront.add("u");
		moveToFront.add("c");
		moveToFront.add("k");
		for (String s : moveToFront)
			StdOut.print(s);
		StdOut.println();
		moveToFront.add("c");
		for (String s : moveToFront)
			StdOut.print(s);
		StdOut.println();
		moveToFront.add("c");
		for (String s : moveToFront)
			StdOut.print(s);
		StdOut.println();
		moveToFront.add("d");
		for (String s : moveToFront)
			StdOut.print(s);
		StdOut.println();
	}
}

class MoveToFront<Item> implements Iterable<Item> {
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
	public boolean isEmpty() { return count == 0; }
	public int size() { return count; }
	public boolean judgeIsEqual(Node<Item> node, Item item) {
		if (node == null)
			return false;
		if (node.item instanceof Comparable)
			if (((Comparable)node.item).compareTo(item) == 0)
				return true;
		return false;		
	}
	public void add(Item item) {
		if (judgeIsEqual(first, item))
			return;

		Node<Item> current = first;
		for (int i = 0; i < count; i++) {
			if (judgeIsEqual(current, item)) {
				current.next.pre = current.pre;
				current.pre.next = current.next;
				count--;
				break;
			}
			current = current.next;
		}

		pushLeft(item);
	}
	public void pushLeft(Item item) {
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