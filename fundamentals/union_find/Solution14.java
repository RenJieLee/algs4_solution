public class Solution14 {
	public static void main(String[] args) {
		int N = StdIn.readInt();
		HeightedQuickUnionUF uf = new HeightedQuickUnionUF(N);
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

class HeightedQuickUnionUF {
	private int[] id;
	private int[] hi;
	private int count;
	public HeightedQuickUnionUF(int N) {
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++) id[i] = i;
		hi = new int[N];
		for (int i = 0; i < N; i++) hi[i] = 0;
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
		if (hi[i] < hi[j]) {
			id[i] = j;
		} else if(hi[i] == hi[j]) {
			id[j] = i;
			hi[i]++;
		} else {
			id[j] = i;
		}
		count--;
	}
	
}