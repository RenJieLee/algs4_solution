import java.util.ArrayList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution18 {
    public ListNode shuffleList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode current = head;
        
        ArrayList<ListNode> save = new ArrayList<ListNode>();

        while (current != null) {
        	ListNode tmp = current;

        	//save.add(current);        
        	current = current.next;
        	tmp.next = null;
        	save.add(tmp);
        }
        if (save.size() == 1) {
            return save.get(0);
        }
        while (save.size() != 1) {
        	int i1 = (int)(Math.random() * save.size());
        	int i2 = (int)(Math.random() * (save.size() - 1));
            save.add(mergeTwoLists(save.remove(i1), save.remove(i2)));
        }
        return save.get(0);
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode current = res;
        while (l1 != null && l2 != null) {
            current.next = l1;
            l1 = l1.next;
            current = current.next;
        }
        if (l1 == null) current.next = l2;
        else            current.next = l1;
        res = res.next;
        return res;
    }
    public static void main(String[] args) {
    	Solution18 s = new Solution18();
    	ListNode head = new ListNode(0);
    	ListNode current = head;
    	for (int i = 1; i < 10; i++) {
    		current.next = new ListNode(i);
    		current = current.next;
    	}
    	current = s.shuffleList(head);
    	while (current != null) {
    		StdOut.println(current.val);
    		current = current.next;
    	}
    }
}