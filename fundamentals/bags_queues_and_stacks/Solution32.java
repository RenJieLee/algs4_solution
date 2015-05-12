import java.util.Iterator;

public class Solution32 {
	public static void main(String[] args) {
		Steque<String> list = new Steque<String>();
		String[] temp = ("f u c k y o u").split(" ");
		for (String s : temp) {
			list.push(s);
		}

		for (String s : list)
			StdOut.print(s);
		while (!list.isEmpty())
			StdOut.print(list.pop());		
	}
}

class Steque<Item> implements Iterable<Item> {
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
	private Node<Item> last;
	public boolean isEmpty() { return count == 0; }
	public int size() { return count; }
	public void enqueue(Item item) {
		count++;
		if (last == null) {
			last = new Node<Item>(item);
			last.next = last;
			return;
		}
		Node<Item> newLast = new Node<Item>(item);
		newLast.next = last.next;
		last.next = newLast;
		last = newLast;
	}
	public Item pop() {
		if (count == 1) {
			Item item = last.item;
			last = null;
			count--;
			return item;
		}
		Item item = last.next.item;
		last.next = last.next.next;
		count--;
		return item;
	}
	public void push(Item item) {
		count++;
		if (last == null) {
			last = new Node<Item>(item);
			last.next = last;
			return;
		}
		Node<Item> insert = new Node<Item>(item);
		insert.next = last.next;
		last.next = insert;
	}
	public Iterator<Item> iterator() {
		return new Iterator<Item>() {
			private Node<Item> current = last.next;
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