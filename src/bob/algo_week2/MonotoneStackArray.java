package bob.algo_week2;

import java.io.BufferedInputStream;
import java.util.*;

/* 
题目： 单调栈
给定一个长度为 N 的整数数列，输出每个数左边第一个比它小的数，如果不存在则输出 −1。

输入格式
第一行包含整数 N，表示数列长度。
第二行包含 N 个整数，表示整数数列。

输出格式
共一行，包含 N 个整数，其中第 i 个数表示第 i 个数的左边第一个比它小的数，如果不存在则输出 −1。

数据范围
1≤N≤105
1≤数列中元素≤109
输入样例：
5
3 4 2 7 5
输出样例：
-1 3 -1 2 2

单调栈就是栈里面存放的数据都是有序的，所以可以分为单调递增栈和单调递减栈两种。

1.单调递增栈就是从栈底到栈顶是从大到小
2.单调递减栈就是从栈底到栈顶是从小到大

其实单调栈就是从数组中找到[左右两边]比你大的数或者比你小的数而且时间复杂度为O(N)。
*/
public class MonotoneStackArray {
    static int[] stack  = new int[100];
    static int tt = 0; // 指向栈顶上一个

    public static void main(String[] args) {
        Scanner s = new Scanner(new BufferedInputStream(System.in));
        int M = s.nextInt();
        while(M-->0){
            int x = s.nextInt();
            while(tt>0 && stack[tt]>= x){
                tt--;
            }
            if(tt>0){
                System.out.print(stack[tt] + " ");
            }else{
                System.out.print(-1 + " ");
            }
            stack[++tt] = x;
            
        }
    }
    
}
