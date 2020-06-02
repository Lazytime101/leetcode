package src.merge_88;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] temp = new int[m];
        for (int i = 0; i <= m-1; i++) {
            temp[i] = nums1[i];
        }
        int a = 0;
        int b = 0;
        int end = 0;
        int curr1 = 0;
        int curr2 = 0;
        int result = 0;

        while (a <= m - 1 || b <= n - 1) {

            if (a <= m - 1) {
                 curr1 = temp[a];
            } else {
                result = nums2[b++];
                nums1[end++] = result;
                continue;
            }

            if (b <= n - 1) {
                 curr2 = nums2[b];

            } else {
                result = temp[a++];
                nums1[end++] = result;
                continue;
            }
            if(curr1<=curr2){
                nums1[end++] = curr1;
                a++;
            }else {
                nums1[end++] = curr2;
                b++;
            }
        }

    }
}
