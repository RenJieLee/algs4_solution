import java.io.File;
import java.util.*;
public class Solution29 {
}

class LS {
	public static void main(String[] args) {
		File f = new File(args[0]);
		ArrayList<File> list = FileSorter.addFile(f);
		for (int i = 1; i < args.length; i++) {
			if (args.equals("-t"))
				Collections.sort(list, FileSorter.fileModifiedComparator);
			else if (args.equals("-n"))
				Collections.sort(list, FileSorter.fileNameComparator);
			else if (args.equals("-l"))
				Collections.sort(list, FileSorter.fileSizeComparator);
		}
	}
}

class FileSorter {
	public final static FileNameComparator fileNameComparator = new FileNameComparator();
	public final static FileModifiedComparator fileModifiedComparator = new FileModifiedComparator();
	public final static FileSizeComparator fileSizeComparator = new FileSizeComparator();
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
		Collections.sort(res, new FileModifiedComparator());
		for (File f : res)
			StdOut.println(f.getName());
	}
	static class FileNameComparator implements Comparator<File> {
		public int compare(File f1, File f2) {
			return f1.getName().compareTo(f2.getName());
		}
	}
	static class FileSizeComparator implements Comparator<File> {
		public int compare(File f1, File f2) {
			if (f1.length() < f2.length())
				return -1;
			else if (f1.length() > f2.length())
				return 1;
			return 0;
		}
	}
	static class FileModifiedComparator implements Comparator<File> {
		public int compare(File f1, File f2) {
			if (f1.lastModified() < f2.lastModified())
				return -1;
			else if (f1.lastModified() > f2.lastModified())
				return 1;
			return 0;
		}
	}
}