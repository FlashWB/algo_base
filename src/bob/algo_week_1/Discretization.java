package bob.algo_week_1;

import java.io.BufferedInputStream;
import java.util.*;
import java.util.stream.*;

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
        Collections.sort(all);
        for (int i = 0; i < add.size(); i++) {
            Collections.binarySearch(all, add.get(i).x);
        }

    }

    public static int binarySearch(int x, List<Integer> list) {
        int l = 0, r = list.size() - 1;
        while(l<=r){
            int mid = l+r>>1;
            if(list.get(mid) < x){
                l = mid+1;
            }else if(list.get(mid) > x){
                r=mid-1;
            }else{
                return mid;
            }
        }
        return -1;
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