public class Solution29 {
	public static void main(String[] args) {
		BinarySearchST<Time, Event> st = 
		new BinarySearchST<Time, Event>(20);
		st.put(new Time("09:00:00"), new Event("Chicago"));
		st.put(new Time("09:00:03"), new Event("Phoenix"));
		st.put(new Time("09:00:13"), new Event("Houston"));
		st.put(new Time("09:00:59"), new Event("Chicago"));
		st.put(new Time("09:01:10"), new Event("Houston"));

		st.put(new Time("09:19:46"), new Event("Chicago"));
		st.put(new Time("09:21:05"), new Event("Chicago"));
		st.put(new Time("09:22:43"), new Event("Seattle"));
		st.put(new Time("09:22:54"), new Event("Seattle"));
		st.put(new Time("09:25:52"), new Event("Chicago"));

		st.put(new Time("09:03:13"), new Event("Chicago"));
		st.put(new Time("09:10:11"), new Event("Seattle"));
		st.put(new Time("09:10:25"), new Event("Seattle"));
		st.put(new Time("09:14:25"), new Event("Phoenix"));
		st.put(new Time("09:19:32"), new Event("Chicago"));
		st.put(new Time("09:35:21"), new Event("Chicago"));
		st.put(new Time("09:36:14"), new Event("Seattle"));
		st.put(new Time("09:37:44"), new Event("Phoenix"));		

		StdOut.println(st.min());
		StdOut.println(st.get(new Time("09:00:13")));
		StdOut.println(st.floor(new Time("09:05:13")));
		StdOut.println(st.select(7));
		for (Time t : st.keys(new Time("09:15:00"), new Time("09:25:00")))
			StdOut.println(t);
		StdOut.println(st.ceiling(new Time("09:30:00")));
		StdOut.println(st.max());
		StdOut.println(st.size(new Time("09:15:00"), new Time("09:25:00")));
		StdOut.println(st.rank(new Time("09:10:25")));
	}
}

class Time implements Comparable<Time> {
	private int h;
	private int m;
	private int s;
	private String str;
	public Time(String str) {
		this.str = str;
		String[] tmp = str.split(":");
		h = Integer.parseInt(tmp[0]);
		m = Integer.parseInt(tmp[1]);
		s = Integer.parseInt(tmp[2]);
	}
	public String toString() {
		return str;
	}
	public int compareTo(Time t) {
		if 		(h < t.h)
			return -1;
		else if (h > t.h)
			return 1;
		else if (m > t.m)
			return 1;
		else if (m < t.m)
			return -1;
		else if (s > t.s)
			return 1;
		else if (s < t.s)
			return -1;
		return 0;
	}
}

class Event {
	private String str;
	public Event(String str) {
		this.str = str;
	}
	public String toString() {
		return str;
	}
}