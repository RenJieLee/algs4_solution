public class Solution20 {
}

class ResizingWeightedQuickUnionUF {
	private int[] id;
	private int[] sz;
	private int count;
	public ResizingWeightedQuickUnionUF() {
		count = 2;
		id = new int[2];
		for (int i = 0; i < 2; i++) id[i] = i;
		sz = new int[2];
		for (int i = 0; i < 2; i++) sz[i] = 1;
	}
	public int count() {
		return count;
	}
	public boolean connected(int p, int q) {
		if (p >= id.length || q >= id.length) {
			resize(p, q);
		}
		return find(p) == find(q);
	}
	public int find(int p) {
		while (p != id[p]) p = id[p];
		return p;
	}
	public void resize(int p, int q) {
		int max = p;
		if (q > p) max = q;
		int[] idTmp = new int[max + 1];
		int[] szTmp = new int[max + 1];
		for (int i = 0; i < idTmp.length; i++) {
			if (i < id.length) {
				idTmp[i] = id[i];
				szTmp[i] = sz[i];
			} else {
				idTmp[i] = i;
				szTmp[i] = 1;	
			}			
		}
		count = idTmp.length - id.length + count;
		id = idTmp;
		sz = szTmp;
	}
	public void union(int p, int q) {
		if (p >= id.length || q >= id.length) {
			resize(p, q);
		}
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
		ResizingWeightedQuickUnionUF uf = new ResizingWeightedQuickUnionUF();
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