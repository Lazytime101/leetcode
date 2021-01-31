package src.jianzhioffer;

import java.util.Arrays;

public class Array {

    /**
     * @param a
     * 反转数组
     */
    public static void reverseArray(int[] a) {
        int i = 0;
        int j = a.length - 1;
        while (i < j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
    }


    /**
     *
     * 用ran7 计算ran10，等比例放大，找最近的一个k的倍数
     * @return
     */
    public int rand10() {
        while(true){
            int num = (rand7()-1)*7 + rand7()-1;
            if(num < 40)return num%10+1;
        }
    }


    public int rand7(){
        return  (int)Math.random();
    }


    /**
     * @param a
     * 分组两两互换
     */
    public static void sort(int[] a){
        if(a.length==0){
            return;
        }
        for(int i =0;i<a.length-1;i=i+2){
            int temp = a[i];
            a[i] = a[i+1];
            a[i+1]= temp;
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        sort(a);
        Arrays.stream(a).forEach(c-> System.out.println(c));
    }
}
