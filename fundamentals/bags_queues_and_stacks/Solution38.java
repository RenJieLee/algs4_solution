import java.util.Iterator;

public class Solution38 {
	public static void main(String[] args) {
		GeneralizedQueue2<String> dequeChanged = new GeneralizedQueue2<String>();
		dequeChanged.insert("f");//f
		dequeChanged.insert("u");//fu
		dequeChanged.insert("d");//dfu
		dequeChanged.insert("k");//kdfu
		dequeChanged.insert("g");//kdfuc
		dequeChanged.delete(5);
		for (String s: dequeChanged) {
			StdOut.print(s);
		}
	}
}

class GeneralizedQueue1<Item> implements Iterable<Item> {
	Item[] stores = (Item[]) new Object[1];
	public int count;
	public int head;
	public int tail;

	public boolean isEmpty() { return count == 0; }
	public int size() { return count; }
	public void insert(Item item) {
		if (count == 0) {
			stores[0] = item;
			head = (head - 1 + stores.length) % stores.length;
			tail = (tail + 1 + stores.length) % stores.length;
			count++;
			return;
		}
		if (count == stores.length)
			resize(stores.length * 2);
		count++;
		stores[head] = item;
		head = (head - 1 + stores.length) % stores.length;
	}
	
	public Item popRight() {
		count--;
		tail = (tail - 1 + stores.length) % stores.length;
		return stores[tail];
	}
	public void resize(int size) {
		Item[] temp = (Item[]) new Object[size];
		for (int i = 0; i < count; i++) {
			head = (head + 1 + stores.length) % stores.length;
			temp[i] = stores[head];
		}
		stores = temp;
		head = temp.length - 1;
		tail = count;
	}
	public Item delete(int k) {
		int current = head;
		for (int i = 0; i < k; i++) {
			current = (current + 1 + stores.length) % stores.length;
		}
		Item i = stores[current];
		for (int j = k; j < count; j++) {
			int tmp = (current + 1 + stores.length) % stores.length;
			stores[current] = stores[tmp];
			current = tmp;
		}
		count--;
		return i;
	}
	public Iterator<Item> iterator() {
		return new Iterator<Item>() {
			public int index = 0;
			public int current = head;
			public boolean hasNext() {
				return index < count;
			}
			public Item next() {
				current = (current + 1 + stores.length) % stores.length;
				index++;
				return stores[current];
			}
		};
	}
}

class GeneralizedQueue2<Item> implements Iterable<Item> {
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
	public void insert(Item item) {
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
	public void popRight() {
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
	public Item deleteFirst() {
		if (first == null)
			return null;
		count--;
		if (count == 1) {
			Item i = first.item;
			first = null;
			return i;
		}
		Item i = first.item;
		Node<Item> last = first.pre;
		first = first.next;
		last.next = first;
		first.pre = last;
		return i;
	}
	public Item delete(int k) {
		if (k == 1) {
			return deleteFirst();
		}
		Node<Item> current = first;
		for (int index = 0; index < k - 1; index++)
			current = current.next;
		Item i = current.item;
		current.next.pre = current.pre;
		current.pre.next = current.next;
		count--;
		return i;
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