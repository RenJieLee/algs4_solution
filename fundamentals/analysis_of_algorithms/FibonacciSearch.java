public class FibonacciSearch {
	public static int rank(int key, int[] a) {
		int i = 0;
        int j = 1;
    	while (j < a.length) {
    		j = j + i;
    		i = j - i;
    	}
    	int[] tmp = new int[j];
    	for (int k = 0; k < tmp.length; k++)
    		if (k < a.length)
    			tmp[k] = a[k];
    		else
    			tmp[k] = a[a.length - 1];
		return rankHelp(key, tmp, 0, i, j);
    }
    public static int rankHelp(int key, int[] a, int low, int k2, int k1) {
        int mid = low + k2 - 1;
        int k3 = k1 - k2;
        if (a[mid] == key)
            return mid;
        else if (a[mid] > key)
            return rankHelp(key, a, low, k3, mid);
        else 
            return rankHelp(key, a, mid + 1, k2- k3, k3);
    }
    public static void main(String[] args) {
    	int[] a = { 1, 3, 4, 7, 11, 15, 18, 19};
    	StdOut.print(rank(18, a) + " ");
    }
}