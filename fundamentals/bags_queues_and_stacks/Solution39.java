import java.util.Iterator;

public class Solution39 {

}

class RingBuffer<Item> implements Iterable<Item> {
	Item[] stores;
	public int count;
	public int head;
	public int tail;
	public RingBuffer(int size) {
		stores = (Item[]) new Object[size];
	}
	public boolean isEmpty() { return count == 0; }
	public int size() { return count; }
	public void enqueue(Item item) {
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
	
	public Item dequeue() {
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