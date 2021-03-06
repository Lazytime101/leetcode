package src.deleteTheLastnNode_19;

import helper.ListNode;

public class Solution {

    /**
     * @param head
     * @param n
     * @return
     * 分隔n个节点，保证找到第leangth - n 个元素
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        ListNode start = pre;
        ListNode end = pre;
        pre.next = head;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            start = start.next;
        }
        while (start != null) {
            start = start.next;
            end = end.next;
        }
        end.next = end.next.next;
        return pre.next;
    }


}
