package src.addtwonumbers_2;

import helper.ListNode;

public class Test {

    @org.junit.Test
    public void testAddTwo(){
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(4);
        l1.next =new ListNode(2);
        ListNode l2 = new ListNode(4);
        l2.next= new ListNode(6);
        l2.next = new ListNode(5);
        AddTwoNumber addTwoNumber = new AddTwoNumber();
        System.out.println(AddTwoNumber.addTwoNumbers(l1,l2));
    }
}
