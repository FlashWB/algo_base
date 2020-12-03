package bob.algo_week_1;

/*
给定一个浮点数n，求它的三次方根。

输入格式
共一行，包含一个浮点数n。

输出格式
共一行，包含一个浮点数，表示问题的解。

注意，结果保留6位小数。

数据范围
−10000≤n≤10000
输入样例：
1000.00
输出样例：
10.000000
*/

/*
 * 解法：
 * 1. 牛顿迭代法
 * 2. （因为给了左右范围）二分法迭代法
 * */



import java.io.BufferedInputStream;
import java.util.Scanner;

public class BianrySearch {
    public static void main(String[] args) {

        Scanner s = new Scanner(new BufferedInputStream(System.in));
        double n = s.nextDouble();
//        binarySearch1(n, -1000, +1000);
//        newtonSqrt(n);
        newTown2(n);
    }

    public static void binarySearch1(double x, double l, double r) {
        // 精度
        double eps = 1e-6;
        while (Math.abs(r - l) > eps) {
            double mid = (l + r) / 2;
            if (mid * mid * mid - x> 0) {
                r = mid;
            } else {
                l = mid;
            }
        }
        System.out.printf("%.6f", l);
    }


    public static void newtonSqrt(double x0) {
        double eps = 1e-6;
        double x_old;
        double x_new = x0;
        do {
            x_old = x_new;
            x_new = x_old - f(x_old, x0) / fd(x_old);
        } while (Math.abs(x_old - x_new) > eps);
        System.out.printf("%.6f", x_new);
    }
    public static void newTown2(double x0){
        double esp = 1e-6;
        double x_old = 0;
        double x_new = x0;
        while (Math.abs(x_old-x_new) > esp){
            x_old = x_new;
            x_new = x_old - f(x_old,x0)/fd(x_old);
        }
        System.out.println(x_new);

    }

    public static double f(double x, double x0) {
        return x * x * x - x0;
    }

    public static double fd(double x) {
        return 3 * x * x;
    }
}
