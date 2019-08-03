package src.deleteDuplicates_82;

import helper.ListNode;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        int currentValue = -1;
        while (current != null) {
            if (current.val == currentValue) {
                current.next = current.next.next;
                continue;
            }
            if (current.val == current.next.val) {
                currentValue = current.val;
                current.next = current.next.next;
                continue;
            }
            current = current.next;
            currentValue = -1;
        }
        return head;
    }
}
