package bob.test;

import java.util.Arrays;
import java.util.Comparator;

public class demo1 {
    public static void main(String[] args) {
        int i = 1;
        Integer[] arr = new Integer[]{8, 4, 5, 7, 1, 3, 6, 2};
        System.out.printf(arr[i++].toString());
        System.out.printf(" "+i);
    }
}
