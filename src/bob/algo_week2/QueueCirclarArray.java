package bob.algo_week2;

import java.io.BufferedInputStream;
import java.util.*;

/* 
循环队列
 */
public class QueueCirclarArray {
    static int[] queue;
    static int tt;
    static int hh;
    static int N = 100000;

    public static void main(String[] args) {
        Scanner s = new Scanner(new BufferedInputStream(System.in));
        int m = s.nextInt();
        while (m-- > 0) {
            

        }
    }

    public QueueCirclarArray() {
        queue = new int[N];
        tt = 0;
        hh = 0;
    }

    public static boolean isFull() {
        return (tt + 1) / N == hh;
    }

    public static boolean push(int x) {
        if (!isFull()) {
            queue[tt = tt++ / N] = x;
            return true;
        }
        return false;
    }

    public static int getHead() {
        return queue[hh];
    }

    public static boolean isEmpty() {
        return tt == hh;
    }

}