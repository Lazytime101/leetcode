package src.stringtoInt_8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    /**
     * @param str
     * @return bad case  "+-2" 所以只有第一个符号处理
     * bad case"   -42"
     * bad case"   +0 123"
     * bad case"   "-6147483648"
     * bad case "0000000000012345678"
     * bad case "010"
     * bad case "0-10"
     * 简单的方法，待改进
     */
    public static int myAtoi(String str) {
        long res = 0;
        char[] a = str.toCharArray();
        int size = a.length;
        List<String> temp = new ArrayList<String>();
        //有效数字
        int length = 0;
        int sign = 1;
        //有效标记
        int signflag = 0;

        //step 1 匹配数字并存储
        //符号只能在首位匹配
        //有效数字之前的0忽略
        //有效数字后的任何非数字都忽略
        //数组越界情况考虑
        for (int i = 0; i < size; i++) {
            if (a[i] == ' ' && signflag == 0) continue;
            else if (a[i] == '+' && signflag == 0) {
                sign = 1;
                signflag++;
            } else if (a[i] == '-' && signflag == 0) {
                sign = -1;
                signflag++;
            } else if (a[i] >= '1' && a[i] <= '9') {
                temp.add(String.valueOf(a[i]));
                signflag++;
                length++;
            } else if (a[i] == '0' && length != 0) {
                temp.add(String.valueOf(a[i]));
                length++;
                signflag++;
            } else if (a[i] == '0') {
                signflag++;
                continue;
            } else break;
        }

        if (Math.pow(10, (length - 1)) > Integer.MAX_VALUE)
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

        for (int i = 0; i < length; i++) {
            double base = Math.pow(10, (length - i - 1));
            res = Long.valueOf(temp.get(i)) * (long) base + res;
        }
        res = res * sign;
        if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (res < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) res;
    }


    public static int myAtoi1(String str) {
        int index = 0;
        int total = 0;
        int sign = 1;
        if (str.length() == 0) return 0;

        //step 1 跳过空
        while (index < str.length() && str.charAt(index) == ' ')
            index++;

        if (index == str.length()) return 0;

        //step 2 get sign
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        //step 3
        while (index < str.length()) {
            int n = str.charAt(index) - '0';
            if (n < 0 || n > 9) break;

            if (Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < n) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total = total * 10 + n;
            index ++;
        }
        return sign * total;
    }


    public static void main(String[] args) {
        String str = "  -42";
        System.out.println(myAtoi1(str));
    }
}