package twoSum;

import java.util.HashMap;
import java.util.Map;

import static Constant.Constant.HASHMAP_INIT_NUM;

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
        Map<Integer, Integer> map = new HashMap<>(HASHMAP_INIT_NUM);
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
}
