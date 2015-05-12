import java.util.Iterator;

public class Solution48<Item> {
	private int countLeft = 0;
	private int countRight = 0;
	private Deque<Item> deque = new Deque<Item>();
	public void pushLeft(Item item) {
		deque.pushLeft(item);
		countLeft++;
	}
	public void pushRight(Item item) {
		deque.pushRight(item);
		countRight++;
	}
	public Item popLeft() {
		countLeft--;
		return deque.popLeft();
	}
	public Item popRight() {
		countRight--;
		return deque.popRight();
	}
	public int rightSize() {
		return countRight;
	}
	public int leftSize() {
		return countLeft;
	}
	public boolean rightIsEmpty() {
		return countRight == 0;
	}
	public boolean leftIsEmpty() {
		return countLeft == 0;
	}
}

class Deque<Item> implements Iterable<Item> {
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
	public void pushRight(Item item) {
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
	public Item popLeft() {
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
	public Item popRight() {
		if (first == null)
			return null;
		count--;
		if (count == 1) {
			Item i = first.item;
			first = null;
			return i;
		}
		Item i = first.pre.item;
		first.pre.pre.next = first;
		first.pre = first.pre.pre;
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

class ResizingArrayDeque<Item> implements Iterable<Item> {
	Item[] stores = (Item[]) new Object[1];
	public int count;
	public int head;
	public int tail;

	public boolean isEmpty() { return count == 0; }
	public int size() { return count; }
	public void pushLeft(Item item) {
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
	public void pushRight(Item item) {
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
		stores[tail] = item;
		tail = (tail + 1 + stores.length) % stores.length;
	}
	public Item popLeft() {
		count--;
		head = (head + 1 + stores.length) % stores.length;
		return stores[head];
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