import java.io.File;
import java.util.*;
public class Solution28 {

}

class FileSorter {
	public static ArrayList<File> addFile(File file) {
		ArrayList<File> res = new ArrayList<File>();
		addFile(file, res);
		return res;
	}
	public static void addFile(File file, ArrayList<File> res) {
		if (file.isFile()) {
			res.add(file);
			return;
		}
		for (File f : file.listFiles())
			addFile(f, res);
	}
	public static void main(String[] args) {
		File file = new File(args[0]);
		ArrayList<File> res = addFile(file);
		Collections.sort(res, new FileNameComparator());
		for (File f : res)
			StdOut.println(f.getName());
	}
	static class FileNameComparator implements Comparator<File> {
		public int compare(File f1, File f2) {
			return f1.getName().compareTo(f2.getName());
		}
	}
}