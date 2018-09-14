package src.longest_substring_3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static constant.Constant.HASHMAP_INIT_NUM;

/**
 * @author lazytime
 */
public class longestSubstring {

    /**
     * @param s
     * @return int
     *  返回没有重复字母的最大长度
     *  强行遍历，效率比较低 ,O(n^3)
     *  外层循环为n，每一个中从i到j 结束
     */
    public int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        int maxLength = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (isAllUnique(s, i, j)){
                    maxLength = Math.max(maxLength, j - i);
                }
        return maxLength;
    }

    private boolean isAllUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        return true;
    }


    /**
     * @param s
     * @return int
     * 通过使用HashSet作为滑动窗口，检查当前是否可以完成当前字符
     * 在滑动之前可以确保窗口内的部分没有重复，并已经更新了最大值
     * 所以可以向右边进行尝试（删去左侧的一个点）
     * 最多时间复杂性（o（2n）） 空间复杂性 O(min(m, n)) m代表最后string/set.length
     *
     *
     * 超越了50%的算法
     */
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int maxSize = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                maxSize = Math.max(maxSize, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return maxSize;
    }


    /**
     * @param s
     * @return int
     * 和上面思路一致，但我们可以跳的更快一些，a[i，j]中有重复，找到j对应的j'，此时i应该从j'开始尝试
     * only beats 20%
     * 将HashMap 初始值提高到128 beats 44%
     */
        public int lengthOfLongestSubstring3(String s) {
            int n = s.length(), MaxLength = 0;
            Map<Character, Integer> map = new HashMap<>(HASHMAP_INIT_NUM); 
            // current index of character
            // try to extend the range [i, j]
            for (int j = 0, i = 0; j < n; j++) {
                if (map.containsKey(s.charAt(j))) {
                    i = Math.max(map.get(s.charAt(j)), i);
                }
                MaxLength = Math.max(MaxLength, j - i + 1);
                map.put(s.charAt(j), j + 1);
            }
            return MaxLength;
        }


    /**
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring4(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
    





}
