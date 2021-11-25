package others;

import java.util.Arrays;
import java.util.List;

public class QuickSort {
    public static void main(String[] args) {
        /*
            5 2 4 1 3
            3 2 4 1 5
            3 2 1 4 5
         */
        int[] arr = new int[]{5, 2, 4, 1, 3};
        new QuickSort().process(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{4, 6, 2, 5, 1};
        new QuickSort().process(arr);
        System.out.println(Arrays.toString(arr));

    }

    void process(int arr[]) {
        sort(arr, 0, arr.length - 1);
    }

    void sort(int arr[], int left, int right) {
        if (left >= right) return;

        // partition
        int idx = partition(arr, left, right);
        System.out.println(Arrays.toString(arr));
        System.out.println(idx);

        // sort left and right respectively
        sort(arr, left, idx - 1);
        sort(arr, idx, right);
    }

    /*
        4 6 2 5 1

        idx 2 - pivot
        1 6 2 5 4
        1 2 6 5 4

        return index of partition
     */
    int partition(int arr[], int left, int right) {
        int p = arr[(left + right) / 2];

        while (left < right) {
            while(left < right && arr[left] < p) {
                left++;
            }

            while(left < right && arr[right] > p) {
                right--;
            }

            swap(arr, left, right);
            left++;
            right--;
        }

        return left;
    }

    void swap(int arr[], int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
