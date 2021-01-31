package src.jianzhioffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class java_chuandi {


    /**
     * @param args 对java 传递的简单理解
     *             对于基本类型 num ，赋值运算符会直接改变变量的值，原来的值被覆盖掉。
     *             对于引用类型 str，赋值运算符会改变引用中所保存的地址，原来的地址被覆盖掉。但是原来的对象不会被改变（重要）
     *             对于引用类型 如果提供改变对象方法，可以改变传入参数
     */
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        add(list);
        for (Integer j : list) {
            System.out.println(j);
        }
        System.out.println("*********************");

        String a = "A";
        append(a);
        System.out.println(a);
        int num = 5;
        addNum(num);
        System.out.println(num);


        //基础类型
        int[] c = {1, 2};
        int b = 3;
        c[0] = b;
        b = 5;
        System.out.println(c[0]);

        //引用类型,str指向移走不影响原值
        String[] d = {"a", "d"};
        String str = "d";
        d[0] = str;
        str = "charge";
        System.out.println(d[0]);
    }

    //提供了改变对象方法
    static void add(List<Integer> list) {
        list.add(100);
    }

    //不改变原参数
    static void append(String str) {
        str += "is a";
    }

    //不改变原参数,只是创建了局部变量
    static void addNum(int a) {
        a = a + 10;
    }


    public String count(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == null) {
                map.put(str.charAt(i), 1);
            } else {
                map.put(str.charAt(i), map.get(str.charAt(i) + 1));
            }
        } for (Character s : map.keySet()) {
            if (s != str.charAt(0)) {
                stringBuilder.append("_");
            }
            stringBuilder.append(s);
            stringBuilder.append("_");
            stringBuilder.append(map.get(s));
        }
        return stringBuilder.toString();
    }


}
