public class Solution15 {
	public static <Item extends Comparable<Item>> boolean judge(Item[] pq) {
		int N = pq.length;
		for (int k = N / 2; k >= 1; k--)
			if (pq[k].compareTo(pq[2 * k]) > 0 || 
				pq[k].compareTo(pq[2 * k + 1]) > 0)
				return false;
		return true;
	}
}