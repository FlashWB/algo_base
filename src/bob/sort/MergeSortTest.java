package bob.sort;

import java.util.Arrays;

public class MergeSortTest {
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] tmpArr = new int[arr.length];
        mergeSort(arr, tmpArr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void merge(int[] arr, int[] tmpArr, int lpos, int rpos, int rEnd) {

        int ls = lpos;

        int tmppos = lpos;
        int lEnd = rpos - 1;

        int num = rEnd - lpos + 1;

        while (lpos <= lEnd && rpos <= rEnd) {
            if (arr[lpos] <= arr[rpos]) {
                tmpArr[tmppos++] = arr[lpos++];
            } else {
                tmpArr[tmppos++] = arr[rpos++];
            }
        }
        while (lpos <= lEnd) {
            tmpArr[tmppos++] = arr[lpos++];
        }
        while (rpos <= rEnd) {
            tmpArr[tmppos++] = arr[rpos++];
        }
//        for (int i = 0; i < num; i++, rEnd--) {
//            arr[rEnd] = tmpArr[rEnd];
//        }
        // ��������Ҳ����
        while (ls <= rEnd) {
            arr[ls] = tmpArr[ls++];
        }

    }

    public static void mergeSort(int[] arr, int[] tmpArr, int l, int r) {
        if (l < r) {
            int center = l + r >> 1;
            mergeSort(arr, tmpArr, l, center);
            mergeSort(arr, tmpArr, center + 1, r);
            merge(arr, tmpArr, l, center + 1, r);
        }

    }
}
