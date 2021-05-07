package bob.algo_week_1;

import java.io.BufferedInputStream;
import java.util.*;
import java.util.stream.*;


/* 
给定 n 个区间 [li,ri]，要求合并所有有交集的区间。
注意如果在端点处相交，也算有交集。
输出合并完成后的区间个数。
例如：[1,3] 和 [2,6] 可以合并为一个区间 [1,6]。

输入格式
第一行包含整数 n。
接下来 n 行，每行包含两个整数 l 和 r。

输出格式
共一行，包含一个整数，表示合并区间完成后的区间个数。

数据范围
1≤n≤100000,
−109≤li≤ri≤109
输入样例：
5
1 2
2 4
5 6
7 8
7 9
输出样例：
3
难度：简单
时/空限制：1s / 64MB
总通过数：12253
总尝试数：19674
*/
public class MergeRange {
    public static void main(String[] args) {
        Scanner s = new Scanner(new BufferedInputStream(System.in));
        int n = s.nextInt();
        List<pair> ranges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = s.nextInt();
            int y = s.nextInt();
            ranges.add(new pair(x, y));
        }
        ranges = ranges.stream().sorted(Comparator.comparing(e -> e.x)).collect(Collectors.toList());
        System.out.println(merge1(ranges));
        System.out.println(merge2(ranges).size());
    }

    /**
     * 单纯计数
     * 
     * @param ranges
     * @return
     */
    public static int merge1(List<pair> ranges) {
        pair a;
        int res = 0;
        int maxR = Integer.MIN_VALUE;
        for (int i = 0; i < ranges.size(); i++) {
            a = ranges.get(i);
            if (a.x > maxR) {
                res++;
            }
            maxR = Math.max(a.y, maxR);
        }
        return res;
    }

    /**
     * 存储合并后的集合
     * 
     * @param ranges
     * @return
     */
    public static List<pair> merge2(List<pair> ranges) {
        int l = ranges.get(0).x;
        int r = ranges.get(0).y;
        List<pair> res = new ArrayList<>();
        for (pair e : ranges) {
            if (e.x > r) {
                res.add(new pair(e.x,r));
                l = e.x;
                r = e.y;
            }
            r = Math.max(r, e.y); // 存储最后一个
        }
        res.add(new pair(l,r));
        return res;
    }

}
