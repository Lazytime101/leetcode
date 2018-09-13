package Searchinsert_35;

class Solution {

    /**
     * @param nums
     * @param target
     * @return int
     * 已经排序的数组，找到对应插入位置
     * 二分查找变形  要牢记
     */
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    public int binarySearch(int[] nums, int start, int end, int target) {
        while (start + 1 < end) {

            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                end = mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid;
            }
        }
        if (nums[start] >= target) return start;
        else if (nums[end] >= target) return end;
        return nums.length;
    }


    /**
     * @param nums
     * @param target
     * @return 为什么递归效率高
     */
    public int searchInsert2(int[] nums, int target) {
        return binary2(nums, target, 0, nums.length - 1);
    }

    public int binary2(int[] nums, int target, int low, int high) {
        if (low >= high) {
            if (nums[low] >= target)
                return low;
            else
                return low + 1;
        }
        int mid = (high + low) / 2;
        if (nums[mid] == target)
            return mid;
        if (nums[mid] > target)
            return binary2(nums, target, low, mid - 1);
        else
            return binary2(nums, target, mid + 1, high);
    }


    /**
     * @param nums
     * @param target
     * @return 这个比较差，但是在leetcode 中效率比我第一个还高，在大数据量情况下，效率低
     */
    public int searchInsert3(int[] nums, int target) {

        int i = 0;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] < target)
                continue;
            else
                return i;
        }
        return i;
    }


}