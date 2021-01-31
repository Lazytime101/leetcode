package src.twosum_1;

import javax.swing.tree.TreeNode;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import static constant.Constant.HASHMAP_INIT_NUM;

/**
 * @author lazytime
 */
public class improveTwoSum {
    /**
     * @param nums
     * @param target
     * @return int[]
     * 主要是根据增长规则，减少了比较次数
     * 时间复杂性 n^2，空间复杂性o()
     */
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    /**
     * @param nums
     * @param target
     * @return int []
     * 通过hashmap来找，没想到学习下
     * 效率 o（n）
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap(HASHMAP_INIT_NUM);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    //一定程度上降低次数
    public int[] twoSum3(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0;i<nums.length;i++){
            int rest = target-nums[i];
            if(map.get(rest)!=null){
                return new int[]{i,map.get(rest)};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

        //test code is useful
        //first finish work
        //second test boundary
        //third reduce no useful code  to improve

        public int[] twoSum4(int[] nums, int target) {
            HashMap<Integer,Integer> map = new HashMap(100);
            for(int i=0;i<nums.length;i++){
                map.put(nums[i],i);
            }

            for(int i=0;i<nums.length;i++){
                int m = target-nums[i];
                Integer other = map.get(m);
                if(other!=null&&other!=i){
                    return new int[]{i,other};
                }
            }

            return null;
        }

    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        if (numbers == null || numbers.length < 2)
            return null;
        Arrays.sort(numbers);
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            if (numbers[l] + numbers[r] == target) {
                res[0] = numbers[l];
                res[1] = numbers[r];
                return res;
            } else if (numbers[l] + numbers[r] > target) {
                r--;
            } else {
                l++;
            }
        }
        return null;

    }

}
