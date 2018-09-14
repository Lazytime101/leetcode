package src.twosum_1.Searchinsert_35;

import java.util.Arrays;
import java.util.Random;

public class test {
    /**
     * @param args 开始的时候，忘记排序了
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        int test[] = new int[10000000];
        Random rand = new Random();
        for (int i = 0; i < 10000000; i++) {
            test[i] = rand.nextInt(100);
        }
        Arrays.sort(test);
        long time1 = System.currentTimeMillis();
        solution.searchInsert(test, 50);
        System.out.println("time1"+(System.currentTimeMillis() - time1));
        long time2 = System.currentTimeMillis();
        System.out.println("result" + solution.searchInsert2(test, 50));
        System.out.println("time2 " + (System.currentTimeMillis() - time2));
        long time3 = System.currentTimeMillis();
        System.out.println("result" + solution.searchInsert3(test, 50));
        System.out.println("time3"+(System.currentTimeMillis() - time3));

    }
}
