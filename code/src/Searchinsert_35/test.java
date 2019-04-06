package src.Searchinsert_35;

import javax.sound.midi.Soundbank;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class test {
    /**
     * @param args 开始的时候，忘记排序了
     */
    public static void main(String[] args) {
//        src.Searchinsert_35.Solution solution = new src.Searchinsert_35.Solution();
//        int test[] = new int[10000000];
//        Random rand = new Random();
//        for (int i = 0; i < 10000000; i++) {
//            test[i] = rand.nextInt(100);
//        }
//        Arrays.sort(test);
//        long time1 = System.currentTimeMillis();
//        solution.searchInsert(test, 50);
//        System.out.println("time1"+(System.currentTimeMillis() - time1));
//        long time2 = System.currentTimeMillis();
//        System.out.println("result" + solution.searchInsert2(test, 50));
//        System.out.println("time2 " + (System.currentTimeMillis() - time2));
//        long time3 = System.currentTimeMillis();
//        System.out.println("result" + solution.searchInsert3(test, 50));
//        System.out.println("time3"+(System.currentTimeMillis() - time3));

        List<String> a = new ArrayList();
        a.add("b");
        a.add("C");
        a.add("F");
        a=a.stream().filter(e->!e.equals("F")).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(a);

    }



}
