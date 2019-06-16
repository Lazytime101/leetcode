package src.mergeTwoListNode_21;

import helper.ListNode;

public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode start = result;
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                start.next = l2;
                l2 = l2.next;
            } else {
                start.next = l1;
                l1 = l1.next;
            }
            start = start.next;
        }
        if (l1 != null) {
            start.next = l1;
        }
        if (l2 != null) {
            start.next = l2;
        }
        return result.next;
    }
}
