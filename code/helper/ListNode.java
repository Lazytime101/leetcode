package helper;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode(int[] nums) {
        ListNode target = new ListNode(nums[0]);
        ListNode head = target;
        for (int i = 1; i < nums.length; i++) {
            target.next = new ListNode(nums[i]);
            target = target.next;
        }
        this.val = head.val;
        this.next = head.next;
    }

    public static boolean compareTwoListNode(ListNode node1, ListNode node2) {
        if (node1 == null && node2 != null) return false;
        while (node1 != null) {
            if (node2 == null || node1.val != node2.val) {
                return false;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return true;
    }

}
