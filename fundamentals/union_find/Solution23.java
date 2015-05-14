public class Solution23 {
	public static void main(String[] args) {
		int T = Integer.parseInt(args[0]);
		for (int N = 125; N > 0; N += N) {
			double quickFindUFTime = 0.0;
			double quickUnionUFTime = 0.0;
			for (int i = 0; i < T; i++) {
				double tmp = System.currentTimeMillis();
				ErdosRenyi.countQuickFindUF(N);
				quickFindUFTime += (System.currentTimeMillis() - tmp);
				tmp = System.currentTimeMillis();
				ErdosRenyi.countQuickUnionUF(N);
				quickUnionUFTime += (System.currentTimeMillis() - tmp);
			}
			StdOut.printf("%d %.5f\n", N, quickFindUFTime / quickUnionUFTime);
		}
	}
}

class ErdosRenyi {
	public static void main(String[] args) {
		StdOut.println(countWeightedQuickUnionUF(Integer.parseInt(args[0])));
	}
	public static int countWeightedQuickUnionUF(int N) {
		//int N = Integer.parseInt(args[0]);
		WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
		int i = 0;
		while (uf.count() != 1) {
			i++;
			int t1 = StdRandom.uniform(0, N);
			int t2 = StdRandom.uniform(0, N);
			if (uf.connected(t1, t2)) continue;
			uf.union(t1, t2);
			//StdOut.println(t1 + " " + t2);
		}
		return i;
	}

	public static int countQuickUnionUF(int N) {
		//int N = Integer.parseInt(args[0]);
		QuickUnionUF uf = new QuickUnionUF(N);
		int i = 0;
		while (uf.count() != 1) {
			i++;
			int t1 = StdRandom.uniform(0, N);
			int t2 = StdRandom.uniform(0, N);
			if (uf.connected(t1, t2)) continue;
			uf.union(t1, t2);
			//StdOut.println(t1 + " " + t2);
		}
		return i;
	}

	public static int countQuickFindUF(int N) {
		//int N = Integer.parseInt(args[0]);
		QuickFindUF uf = new QuickFindUF(N);
		int i = 0;
		while (uf.count() != 1) {
			i++;
			int t1 = StdRandom.uniform(0, N);
			int t2 = StdRandom.uniform(0, N);
			if (uf.connected(t1, t2)) continue;
			uf.union(t1, t2);
			//StdOut.println(t1 + " " + t2);
		}
		return i;
	}
}

class WeightedQuickUnionUF {
	private int[] id;
	private int[] sz;
	private int count;
	public WeightedQuickUnionUF(int N) {
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++) id[i] = i;
		sz = new int[N];
		for (int i = 0; i < N; i++) sz[i] = 1;
	}
	public int count() {
		return count;
	}
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	public int find(int p) {
		while (p != id[p]) p = id[p];
		return p;
	}
	public void union(int p, int q) {
		int i = find(p);
		int j = find(q);
		if (i == j) return;
		if (sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		} else {
			id[j] = i;
			sz[i] += sz[j];
		}
		count--;
	}
	public static void main(String[] args) {
		int N = StdIn.readInt();
		WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if (uf.connected(p, q)) continue;
			uf.union(p, q);
			StdOut.println(p + " " + q);
		}
		StdOut.println(uf.count() + "components");
	}
}

class QuickFindUF {
	private int[] id;
	private int count;
	public QuickFindUF(int N) {
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
	public void union(int p, int q) {
		int pID = find(p);
		int qID = find(q);
		if (pID == qID) return;
		for (int i = 0; i < id.length; i++)
			if (id[i] == pID) id[i] = qID;
		count--;
	}
	public static void main(String[] args) {
		int N = StdIn.readInt();
		QuickFindUF uf = new QuickFindUF(N);
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if (uf.connected(p, q)) continue;
			uf.union(p, q);
			StdOut.println(p + " " + q);
		}
		StdOut.println(uf.count() + "components");
	}
}

class QuickUnionUF {
	private int[] id;
	private int count;
	public QuickUnionUF(int N) {
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
		while (p != id[p]) p = id[p];
		return p;
	}
	public void union(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		if (pRoot == qRoot) return;
		id[pRoot] = qRoot;
		count--;
	}
	public static void main(String[] args) {
		int N = StdIn.readInt();
		QuickUnionUF uf = new QuickUnionUF(N);
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if (uf.connected(p, q)) continue;
			uf.union(p, q);
			StdOut.println(p + " " + q);
		}
		StdOut.println(uf.count() + "components");
	}
}