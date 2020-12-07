package bob.sort;

public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1, -1, 90, 123};
        selectSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(" " + arr[i]);
        }
        System.out.println();
    }

    public static void selectSort(int[] arr) {
        int minIndex = 0;
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

}
