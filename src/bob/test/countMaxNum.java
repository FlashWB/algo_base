package bob.test;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class countMaxNum {
    public static void main(String[] args) {
        Scanner s = new Scanner(new BufferedInputStream(System.in));
        int x = s.nextInt();
        int n = s.nextInt();
        int m = s.nextInt();
        // int x = 4, n = 4, m = 4;
        // int tt = 16;
        // int tt2 = tt;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            // int x = 4, n = 4, m = 4;
            int tt = s.nextInt();
            int tt2 = tt;
            tt = tt << (32 - n - m);
            tt = tt >> (32 - n - m);
            tt = tt >> n;
            tt = tt << n;

            tt = tt << (16 - n - m);
            tt2 = tt2 >> (32 - m);
            list.add(tt + tt2);
        }
        List<Integer> list2 = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    list2.add(list.get(i));
                    break;
                }
            }
        }

        count++;
        for (Integer obj : list) {
            if (map.containsKey(obj)) {
                count++;
                map.put(obj, map.get(obj).intValue() + 1);
            } else {
                map.put(obj, 1);
            }
        }
        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();

        list2.clear();
        while (it.hasNext()) {
            Entry<Integer, Integer> entry = it.next();
            if (entry.getValue() == count) {
                list2.add(entry.getKey());
                // System.out.println("key=" + entry.getKey() + "," + "value=" +
                // entry.getValue());
            }
        }
        if (list2.size() == 1) {
            System.out.println(list2.get(0));
        } else {
            System.out.println(-1);
        }

    }
}
