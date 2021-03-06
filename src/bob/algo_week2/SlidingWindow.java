package bob.algo_week2;

import java.util.*;
import java.io.*;

/* 
滑动窗口协议（Sliding Window Protocol）
TCP协议的一种，允许发送方在停止并等待确认前发送多个数据分组，发送方不必每发一个分组就停下来，用于网络数据传输流量控制，避免拥塞。
滑动窗口算法在一个特定大小的字符串或数组上进行操作，而不在整个字符串和数组上操作，这样就降低了问题的复杂度，从而也达到降低了循环的嵌套深度。
窗口：窗口的大小不一定是固定的。

题目：滑动窗口
给定一个大小为 n≤106 的数组。
有一个大小为 k 的滑动窗口，它从数组的最左边移动到最右边。
你只能在窗口中看到 k 个数字。
每次滑动窗口向右移动一个位置。
以下是一个例子：
该数组为 [1 3 -1 -3 5 3 6 7]，k 为 3。
窗口位置	             最小值	最大值
[1 3 -1] -3 5 3 6 7	    -1	3
1 [3 -1 -3] 5 3 6 7	    -3	3
1 3 [-1 -3 5] 3 6 7	    -3	5
1 3 -1 [-3 5 3] 6 7	    -3	5
1 3 -1 -3 [5 3 6] 7 	3	6
1 3 -1 -3 5 [3 6 7]	    3	7
你的任务是确定滑动窗口位于每个位置时，窗口中的最大值和最小值。

输入格式
输入包含两行。
第一行包含两个整数 n 和 k，分别代表数组长度和滑动窗口的长度。
第二行有 n 个整数，代表数组的具体数值。
同行数据之间用空格隔开。

输出格式
输出包含两个。
第一行输出，从左至右，每个位置滑动窗口中的最小值。
第二行输出，从左至右，每个位置滑动窗口中的最大值。

输入样例：
8 3
1 3 -1 -3 5 3 6 7
输出样例：
-1 -3 -3 -3 3 3
3 3 5 5 6 7


=============================
实现思路：
单调队列:  按大小顺序排列的队列。


*/

public class SlidingWindow {
    static int N = 1000010;
    static int[] a = new int[N];
    static int[] q = new int[N]; // 单调队列，存储a的下标 ,单调队列，由小至大。
    static int n;
    static int k; // 区间长度

    public static void main(String[] args) {
        Scanner s = new Scanner(new BufferedInputStream(System.in));
        PrintWriter p = new PrintWriter(System.out);
        n = s.nextInt();
        k = s.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }

        // 队列的开头结尾,tt 是表示当前队列存储所用到位置，而q[ tt ]存储的是数组中元素的下标
        int hh = 0, tt = -1;
        // i是单调队列的右端点，当前访问的点
        for (int i = 0; i < n; i++) {
            // i-k+1 窗口的左端点,q中存储的是a的下标，下标小于窗口左端点的需要弹出
            if (hh <= tt && q[hh] < i - k + 1) {
                hh++;
            }
            // hh<=tt 防止队列全空的情况,
            // 队列中只存不大于当前元素的值。队列尾部比当前元素大，则减掉队列尾部
            while (hh <= tt && a[q[tt]] >= a[i])
                tt--;
            q[++tt] = i;
            // 窗口满后
            if (i + 1 >= k) {
                // 如果没有更小的，则一直输出单调队列头元素
                p.print(a[q[hh]] + " ");
            }
        }

        p.println("");
        hh = 0;
        tt = -1;
        for (int i = 0; i < n; i++) {
            if (hh <= tt && q[hh] < i - k + 1) {
                hh++;
            }
            // 队列只存储比当前元素大的，比当前元素小的都从队尾删除掉
            while (hh <= tt && a[q[tt]] < a[i]) {
                tt--;
            }
            q[++tt] = i;
            if (i + 1 >= k) {
                p.print(a[q[hh]] + " ");
            }
        }
        // 
        p.close();
    }

}
