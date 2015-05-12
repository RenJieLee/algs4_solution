public class Solution10 {

}

class VisualCounter {
    private int count = 0;
    private int index = 0;
    private int N;   
    private int RANGE;     
    public VisualCounter(int RANGE, int N) {
        this.N = N;
        this.RANGE = this.RANGE;
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(-1 * RANGE, RANGE);
    } 
    public void increment() {
        count++;
        index++;
        StdDraw.point(index, RANGE + count);
    }
    public void reduce() {
    	count--;
    	index++;
    	StdDraw.point(index, RANGE + count);
    	StdDraw.setPenColor(StdDraw.RED);
    }
    public int tally() {
        return count;
    }
    public String toString() {
        return count + " VisualCounter ";
    }

    public static void main(String[] args) {
    	VisualCounter vc = new VisualCounter(500, 500);
    	for (int i = 0; i < 500; i++)
    		if (StdRandom.bernoulli(0.6))
    			vc.increment();
    		else
    			vc.reduce();
    }
}