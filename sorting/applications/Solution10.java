public class Solution10 {
	public static void main(String[] args) {
		Version v1 = new Version("115.1.1");
		Version v2 = new Version("115.10.1");
		StdOut.println(v1.compareTo(v2));
	}
}

class Version implements Comparable<Version> {
	String version;
	public Version(String version) {
		this.version = version;
	}
	public int compareTo(Version v1) {
		return compareVersion(version, v1.version);
	}
	public int compareVersion(String version1, String version2) {
        if (version1.equals(version2)) return 0;
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int n = Math.min(v1.length, v2.length);
        for (int i = 0; i < n; i++) {
            if (Integer.parseInt(v1[i]) < Integer.parseInt(v2[i])) return -1;
            else if (Integer.parseInt(v1[i]) > Integer.parseInt(v2[i])) return 1;
        }
        /*
        return v1.length - v2.length;
        */
        if (v1.length > n)
            for (int i = n; i < v1.length; i++)
                if (Integer.parseInt(v1[i]) > 0)
                    return 1;
        if (v2.length > n)
            for (int i = n; i < v2.length; i++)
                if (Integer.parseInt(v2[i]) > 0)
                    return -1;
        return 0;
    }
}