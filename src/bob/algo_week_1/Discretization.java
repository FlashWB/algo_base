package bob.algo_week_1;

import java.io.BufferedInputStream;
import java.util.*;
import java.util.stream.*;

/* 
假定有一个无限长的数轴，数轴上每个坐标上的数都是 0。
现在，我们首先进行 n 次操作，每次操作将某一位置 x 上的数加 c。
接下来，进行 m 次询问，每个询问包含两个整数 l 和 r，你需要求出在区间 [l,r] 之间的所有数的和。

输入格式
第一行包含两个整数 n 和 m。
接下来 n 行，每行包含两个整数 x 和 c。
再接下来 m 行，每行包含两个整数 l 和 r。

输出格式
共 m 行，每行输出一个询问中所求的区间内数字和。

数据范围
−109≤x≤109,
1≤n,m≤105,
−109≤l≤r≤109,
−10000≤c≤10000
输入样例：
3 3
1 2
3 6
7 5
1 3
4 6
7 8
输出样例：
8
0
5 */
public class Discretization {
    public static void main(String[] args) {
        Scanner s = new Scanner(new BufferedInputStream(System.in));
        int n = s.nextInt();
        int m = s.nextInt();
        int N = 300000; // 涉及n+2m个数，
        List<Integer> all = new ArrayList<>(); // 存储所有使用到的数轴上的点，n+2m个，需要离散化，压缩
        List<pair> add = new ArrayList<>(); // n次加操作
        List<pair> select = new ArrayList<>(); // m次查询操作
        int[] a = new int[N]; // 对位置x上的数加C
        int[] b = new int[N]; // a的前缀和

        int x, c, l, r;
        for (int i = 0; i < n; i++) {
            x = s.nextInt();
            c = s.nextInt();
            add.add(new pair(x, c));
            all.add(x);
        }
        for (int i = 0; i < m; i++) {
            l = s.nextInt();
            r = s.nextInt();
            select.add(new pair(l, r));
            all.add(l);
            all.add(r);
        }
        // 对涉及到的坐标排序去重
        all = all.stream().sorted().distinct().collect(Collectors.toList());
        for (int i = 0; i < add.size(); i++) {
            int index = binarySearch(add.get(i).x, all);
            a[index] += add.get(i).y;
        }
        // 求前缀和
        for (int i = 1; i <= all.size(); i++) {
            b[i] = b[i - 1] + a[i - 1];
        }
        for (pair item : select) {
            l = binarySearch(item.x, all);
            r = binarySearch(item.y, all);
            System.out.println(b[r+1]-b[l]);  // 注意，前缀和序列是从1开始，需要将索引+1
        }

    }

    // 二分查找 返回x在list索引
    public static int binarySearch(int x, List<Integer> list) {
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (list.get(mid) < x) {
                l = mid+1;
            } else {
                r = mid ;
            }
        }
        return l;
    }

}

class pair {
    int x;
    int y;

    public pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}