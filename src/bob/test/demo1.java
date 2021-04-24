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
        Integer[] arr = new Integer[] { 8, 5, 7, 1, 3, 6, 2 ,10};
        List<Integer> list = Arrays.asList(arr);
    //    list = list.stream().sorted((a, b) -> {
    //         return a - b > 0 ? 1 : (a - b == 0 ? 0 : -1);
    //     }).collect(Collectors.toList());
        // System.out.printf(list.toString());
        list = list.stream().sorted(Comparator.comparing(e->e)).collect(Collectors.toList());
        System.out.println(list);
        System.out.println(binarySeary(10, list));

    }
    public static int binarySeary(int x, List<Integer> list) {
        int l = 0, r = list.size() - 1;
        while(l<=r){
            int mid = l+r>>1;
            if(list.get(mid) < x){
                l = mid+1;
            }else if(list.get(mid)> x){
                r=mid-1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
