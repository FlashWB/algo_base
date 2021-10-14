package bob.algo_week2;

import java.io.*;
import java.util.*;

/**
 * 给定一个模式串 S，以及一个模板串 P，所有字符串中只包含大小写英文字母以及阿拉伯数字。 模板串 P 在模式串 S 中多次作为子串出现。 求出模板串 P
 * 在模式串 S 中所有出现的位置的起始下标。
 * 
 * 输入格式 第一行输入整数 N，表示字符串 P 的长度。 第二行输入字符串 P。 第三行输入整数 M，表示字符串 S 的长度。 第四行输入字符串 S。
 * 
 * 输出格式 共一行，输出所有出现位置的起始下标（下标从 0 开始计数），整数之间用空格隔开。
 * 
 * 数据范围 1≤N≤105 1≤M≤106 输入样例： 3 aba 5 ababa 输出样例： 0 2
 */
public class KMP {
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) {
        Scanner s = new Scanner(new BufferedInputStream(System.in));
        int n = s.nextInt();
        String p = s.next();

        int m = s.nextInt();
        String str = s.next();
        char[] pp = p.toCharArray();
        char[] ss = str.toCharArray();
        int[] ne = new int[pp.length + 1];

        // next数组第一个位置空出来，ne[i+1] 对应i位置的最大子集
        for (int i = 1, j = 0; i < n; i++) {
            while (j > 0 && pp[i] != pp[j]) {
                j = ne[j - 1];
            }
            if (pp[i] == pp[j]) {
                j++;
            }
            ne[i] = j;
        }
        for (int i = 0, j = 0; i < m; i++) {
            while (j > 0 && ss[i] != pp[j]) {
                j = ne[j - 1];
            }
            if (ss[i] == pp[j]) {
                j++;
            }
            if(j==n){
                out.print(i-n+1 +" ");
                j = ne[n-1];
            }
        }

        out.flush();

    }
}
