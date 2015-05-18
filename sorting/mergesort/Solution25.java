/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution25 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        mergeKLists(lists, 0, lists.length - 1);
        return lists[0];
    }
    public void mergeKLists(ListNode[] lists, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        mergeKLists(lists, lo, mid);
        mergeKLists(lists, mid + 1, hi);
        lists[lo] = mergeTwoLists(lists[lo], lists[mid + 1]);
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