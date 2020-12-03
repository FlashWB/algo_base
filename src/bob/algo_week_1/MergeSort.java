package bob.algo_week_1;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author bob
 */
public class MergeSort {
    public static void main(String[] args) {
//        Integer[] arr = { 8, 4, 5, 7, 1, 3, 6, 2 };
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int n = scanner.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Integer[] temp = new Integer[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
        for (int i = 0; i < n; i++) {
            System.out.printf(arr[i] + " ");
        }
    }

    public static <T extends Comparable<? super T>>
    void mergeSort(T[] arr, T[] arrTemp, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + right >> 1;
        mergeSort(arr, arrTemp, left, mid);
        mergeSort(arr, arrTemp, mid + 1, right);
        int t = 0; // 在temp数组中存储
        int i = left, j = mid + 1;
        while (i <= mid && j <= right) {
            if (arr[i].compareTo(arr[j]) < 0) {
                arrTemp[t++] = arr[i++];
            } else {
                arrTemp[t++] = arr[j++];
            }
        }
        while (i <= mid) {
            arrTemp[t++] = arr[i++];
        }
        while (j <= right) {
            arrTemp[t++] = arr[j++];
        }
        for (i = 0, j = left; i < t; j++, i++) {
            arr[j] = arrTemp[i];
        }
    }

}
