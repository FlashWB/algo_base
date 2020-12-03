package bob.sort;

public class BubbleSort {

    public static void main(String[] args) {

        int[] a = {2, 1, 7, 3, 9};
        bubbleSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.printf(" " + a[i]);
        }
        System.out.println();

    }

     // o(n^2)
    public static void bubbleSort(int[] arr) {
        int temp = 0;
        boolean swapflag = false;
        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapflag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (swapflag == false) {
                break;
            } else {
                swapflag = false;
            }
        }

    }

}
