package src.jianzhioffer;

import helper.ListNode;

import java.util.Arrays;

public class duplicate_2 {

    /**
     * @param numbers
     * @return
     * 分析一个长度为n的数组，里面的元素（0-n-1）之间，判断是否有重复的数字
     */
    public boolean duplicate(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        int length = numbers.length;

        for (int i = 0; i < length; i++) {
            if (numbers[i] < 0 || numbers[i] >= length) {
                return false;
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            int temp = numbers[i];
            if (i == numbers[i]) continue;

            if (numbers[temp] == numbers[i]) {
                return true;
            }

            numbers[i] = numbers[temp];
            numbers[temp] = temp;

        }
        return false;
    }

    public  void charge(ListNode node){
        node.setVal(1);
    }


    public static void main(String[] args) {
        int[] nums = {7, 2, 1,7,5,5,3,2};
        Integer item = null;
        duplicate_2 duplicate = new duplicate_2();
        System.out.println(duplicate.duplicate(nums));
        ListNode node = new ListNode(5);
        duplicate.charge(node);
        System.out.println(node.val);

    }
}
