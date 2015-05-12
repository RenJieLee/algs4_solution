import java.util.ArrayList;
import java.util.Arrays;

public class Solution28 {
	public static int rank(int key, int[] a) {
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if 		(key < a[mid]) hi = mid - 1;
			else if (key > a[mid]) lo = mid + 1;
			else 					 return mid;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] whitelist = In.readInts(args[0]);
		Arrays.sort(whitelist);
		whitelist = deleteSameNum(whitelist);
		while (!StdIn.isEmpty()) {
			int key = StdIn.readInt();
			if (rank(key, whitelist) == -1)
				StdOut.println(key);
		}
		
		
	}

	public static int[] deleteSameNum(int[] whitelist) {
		ArrayList<Integer> resList = new ArrayList<Integer>();
		resList.add(whitelist[0]);
		for (int i = 1; i < whitelist.length; i++) {
			if (whitelist[i] == whitelist[i - 1])
				;//i++;
			else
				resList.add(whitelist[i]);
		}
		int[] res = new int[resList.size()];
		int index = 0;
		for (Integer num : resList) {
			res[index] = num;
			index++;
		}
		return res;
	}
}