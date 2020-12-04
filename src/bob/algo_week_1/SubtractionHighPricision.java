package bob.algo_week_1;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SubtractionHighPricision {
    public static void main(String[] args) {
        String a, b;
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        a = scanner.nextLine();
        b = scanner.nextLine();

        List<Integer> x = new ArrayList<>(a.length());
        List<Integer> y = new ArrayList<>(b.length());

        x = Stream.iterate(1, n->n+1).limit(a.length()).map(n->(int)a.charAt(a.length()-n)-'0').collect(Collectors.toList());
        y = Stream.iterate(1, n->n+1).limit(b.length()).map(n->(int)b.charAt(b.length()-n)-'0').collect(Collectors.toList());




        System.out.println();
    }

    
   public static List<Integer> sub(List<Integer> x, List<Integer> y) {
       if(x.size()<y.size()) return sub(y, x)
       List<Integer> c = new ArrayList<>();
       k
   }




}
