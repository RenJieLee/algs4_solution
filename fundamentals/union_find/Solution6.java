public class Solution6 {
	public static void main(String[] args) {
		int N = 1000000;
		int M = 100000000;
		WeightedQuickUnionUF uf = new WeightedQuickUnionUF(M);
		for (int i = 0; i < N; i++) {
			int t1 = StdRandom.uniform(M);
			int t2 = StdRandom.uniform(M);
			if (uf.connected(t1, t2)) continue;
			uf.union(t1, t2);	
			StdOut.println(t1 + " " + t2);
		}
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