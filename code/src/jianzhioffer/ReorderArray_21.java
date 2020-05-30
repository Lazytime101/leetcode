package src.jianzhioffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReorderArray_21 {


    /**
     * @param a
     * @return 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，是所有的奇数位于数组的前半部分，所有偶数位于数组的后半部分。
     * 思路 利用多空间简化，但是效率没提升
     */
    public static int[] apply(int[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        List<Integer> odd = new ArrayList<Integer>();
        List<Integer> even = new ArrayList<Integer>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0) {
                even.add(a[i]);
            } else {
                odd.add(a[i]);
            }
        }
        odd.addAll(even);
        int[] b = new int[odd.size() + even.size()];
        for (int i = 0; i < odd.size(); i++) {
            b[i] = odd.get(i);
        }
        return b;
    }


    /**
     * @param a
     * 对于任意一个整数数组，设置一个指针，从前往后走，如果遇到奇数则指针后移，遇到偶数时，希望把该偶数放在数组后面；
     * 因此，再设置一个指针，从后往前走，遇到偶数时指针前移，遇到奇数时，则恰好可以与前面的指针所指的偶数进行调换
     */
    public void apply1(int[] a) {
        if (a == null || a.length == 0) {
            return;
        }
        int low = 0;
        int high = a.length - 1;
        while (low < high) {
            while (!isTrue(a[low])) {
                low++;
            }
            while (isTrue(a[high])) {
                high--;
            }
            if (low < high) {
                int temp = a[low];
                a[low] = a[high];
                a[high] = temp;
            }
        }
    }

    /**
     * @param num
     * @return
     * 考虑拓展性抽出来
     */
    public boolean isTrue(int num) {
        return num % 2 == 0;
    }

    void test1() {
        int[] array = null;
        System.out.println("1原始数组：" + Arrays.toString(array));
        apply1(array);
        System.out.println("调整结果：" + Arrays.toString(array));
        System.out.println();
    }

    void test2() {
        int[] array = {};
        System.out.println("2原始数组：" + Arrays.toString(array));
        apply1(array);
        System.out.println("调整结果：" + Arrays.toString(array));
        System.out.println();
    }

    void test3() {
        int[] array = {-2, 4, -6, 1, -3, 5};
        System.out.println("3原始数组：" + Arrays.toString(array));
        apply1(array);
        System.out.println("调整结果：" + Arrays.toString(array));
        System.out.println();
    }

    void test4() {
        int[] array = {-1, 3, -5, 2, -4, 6};
        System.out.println("4原始数组：" + Arrays.toString(array));
        apply1(array);
        System.out.println("调整结果：" + Arrays.toString(array));
        System.out.println();
    }

    void test5() {
        int[] array = {-1, 2, -3, 4, -5, 6};
        System.out.println("5原始数组：" + Arrays.toString(array));
        apply1(array);
        System.out.println("调整结果：" + Arrays.toString(array));
        System.out.println();
    }

    void test6() {
        int[] array = {2, 2, 1, 3, 4, 1};
        System.out.println("6原始数组：" + Arrays.toString(array));
        apply1(array);
        System.out.println("调整结果：" + Arrays.toString(array));
        System.out.println();
    }

    void test7() {
        int[] array = {1};
        System.out.println("7原始数组：" + Arrays.toString(array));
        apply1(array);
        System.out.println("调整结果：" + Arrays.toString(array));
        System.out.println();
    }

    public static void main(String[] args) {
        ReorderArray_21 demo = new ReorderArray_21();
        demo.test1();
        demo.test2();
        demo.test3();
        demo.test4();
        demo.test5();
        demo.test6();
        demo.test7();
    }

}
