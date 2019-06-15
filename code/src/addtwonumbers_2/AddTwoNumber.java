package src.addtwonumbers_2;

import helper.ListNode;

/**
 * @author lazytime
 */
public class AddTwoNumber {

    /**
     * @param node1
     * @param node2
     * @return ListNode
     * 两个链表对应相加，溢出进位
     */
    public static  ListNode  addTwoNumbers(ListNode node1, ListNode node2) {
        ListNode node = new ListNode(0);
        ListNode n1 = node1, n2 = node2, temp= node;
        int sum = 0;
        while (n1 != null || n2 != null) {
            sum /= 10;
            if (n1 != null) {
                sum += n1.val;
                n1 = n1.next;
            }
            if (n2 != null) {
                sum += n2.val;
                n2 = n2.next;
            }
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
        }
        if (sum / 10 != 0) temp.next = new ListNode(1);
        return node.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(9);
        listNode1.next = new ListNode(0);
        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        ListNode sum =addTwoNumbers(listNode1,listNode2);
        while(sum !=null){
            System.out.println(sum.val);
            sum = sum.next;
        }
    }

}
