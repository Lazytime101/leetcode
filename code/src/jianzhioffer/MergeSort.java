package src.jianzhioffer;

import java.util.Arrays;

public class MergeSort {
    public void sort(int[] a, int low, int high) {
        if (low >= high) return;
        int mid = low + (high - low) / 2;
        sort(a, low, mid);
        sort(a, mid + 1, high);
        merge(a,low,mid,high);
    }

    public void merge(int[] a, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int[] temp = new int[right - left + 1];
        for (int k = 0; k <= right; k++) {
            temp[k] = a[k];
        }
        for (int k = 0; k <= right; k++) {
            if (i > mid) a[k++] = temp[j++];
            if (j > right) a[k++] = temp[i++];
            if (a[i] > a[j]) a[k++] = a[i++];
            else a[k++] = a[j++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {6623722,3,1,283821983};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(a -> System.out.println(a));


    }
}
