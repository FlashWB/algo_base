package bob.sort;

import java.util.Arrays;


public class MergeSort {
    public static void main(String[] args) {

//        Comparable<Integer> arr[] = new Comparable[8];
        Integer[] arr = { 8, 4, 5, 7, 1, 3, 6, 2 };
        Integer[] temp = new Integer[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


    public static <T extends Comparable<? super T>> void mergeSort
            (T[] arr, T[] tmpArr, int l, int r) {
        if (l < r) {
            int center = l + r >> 1;
            mergeSort(arr, tmpArr, l, center);
            mergeSort(arr, tmpArr, center + 1, r);
            merge(arr,tmpArr,l,center+1,r);
        }
    }

    public static <T extends Comparable<? super T>> void merge
    (T[] arr, T[] tmpArray, int leftPos, int rightPos, int endPos) {

        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = endPos - leftPos + 1;
        while (leftPos <= leftEnd && rightPos <= endPos) {
            if (arr[leftPos].compareTo(arr[rightPos]) <= 0) {
                tmpArray[tmpPos++] = arr[leftPos++];
            } else {
                tmpArray[tmpPos++] = arr[rightPos++];
            }
        }
        while (leftPos <= leftEnd) {
            tmpArray[tmpPos++] = arr[leftPos++];
        }
        while (rightPos <= endPos) {
            tmpArray[tmpPos++] = arr[rightPos++];
        }
        for (int i = 0; i < numElements; i++, endPos--) {
            arr[endPos] = tmpArray[endPos];
        }
    }
}
