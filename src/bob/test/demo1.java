package bob.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class demo1 {
    public static void main(String[] args) {
        int i = 1;
        Integer[] arr = new Integer[] { 8, 4, 5, 7, 1, 3, 6, 2 };
        List<Integer> list = Arrays.asList(arr);
    //    list = list.stream().sorted((a, b) -> {
    //         return a - b > 0 ? 1 : (a - b == 0 ? 0 : -1);
    //     }).collect(Collectors.toList());
        // System.out.printf(list.toString());
        System.out.println(list.stream().sorted(Comparator.comparing(e->e)).collect(Collectors.toList()).toString());
    }
}
