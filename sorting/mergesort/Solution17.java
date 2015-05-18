/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution17 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode current = head;
        
        ArrayList<ListNode> save = new ArrayList<ListNode>();
        /*
        ListNode fakeHead = new ListNode(0);
        boolean isFirst = true;
        */
        ListNode l1 = new ListNode(0);
        l1.next = current;
        current = current.next;
        l1.next.next = null;
        ListNode currentL1 = l1.next;


        while (current != null) {
            while (current != null && current.val >= currentL1.val) {
                currentL1.next = current;
                current = current.next;
                currentL1.next.next = null;
                currentL1 = currentL1.next;
            }
            /*
            if (isFirst) {
                isFirst = false;
                fakeHead.next = l1.next;
                if (current == null) break;
                if (current.next == null) {
                    fakeHead.next = mergeTwoLists(fakeHead.next, current);
                    break;
                }
                l1.next = current;
                current = current.next;
                l1.next.next = null;
                currentL1 = l1.next;
            } else {
                fakeHead.next = mergeTwoLists(fakeHead.next, l1.next);
            */
            save.add(l1.next);
            if (current == null) break;
            if (current.next == null) {
                save.add(current);
                //fakeHead.next = mergeTwoLists(fakeHead.next, current);
                break;
            }
            l1.next = current;
            current = current.next;
            l1.next.next = null;
            currentL1 = l1.next;        
        }
        if (save.size() == 1) {
            return save.get(0);
        }
        while (save.size() != 1) {
            save.add(mergeTwoLists(save.remove(0), save.remove(0)));
        }
        return save.get(0);
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode current = res;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
                current = current.next;
            } else {
                current.next = l2;
                l2 = l2.next;
                current = current.next;
            }
        }
        if (l1 == null) current.next = l2;
        else            current.next = l1;
        res = res.next;
        return res;
    }
}