package bob.algo_week_1;
/* 
给定一个长度为n的整数序列，请找出最长的不包含重复的数的连续区间，输出它的长度。

输入格式
第一行包含整数n。

第二行包含n个整数（均在0~100000范围内），表示整数序列。

输出格式
共一行，包含一个整数，表示最长的不包含重复的数的连续区间的长度。

数据范围
1≤n≤100000
输入样例：
5
1 2 2 3 5
输出样例：
3
 */
import java.io.BufferedInputStream;
import java.util.Scanner;

public class LengestSequence {
    private static int MAX_LENGTH = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        // 双指针法, i右指针，j左指针
        for (int i = 0, j = 0; i < n; i++) {
            while (j < i && check(i, j, a))
                j++;
        }
System.out.println(MAX_LENGTH);
    }

    public static boolean check(int i, int j, int[] a) {
        for (int x = j; x < i; x++) {
            if (a[x] == a[i]) {
                return true;
            }
        }
        if (i-j + 1 > MAX_LENGTH)
            MAX_LENGTH = i-j + 1;
        return false;
    }

}