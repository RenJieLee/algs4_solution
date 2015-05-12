import java.util.Iterator;

public class Solution44 {
	public static void main(String[] args) {
		
		Buffer buffer = new Buffer();
		buffer.insert('A');
		buffer.insert('B');
		buffer.insert('C');
		buffer.insert('D');
		buffer.insert('E');
		buffer.insert('F');
		buffer.left(5);//ABCDEF
		buffer.delete();//BCDEF
		buffer.right(2);
		buffer.delete();
		for (Character c : buffer)
			StdOut.print(c);
	}
}

class Buffer implements Iterable<Character> {
	StackChanged<Character> left = new StackChanged<Character>();
	StackChanged<Character> right = new StackChanged<Character>();
	public void insert(char c) {
		left.push(c);
	}
	public char delete() {
		return left.pop();
	}
	public void left(int k) {
		for (int i = 0; i < k; i++)
			right.push(left.pop());
	}
	public void right(int k) {
		for (int i = 0; i < k; i++)
			left.push(right.pop());
	}
	public int size() {
		return left.size() + right.size();
	}
	public Iterator<Character> iterator() {
		return new BufferIterator();
	}

	class BufferIterator implements Iterator<Character> {
		StackChanged<Character> leftRead = new StackChanged<Character>();
		StackChanged<Character> rightRead;
		public BufferIterator() {
			rightRead = new StackChanged<Character>(right);
			StackChanged<Character> leftCopy = new StackChanged<Character>(left);
			while (!leftCopy.isEmpty())
				leftRead.push(leftCopy.pop());
		}
		public boolean hasNext() {
			return (!leftRead.isEmpty() || !rightRead.isEmpty());
		}
		public Character next() {
			if (!leftRead.isEmpty())
				return leftRead.pop();
			return rightRead.pop();
		}
	}
}