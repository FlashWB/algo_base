package bob.search;

import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
//        int index = binarySearch(arr, 0, arr.length - 1, 11);
//        System.out.println(index);

        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int index = binarSearch(arr, 11);
        System.out.println(index);


    }

    public static int binarySearch(int[] arr, int l, int r, int find) {

        if (l > r || find < arr[0] || find > arr[arr.length - 1]) {
            return -1;
        }

        int mid = l + r >> 1;

        if (find > arr[mid]) {
            return binarySearch(arr, mid + 1, r, find);
        } else if (find < arr[mid]) {
            return binarySearch(arr, l, mid - 1, find);
        } else {
            return mid;
        }
    }


    public static int binarySearch1(int[] arr, int find) {
        int start = 0;
        int end = arr.length - 1;
        int mid;
        while (start <= end) {
            mid = start + end >> 1;
            if (find > arr[mid]) {
                start = mid + 1;
            } else if (find < arr[mid]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


    public static int binarSearch(int[] arr, int value) {
        int l = 0;
        int r = arr.length - 1;
        int mid;

        while (l <= r) {
            mid = l + r >> 1;
            if (value < arr[mid]) {
                r = mid - 1;
            } else if (value > arr[mid]) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int binarySearch(int x, List<Integer> list) {
        int l = 0, r = list.size() - 1;
        while(l<r){
            int mid = l+r>>1;
            if(list.get(mid) < x){
                l = mid+1;
            }else{
                r=mid;
            }
        }
        if(list.get(l)==x){
        return l;
        }else{
            return -1;
        }
    }
}
