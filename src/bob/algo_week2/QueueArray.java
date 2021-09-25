package bob.algo_week2;

import java.io.BufferedInputStream;
import java.util.*;

/* 
给定一个大小为 n≤106n≤106 的数组。
有一个大小为 kk 的滑动窗口，它从数组的最左边移动到最右边。
你只能在窗口中看到 kk 个数字。
每次滑动窗口向右移动一个位置。
以下是一个例子：
该数组为 [1 3 -1 -3 5 3 6 7]，kk 为 33。
窗口位置	最小值	最大值
[1 3 -1] -3 5 3 6 7	-1	3
1 [3 -1 -3] 5 3 6 7	-3	3
1 3 [-1 -3 5] 3 6 7	-3	5
1 3 -1 [-3 5 3] 6 7	-3	5
1 3 -1 -3 [5 3 6] 7	3	6
1 3 -1 -3 5 [3 6 7]	3	7
你的任务是确定滑动窗口位于每个位置时，窗口中的最大值和最小值。
输入格式

输入包含两行。
第一行包含两个整数 nn 和 kk，分别代表数组长度和滑动窗口的长度。
第二行有 nn 个整数，代表数组的具体数值。
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
 */

public class QueueArray {
    public static void main(String[] args) {
        Scanner s = new Scanner(new BufferedInputStream(System.in));
        int n = s.nextInt(); // 数组长度
        int k = s.nextInt(); // 滑动窗口的长度
        int[] a = new int[n];
        int[] que = new int[k]; // 队列长度
        int[] maxArr = new int[n-k+1];
        int[] minArr = new int[n-k+1];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }

        int hh = 0, tt = 0;
        int x = 0;
        while (tt < n) {
            tt++;
            // 窗口填满
            // 输出窗口内最大值
            int index = 0;
            int max = a[hh];
            int min = a[hh];
            if (tt - hh == k) {
                while (hh + index < tt) {
                    max = a[hh + index] > max ? a[hh + index] : max;
                    min = a[hh + index] < min ? a[hh + index] : min;
                    index++;
                }
                maxArr[x] = max;
                minArr[x++] = min;
                hh++;
            }
            // 输出窗口内最大值
          


        }
        for (int i = 0; i < n-k+1; i++) {
            System.out.print(minArr[i]+" ");
        }
        System.out.println();
        for (int i = 0; i < n-k+1; i++) {
            System.out.print(maxArr[i]+" ");
        }
    }

}
