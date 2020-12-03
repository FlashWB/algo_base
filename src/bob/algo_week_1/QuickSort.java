package bob.algo_week_1;


import java.io.BufferedInputStream;
import java.util.Scanner;

/*给定你一个长度为n的整数数列。

        请你使用快速排序对这个数列按照从小到大进行排序。

        并将排好序的数列按顺序输出。

        输入格式
        输入共两行，第一行包含整数 n。

        第二行包含 n 个整数（所有整数均在1~109范围内），表示整个数列。

        输出格式
        输出共一行，包含 n 个整数，表示排好序的数列。

        数据范围
        1≤n≤100000
        输入样例：
        5
        3 1 2 4 5
        输出样例：
        1 2 3 4 5*/
public class QuickSort {
    public static void main(String[] args) {
//        int[] arr = {1, 5, 2, 3, 9, 2, 8};
        /*
         * l = 0; r = 6  */
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = scanner.nextInt();
        }

        quickSort(arr, 0, arr.length - 1);
        System.out.println(arr[k]);
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int x = arr[l + r >> 1];
        int left = l - 1, right = r + 1;
        while (left < right) {
            do {
                left++;
            } while (arr[left] < x);
            do {
                right--;
            } while (arr[right] > x);
            if (left < right) {
                int t = arr[left];
                arr[left] = arr[right];
                arr[right] = t;
            }
        }
        quickSort(arr, l, right);
        quickSort(arr, right + 1, r);
    }

}
