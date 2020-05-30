package src.jianzhioffer;

import java.util.Arrays;

public class duplicate_2 {

    /**
     * @param numbers
     * @return
     * 分析一个长度为n的数组，里面的元素（0-n-1）之间，判断是否有重复的数字,并输出任意一个
     */
    public int duplicate(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }
        int length = numbers.length;

        for (int i = 0; i < length; i++) {
            if (numbers[i] < 0 || numbers[i] >= length) {
                return -1;
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            int temp = numbers[i];
            if (i == numbers[i]) continue;

            if (numbers[temp] == numbers[i]) {
                return numbers[temp];
            }

            numbers[i] = numbers[temp];
            numbers[temp] = temp;

        }
        return -1;
    }


    /**
     * @param numbers
     * @return
     * 分析一个长度为n的数组，里面的元素（0-n-1）之间，判断是否有重复的数字,并输出任意一个
     * 不改变原数组情况
     * 1 辅助数组 空间多了
     * 2 数组二分查找 ，暂时没有实现
     */
    public int duplicate2(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }
        int length = numbers.length;

        for (int i = 0; i < length; i++) {
            if (numbers[i] < 0 || numbers[i] >= length) {
                return -1;
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            int temp = numbers[i];
            if (i == numbers[i]) continue;

            if (numbers[temp] == numbers[i]) {
                return numbers[temp];
            }

            numbers[i] = numbers[temp];
            numbers[temp] = temp;

        }
        return -1;
    }




    public static void main(String[] args) {
        int[] nums = {7, 2, 1,7,5,5,3,2};
        Integer item = null;
        duplicate_2 duplicate = new duplicate_2();
        System.out.println(duplicate.duplicate(nums));
        System.out.println("*");
        Arrays.stream(nums).forEach(a->System.out.println(a));

    }
}
