public class Solution3 {

}

class MaxPQ1<Key extends Comparable<Key>> {
	private Key[] a = (Key[]) new Comparable[1];
	private int N = 0;
	public MaxPQ1() {

	}
	public MaxPQ1(int max) {
		resize(max);
	}
	public MaxPQ1(Key[] t) {
		resize(t.length);
		for (int i = 0; i < t.length; i++)
			a[i] = t[i];
	}
	public void insert(Key v) {
		if (N == a.length) resize(2 * a.length);
		a[N++] = v;
	}
	public Key max() {
		Key k = a[N - 1];
		for (int i = N - 2; i >= 0; i--)
			if (a[i].compareTo(k) > 0)
				k = a[i];
		return k;
	}
	public Key delMax() {
		int index = N - 1;
		for (int i = N - 2; i >= 0; i--)
			if (a[i].compareTo(a[index]) > 0)
				index = i;
		Key tmp = a[index];
		a[index] = a[--N];
		a[N] = null;
		if (N > 0 && N == a.length / 4) resize(a.length / 2);

		return tmp;
	}
	public boolean isEmpty() {
		return N == 0;
	}
	public int size() {
		return N;
	}
	private void resize(int max) {
		Key[] temp = (Key[]) new Comparable[max];
		for (int i = 0; i < N; i++)
			temp[i] = a[i];
		a = temp;
	}
	public static void main(String[] args) {
		MaxPQ1<String> maxPQ1 = new MaxPQ1<String>();
		maxPQ1.insert("P");
		maxPQ1.insert("Q");
		maxPQ1.insert("E");
		StdOut.println(maxPQ1.delMax());
		maxPQ1.insert("X");
		maxPQ1.insert("A");
		maxPQ1.insert("M");
		StdOut.println(maxPQ1.delMax());
		maxPQ1.insert("P");
		maxPQ1.insert("L");
		maxPQ1.insert("E");
		StdOut.println(maxPQ1.delMax());
	}
}

class MaxPQ2<Key extends Comparable<Key>> {
	private Key[] a = (Key[]) new Comparable[1];
	private int N = 0;
	public MaxPQ2() {

	}
	public MaxPQ2(int max) {
		resize(max);
	}
	public MaxPQ2(Key[] t) {
		resize(t.length);
		for (int i = 0; i < t.length; i++)
			a[i] = t[i];
	}
	public void insert(Key v) {
		if (N == a.length) resize(2 * a.length);
		int index = N - 1;
		while (index >= 0 && a[index].compareTo(v) > 0) {
			a[index + 1] = a[index];
			index--;
		}
		a[index + 1] = v;
		N++;
	}
	public Key max() {
		return a[N - 1];
	}
	public Key delMax() {
		Key tmp = a[--N];
		a[N] = null;
		if (N > 0 && N == a.length / 4) resize(a.length / 2);

		return tmp;
	}
	public boolean isEmpty() {
		return N == 0;
	}
	public int size() {
		return N;
	}
	private void resize(int max) {
		Key[] temp = (Key[]) new Comparable[max];
		for (int i = 0; i < N; i++)
			temp[i] = a[i];
		a = temp;
	}
	public static void main(String[] args) {
		MaxPQ2<String> maxPQ2 = new MaxPQ2<String>();
		maxPQ2.insert("P");
		maxPQ2.insert("Q");
		maxPQ2.insert("E");
		StdOut.println(maxPQ2.delMax());
		maxPQ2.insert("X");
		maxPQ2.insert("A");
		maxPQ2.insert("M");
		StdOut.println(maxPQ2.delMax());
		maxPQ2.insert("P");
		maxPQ2.insert("L");
		maxPQ2.insert("E");
		StdOut.println(maxPQ2.delMax());
	}
}

class MaxPQ4<Key extends Comparable<Key>> {
	private Node first;
	private int N;
	private class Node {
		Key item;
		Node next;
		public Node(Key item) {
			this.item = item;
		}
	}
	public MaxPQ4() {
	}
	public MaxPQ4(int max) {
	}
	public MaxPQ4(Key[] t) {
		first = new Node(t[0]);
		Node current = first;
		for (int i = 1; i < t.length; i++) {
			current.next = new Node(t[i]);
			current = current.next;
		}
	}
	public void insert(Key v) {
		N++;
		Node tmp = new Node(v);
		tmp.next = first;
		first = tmp;
	}
	public Key max() {
		Key max = first.item;
		Node current = first;
		while (current != null)
			if (current.item.compareTo(max) > 0)
				max = current.item;
		return max;
	}
	public Key delMax() {
		N--;
		Node fakeHead = new Node(max());
		fakeHead.next = first;
		Node current = fakeHead;
		while (current.next.item.compareTo(fakeHead.item) != 0)
			current = current.next;
		current.next = current.next.next;
		return fakeHead.item;
	}
	public boolean isEmpty() {
		return N == 0;
	}
	public int size() {
		return N;
	}
	public static void main(String[] args) {
		MaxPQ2<String> maxPQ2 = new MaxPQ2<String>();
		maxPQ2.insert("P");
		maxPQ2.insert("Q");
		maxPQ2.insert("E");
		StdOut.println(maxPQ2.delMax());
		maxPQ2.insert("X");
		maxPQ2.insert("A");
		maxPQ2.insert("M");
		StdOut.println(maxPQ2.delMax());
		maxPQ2.insert("P");
		maxPQ2.insert("L");
		maxPQ2.insert("E");
		StdOut.println(maxPQ2.delMax());
	}
}

class MaxPQ3<Key extends Comparable<Key>> {
	private Node first;
	private int N;
	private class Node {
		Key item;
		Node next;
		public Node(Key item) {
			this.item = item;
		}
	}
	public MaxPQ3() {
	}
	public MaxPQ3(int max) {
	}
	public MaxPQ3(Key[] t) {
		first = new Node(t[0]);
		Node current = first;
		for (int i = 1; i < t.length; i++) {
			current.next = new Node(t[i]);
			current = current.next;
		}
	}
	public void insert(Key v) {
		N++;

		Node fakeHead = new Node(v);
		fakeHead.next = first;
		Node current = fakeHead;
		while (current.next.item.compareTo(v) < 0) current = current.next;
		Node tmp = current.next;
		current.next = new Node(v);
		current.next.next = tmp;
		first = fakeHead.next;
	}
	public Key max() {
		return first.item;
	}
	public Key delMax() {
		N--;
		Key tmp = first.item;
		first = first.next;
		return tmp;
	}
	public boolean isEmpty() {
		return N == 0;
	}
	public int size() {
		return N;
	}
	public static void main(String[] args) {
		MaxPQ2<String> maxPQ2 = new MaxPQ2<String>();
		maxPQ2.insert("P");
		maxPQ2.insert("Q");
		maxPQ2.insert("E");
		StdOut.println(maxPQ2.delMax());
		maxPQ2.insert("X");
		maxPQ2.insert("A");
		maxPQ2.insert("M");
		StdOut.println(maxPQ2.delMax());
		maxPQ2.insert("P");
		maxPQ2.insert("L");
		maxPQ2.insert("E");
		StdOut.println(maxPQ2.delMax());
	}
}