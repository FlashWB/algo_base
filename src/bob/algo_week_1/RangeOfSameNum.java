package bob.algo_week_1;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class RangeOfSameNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int q = scanner.nextInt();
        int[] arrFind = new int[q];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

      for (int i = 0; i < q; i++) {
            arrFind[i] = scanner.nextInt();
        }

        for (int i = 0; i < q; i++) {
            int index = binarySearch(arr, arrFind[i]);
            if(index == -1){
                System.out.println("-1 -1");
            }else {
                beginEnd(arr,index);
            }
        }
//        System.out.println(binarySearch(arr,q));
    }

    public static int binarySearch(int[] arr, int v) {
        int l = 0;
        int r = arr.length - 1;
        int mid;
        while (l <= r) {
            mid = l + r >> 1;
            if (v > arr[mid]) {
                l = mid + 1;
            } else if (v < arr[mid]) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void beginEnd(int[] arr, int index){
        int x = arr[index];
        int l=index,r=index;
        while (l>=0&&arr[l]==x  ){
            l--;
        }
        l++;
        while (r<arr.length && arr[r] == x){
            r++;
        }
        r--;
        System.out.println(l +" "+r);
    }
}
