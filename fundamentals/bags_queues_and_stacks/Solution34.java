import java.util.Iterator;

public class Solution34 {
	public static void main(String[] args) {
		RandomBag<String> list = new RandomBag<String>();
		String[] temp = ("f u c k y o u").split(" ");
		for (String s : temp) {
			list.add(s);
		}
		for (String s : list)
			StdOut.print(s);
	}
}

class RandomBag<Item> implements Iterable<Item> {
	private int count;
	private Item[] items = (Item[]) new Object[1];

	public boolean isEmpty() { return count == 0; }
	public int size() { return count; }
	public void add(Item item) {
		if (count == items.length)
			resize();
		items[count++] = item;
	}
	public Iterator<Item> iterator() {
		return new RandomBagIterator();
	}
	public void resize() {
		Item[] temp = (Item[]) new Object[items.length * 2];
		for (int i = 0; i < items.length; i++)
			temp[i] = items[i];
		items = temp;
	}

	class RandomBagIterator implements Iterator<Item> {
		Item[] iteratorItems = (Item[]) new Object[count];
		private int index;
		public RandomBagIterator() {
			for (int i = 0; i < count; i++)
				iteratorItems[i] = items[i];
			StdRandom.shuffle(iteratorItems);
		}
		public boolean hasNext() {
			return index < count;
		}
		public Item next() {
			return iteratorItems[index++];
		}
	}
}