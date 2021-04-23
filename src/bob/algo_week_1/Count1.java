package bob.algo_week_1;

import java.io.BufferedInputStream;
import java.util.Scanner;

/* 
给定一个长度为 n 的数列，请你求出数列中每个数的二进制表示中 1 的个数。

输入格式
第一行包含整数 n。

第二行包含 n 个整数，表示整个数列。

输出格式
共一行，包含 n 个整数，其中的第 i 个数表示数列中的第 i 个数的二进制表示中 1 的个数。

数据范围
1≤n≤100000,
0≤数列中元素的值≤109
输入样例：
5
1 2 3 4 5
输出样例：
1 1 2 1 2

思路：
求n的第k位二进制数字: n >> k & 1
返回n的最后一位1：lowbit(n) = n & -n
负数 = 补码 = 反码+1

例:将10与-10进行按位与(&)运算：
0000 0000 0000 1010
1111 1111 1111 0110
-----------------------
0000 0000 0000 0010
所以：10 & -10 = 0000 0000 0000 0010   //得到最后一位
*/
public class Count1 {
    public static void main(String[] args) {

        Scanner s = new Scanner(new BufferedInputStream(System.in));
        int n = s.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
    // 方法1：每次去掉最后一位
        // for (int i = 0; i < n; i++) {
        // System.out.print(countByte(a[i]) + " ");
        // }
    // 方法2：每次保留最后一位  n & -n
        for (int i = 0; i < n; i++) {
            int res = 0;
            for (int j= a[i]; j > 0; j -= j & -j) {
                res++;
            }
            System.out.print(res+" ");
        }
        System.out.println();
    }

    public static int countByte(int n) {
        int res = 0;
        while (n > 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }
}
