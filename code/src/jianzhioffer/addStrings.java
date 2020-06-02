package src.jianzhioffer;

import helper.ListNode;

import java.util.Stack;

/**
 * 大数相加
 */
public class addStrings {

    /**
     * @param s1: a non-negative integers
     * @param s2: a non-negative integers
     * @return: return sum of num1 and num2
     * tip: 不能直接用Integer转换
     * 其实还可以检查每一位是否为数字
     */
    public static String addStrings(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0)
            return "";

        char[] a1 = s1.toCharArray();
        char[] a2 = s2.toCharArray();
        int len1 = a1.length;
        int len2 = a2.length;
        int i = len1 - 1;
        int j = len2 - 1;
        //当前之和，后来存储余数
        int sum = 0;
        //进位
        int carried = 0;
        StringBuilder str = new StringBuilder();

        while (i >= 0 || j >= 0) {
            int curr1 = 0;
            int curr2 = 0;
            if (i >= 0) {
                curr1 = a1[i--] - '0';
                if (curr1 < 0 || curr1 > 9) {
                    return "";
                }
            } else {
                curr1 = 0;
            }

            if (j >= 0) {
                curr2 = a2[j--] - '0';
                if (curr2 < 0 || curr2 > 9) {
                    return "";
                }
            } else {
                curr2 = 0;
            }

            sum = curr1 + curr2 + carried;
            carried = sum / 10;
            sum = sum % 10;
            str.append(sum);
        }
        if (carried != 0) {
            str.append(carried);
        }
        return str.reverse().toString();
    }


    public void test1() {
        String s1 = "123";
        String s2 = "45";
        System.out.println(addStrings(s1, s2));
    }

    public void test2() {
        String s1 = "123x";
        String s2 = "45";
        System.out.println(addStrings(s1, s2));
    }

    public static void main(String[] args) {
        addStrings addStrings = new addStrings();
        addStrings.test1();
        addStrings.test2();

    }


}
