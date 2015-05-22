public class Solution24 {
	public static void main(String[] args) {
		MaxPQNode.main(args);
	}
}

class MaxPQNode<Key extends Comparable<Key>> {
	Node max;
	private int N = 0;
	private class Node {
		Key val;
		Node father;
		Node rightSon;
		Node leftSon;
		public Node(Key val) {
			this.val = val;
		}
	}
	public MaxPQNode() {
	}
	public MaxPQNode(int maxN) {
	}
	public MaxPQNode(Key[] a) {
	}
	public void insert(Key v) {
		N++;
		if (max == null) {
			max = new Node(v);
			return;
		} else {
			Node father = findNode(N / 2);
			Node tmp = new Node(v);
			tmp.father = father;
			if (N % 2 == 1) {
				father.rightSon = tmp;
			}
			else {
				father.leftSon = tmp;
			}
			swim(tmp);
		}
	}
	public Node findNode(int N) {
		if (N == 1) return max;
		Node father = findNode(N / 2);
		if (N % 2 == 1) return father.rightSon;
		return father.leftSon;
	}
	public Key delMax() {
		if (N == 1) {
			Key res = max.val;
			max = null;
			return res;
		}
		Key res = max.val;
		exch(max, findNode(N));
		Node tmp = findNode(N / 2);
		if (N % 2 == 1)
			tmp.rightSon = null;
		else
			tmp.leftSon = null;
		sink(max);
		N--;
		return res;
	}
	public boolean isEmpty() {
		return N == 0;
	}
	public int size() {
		return N;
	}
	private void sink(Node k) {
		Node tmp;
		while (k.leftSon != null) {
			if (k.rightSon != null && less(k.leftSon, k.rightSon)) {
				tmp = k.rightSon;
			} else {
				tmp = k.leftSon;
			}
			if (!less(k, tmp)) break;
			else {
				exch(k, tmp);
				k = tmp;
			}
		}
	}
	private void swim(Node k) {
		while (k.father != null && less(k.father, k)) {
			exch(k.father, k);
			k = k.father;
		}
	}
	private boolean less(Node i, Node j) {
		return i.val.compareTo(j.val) < 0;
	}
	private void exch(Node i, Node j) {
		Key t = i.val; i.val = j.val; j.val = t;
	}
	public static void main(String[] args) {
		MaxPQNode<String> maxPQ2 = new MaxPQNode<String>();
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
	/*
	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int k = N / 2; k >= 1; k--)
			sink(a, k, N);
		while (N > 1) {
			exch(a, 1, N--);
			sink(a, 1, N);
		}
	}
	*/
}