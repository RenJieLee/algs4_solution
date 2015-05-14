public class Solution16 {

}

class QuickFindUFDraw {
	private int[] id;
	private int count;
	public QuickFindUFDraw(int N) {
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++) id[i] = i;
	}
	public int count() {
		return count;
	}
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	public int find(int p) {
		return id[p];
	}
	public int union(int p, int q) {
		int res = 0;
		int pID = find(p);
		int qID = find(q);
		res += 2;
		if (pID == qID) return res;
		for (int i = 0; i < id.length; i++) {
			if (id[i] == pID) {
				id[i] = qID;
				res++;
			}
			res++;
		}
		count--;
		return res;
	}
	public static void main(String[] args) {
		int N = StdIn.readInt();
		QuickFindUFDraw uf = new QuickFindUFDraw(N);
		StdDraw.setXscale(0, 900);
		StdDraw.setYscale(0, 1300);
		int res = 0;
		int i = 0;
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			i++;
			if (uf.connected(p, q)) {
				StdDraw.point(i, 2);
				res += 2;
				StdDraw.setPenColor(StdDraw.RED);
				StdDraw.point(i, res / i);
				StdDraw.setPenColor(StdDraw.GRAY);
				continue;
			}
			int cost = uf.union(p, q);
			res += cost;
			StdDraw.point(i, cost);
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.point(i, res / i);
			StdDraw.setPenColor(StdDraw.GRAY);
			StdOut.println(p + " " + q);
		}
		StdOut.println(uf.count() + "components");
	}
}

class QuickUnionUFDraw {
	private int[] id;
	private int count;
	private int findCount = 0;
	public void clearFindCount() {
		findCount = 0;
	}
	public int getFindCount() {
		return findCount;
	}
	public QuickUnionUFDraw(int N) {
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++) id[i] = i;
	}
	public int count() {
		return count;
	}
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	public int find(int p) {
		findCount++;
		while (p != id[p]) {
			p = id[p];
			findCount += 2;
		}
		return p;
	}
	public int union(int p, int q) {
		clearFindCount();
		int res = 0;
		int pRoot = find(p);
		int qRoot = find(q);
		res += getFindCount();
		clearFindCount();
		if (pRoot == qRoot) return res;
		id[pRoot] = qRoot;
		count--;
		return ++res;
	}
	public static void main(String[] args) {
		int N = StdIn.readInt();
		QuickUnionUFDraw uf = new QuickUnionUFDraw(N);
		StdDraw.setXscale(0, 900);
		StdDraw.setYscale(0, 1300);
		int res = 0;
		int i = 0;
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			i++;
			if (uf.connected(p, q)) {
				int cost = uf.getFindCount();
				res += cost;
				uf.clearFindCount();
				StdDraw.point(i, cost);
				StdDraw.setPenColor(StdDraw.RED);
				StdDraw.point(i, res / i);
				StdDraw.setPenColor(StdDraw.GRAY);
				continue;
			}
			int cost = uf.union(p, q);
			res += cost;
			StdDraw.point(i, cost);
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.point(i, res / i);
			StdDraw.setPenColor(StdDraw.GRAY);
			StdOut.println(p + " " + q);
		}
		StdOut.println(uf.count() + "components");
	}
}