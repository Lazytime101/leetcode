package src.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class easy1 {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 5, 7, 8, 0};
        a = apply(a);
        Arrays.stream(a).forEach(b -> System.out.println(b));
    }
    /**
     * @param a
     * @return 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，是所有的奇数位于数组的前半部分，所有偶数位于数组的后半部分。
     */
    public static int[] apply(int[] a) {
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
}
