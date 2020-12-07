package bob.search;

import java.util.Arrays;

public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int index = insertValueSearch(arr1,15);
//        int index = insertValueSearch(arr1,0,arr1.length-1,15);
        System.out.println(Arrays.toString(arr1));
        System.out.println(index);

    }

    public static int insertValueSearch(int[] arr, int find) {
        int l = 0;
        int r = arr.length - 1;
        if (l > r || find < arr[0] || find > arr[arr.length - 1]) {
            return -1;
        }

        while (l < r) {
            int mid = l + (r - l) * (find - arr[l]) / (arr[r] - arr[l]);
            if (find > arr[mid]) {
                l = mid + 1;
            } else if (find < arr[mid]) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int insertValueSearch(int[] arr, int l, int r, int find){
        if (l > r||find<arr[0]||find>arr[arr.length-1]) {
            return -1;
        }

        int mid =l+(r-l)*(find-arr[l])/(arr[r]-arr[l]);

        if (find > arr[mid]) {
            return insertValueSearch(arr, mid + 1, r, find);
        } else if (find < arr[mid]) {
            return insertValueSearch(arr, l, mid - 1, find);
        } else {
            return mid;
        }
    }



}
