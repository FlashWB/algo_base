package bob.algo_week_1;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Inversions {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int n = scanner.nextInt();
        int[] arr = new int[n];
//       Integer[] arr = new Integer[]{8, 4, 5, 7, 1, 3, 6, 2};
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int[] temp = new int[arr.length];
        System.out.println(mergeSort(arr, temp, 0, arr.length - 1));
        System.out.println(Arrays.toString(arr));

    }

    public static
    long mergeSort(int[] arr, int[] arrTemp, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = left + right >> 1;
        long res = mergeSort(arr, arrTemp, left, mid) +
                mergeSort(arr, arrTemp, mid + 1, right);
        int t = 0; // ��temp�����д洢
        int i = left, j = mid + 1;
        while (i <= mid && j <= right) {
            if (arr[i]<= arr[j] ) {
                arrTemp[t++] = arr[i++];
            } else {
                arrTemp[t++] = arr[j++];
                res += mid - i + 1;
            }
        }
        while (i <= mid) {
            arrTemp[t++] = arr[i++];
        }
        while (j <= right) {
            arrTemp[t++] = arr[j++];
        }
        for (i = 0, j = left; j <= right; j++, i++) {
            arr[j] = arrTemp[i];
        }
        return res;
    }

}
