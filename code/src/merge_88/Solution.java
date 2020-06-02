package src.merge_88;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] temp = new int[m];
        //copy array
        for (int i = 0; i <= m - 1; i++) {
            temp[i] = nums1[i];
        }
        int a = 0;
        int b = 0;
        int end = 0;

        while (a <= m - 1 || b <= n - 1) {
            if (a > m - 1) {
                nums1[end++] = nums2[b++];
                continue;
            }

            if (b > n - 1) {
                nums1[end++] = temp[a++];
                continue;
            }

            if (temp[a] <= nums2[b]) {
                nums1[end++] = temp[a];
                a++;
            } else {
                nums1[end++] = nums2[b];
                b++;
            }
        }
    }


    /**
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     * 减少一次copy 数组
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int tail1 = m - 1, tail2 = n - 1, finished = m + n - 1;
        while (tail1 >= 0 && tail2 >= 0) {
            nums1[finished--] = (nums1[tail1] >= nums2[tail2]) ? nums1[tail1--] : nums2[tail2--];
        }
        while (tail2 >= 0) {
            nums1[finished--] = nums2[tail2--];
        }
    }
}
