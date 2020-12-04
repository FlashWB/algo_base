package bob.algo_week_1;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SubtractionHighPricision {
    public static void main(String[] args) {
        String a, b;
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        a = scanner.nextLine();
        b = scanner.nextLine();

        List<Integer> x = Stream.iterate(1, n -> n + 1).limit(a.length()).map(n -> (int) a.charAt(a.length() - n) - '0')
                .collect(Collectors.toList());
        List<Integer> y = Stream.iterate(1, n -> n + 1).limit(b.length()).map(n -> (int) b.charAt(b.length() - n) - '0')
                .collect(Collectors.toList());

                System.out.println(sub(x,y));
        sub(x, y).stream().forEach(System.out::print);

    }

    public static List<Integer> sub(List<Integer> x, List<Integer> y) {
        if (x.size() < y.size())
            return sub(y, x);
        int t = 0;
        List<Integer> c = new ArrayList<>();
        for (int i = 0; i < x.size(); i++) {
            t = x.get(i) - t;
            if (i < y.size()) {
                t -= y.get(i);
            }
            c.add((t + 10) % 10);
            if (t < 0)
                t = 1;
            else
                t = 0;
        }
        Collections.reverse(c);
        return c;
    }

}
