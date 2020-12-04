package bob.algo_week_1;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddHighPricision {

    public static void main(String[] args) {
        String a, b;
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        a = scanner.nextLine();
        b = scanner.nextLine();

        List<Integer> x = Stream.iterate(0, n -> n + 1).limit(a.length())
                .map(n -> (int) a.charAt(a.length() - 1 - n) - '0').collect(Collectors.toList());
        List<Integer> y = Stream.iterate(0, m -> m + 1).limit(b.length())
                .map(m -> Integer.parseInt(String.valueOf(b.charAt(b.length() - m - 1)))).collect(Collectors.toList());

        // System.out.println(x.toString());
        // System.out.println(y.toString());

        List<Integer> c = add(x, y);
        int n = c.size();
        for (int i = 1; i < n; i++) {
            System.out.print(c.get(n - i));
        }

    }

    public static List<Integer> add(List<Integer> a, List<Integer> b) {
        if (a.size() < b.size())
            return add(b, a);

        List<Integer> c = new ArrayList<>();
        int t = 0;
        for (int i = 0; i < a.size(); i++) {
            t += a.get(i);
            if (i < b.size()) {
                t += b.get(i);
            }
            c.add(t % 10);
            t /= 10;
        }
        if (t > 0)
            c.add(t);

        return c;
    }
}
