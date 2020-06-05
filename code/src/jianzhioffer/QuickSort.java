package src.jianzhioffer;

import java.util.Arrays;

public class QuickSort {

    public void sort(int[] arr, int low, int high) {
        if (low >= high) return;
        int mid = partition(arr, low, high);
        sort(arr, low, mid - 1);
        sort(arr, mid + 1, high);
    }

    public int partition(int[] a, int low, int high) {
        int i = low;
        int j = high+1;
        int v = a[low];
        while (true) {
            while (a[++i] < v)
                if (i == high) break;
            while (a[--j] > v)
                if (j == low) break;
            if (i >= j) break;
            excharge(a, i, j);
        }
        excharge(a,low,j);
        return j;

    }

    public void excharge(int[] a, int i, int j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 2, 3, 0, 7, 3, 4, 5};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr, 0, arr.length - 1);

        Arrays.stream(arr).forEach(a -> System.out.println(a));
    }


}
