package bob.sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        shellSort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort1(int[] arr) {
        int arrLength = arr.length;

        int inserted;
        for (int gap = arrLength / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arrLength; i++) {
//                insertI(arr, gap, i)
                for (int j = i - gap; j >= 0; j = j - gap) {
                    if (arr[j] > arr[j + gap]) {
                        inserted = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = inserted;
                    }
                }
            }
        }

    }

    public static void insertI(int arr[], int gap, int i) {
        int inserted = arr[i];
        int j;
        for (j = i - gap; j > 0; j = j - gap) {
            if (inserted < arr[j]) {
                arr[j + gap] = arr[j];
            }
        }
        arr[j + gap] = inserted;
    }


    public static void shellSort2(int[] arr) {
        int arrLengh = arr.length;
        int gap = 1; 

        int insertVal ;
        int insertIndex;

        while (gap < arrLengh) {
            gap = gap * 3 + 1;
        }
        while (gap >= 1) {
            for(int i =gap;i<arrLengh;i++){
                insertVal = arr[i];
                insertIndex = i-gap;
                while (insertIndex>=0 && insertVal<arr[insertIndex]){
                    arr[insertIndex+gap] = arr[insertIndex];
                    insertIndex-=gap;
                }
                arr[insertIndex+gap] = insertVal;

            }

            gap = (int) Math.floor(gap / 3);
        }
    }

}
