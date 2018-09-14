package plusone_65;

public class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        //从末尾开始累加，如果本位为9 进位，小于9加1 返回
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            //else 情况 进位
            digits[i] = 0;
        }
        //最后一位进位情况 ,生成最开始的一位为1，其余默认初始化为0
        int[] newArray = new int[n + 1];
        newArray[0] = 1;
        return newArray;
    }
}
