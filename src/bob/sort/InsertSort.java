package bob.sort;

public class InsertSort {
    //int[] arr = {101, 34, 119, 1, -1, 89};
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1, -1, 89};
        insertSort2(arr);
        print(arr);
    }


    public static void insertSort(int[] arr) {
        int insertValue = 0;
        int insertIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            insertValue = arr[i];
            insertIndex = i;
            while (insertIndex - 1 >= 0 && insertValue < arr[insertIndex - 1]) {
                arr[insertIndex] = arr[insertIndex - 1];
                insertIndex--;
            }
            if (insertIndex != i) {
                arr[insertIndex] = insertValue;
            }
        }
    }

    public static void insertSort2(int[] arr) {
        int insertValue;
        int i;
        int j;
        for (i = 1; i < arr.length; i++) {
            insertValue = arr[i];
            for (j = i-1; j >= 0 && arr[j] > insertValue; j--) {
                    arr[j+1] = arr[j ];
            }
            arr[j+1] = insertValue;
        }
    }


    public static void print(int[] arr) {

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
