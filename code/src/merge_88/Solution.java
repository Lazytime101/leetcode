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
}
