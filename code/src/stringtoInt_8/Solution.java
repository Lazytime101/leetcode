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


    public static void main(String[] args) {
        String str = "2147483646";
        System.out.println(myAtoi(str));
    }
}