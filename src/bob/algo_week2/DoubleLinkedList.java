package bob.algo_week2;

import java.io.BufferedInputStream;
import java.util.Scanner;


/* 
实现一个双链表，双链表初始为空，支持 5 种操作：

在最左侧插入一个数；
在最右侧插入一个数；
将第 k 个插入的数删除；
在第 k 个插入的数左侧插入一个数；
在第 k 个插入的数右侧插入一个数
现在要对该链表进行 M 次操作，进行完所有操作后，从左到右输出整个链表。

注意:题目中第 k 个插入的数并不是指当前链表的第 k 个数。例如操作过程中一共插入了 n 个数，则按照插入的时间顺序，这 n 个数依次为：第 1 个插入的数，第 2 个插入的数，…第 n 个插入的数。

输入格式
第一行包含整数 M，表示操作次数。

接下来 M 行，每行包含一个操作命令，操作命令可能为以下几种：

L x，表示在链表的最左端插入数 x。
R x，表示在链表的最右端插入数 x。
D k，表示将第 k 个插入的数删除。
IL k x，表示在第 k 个插入的数左侧插入一个数。
IR k x，表示在第 k 个插入的数右侧插入一个数。
输出格式
共一行，将整个链表从左到右输出。

数据范围
1≤M≤100000
所有操作保证合法。

输入样例：
10
R 7
D 1
L 3
IL 2 10
D 3
IL 2 7
L 8
R 9
IL 4 7
IR 2 2
输出样例：
8 7 7 3 2 9

思路：
l[],r[]分别是左指针，右指针列表
0,1分别是左右端点，遍历链表的时候，利用r[]遍历，从r[0]开始，直到访问到端点1
所有操作都可以通过在第k个节点右侧添加完成
 */
public class DoubleLinkedList {
    // e[]表示节点的值，l[]表示节点的左指针，r[]表示节点的右指针，idx表示当前用到了哪个节点
    public static int[] e;
    public static int[] l;
    public static int[] r;
    public static int idx;

    public static void main(String[] args) {
        init();
        Scanner s = new Scanner(new BufferedInputStream(System.in));
        int m = s.nextInt();
        int x, k;
        while (m-- > 0) {
            String o = s.next();
            // 0是左端点，1是右端点
            if (o.equals("L")) {
                x = s.nextInt();
                insert(0, x);
            } else if (o.equals("R")) {
                x = s.nextInt();
                insert(l[1], x);
            } else if (o.equals("D")) {
                k = s.nextInt();
                remove(k+1);
            } else if (o.equals("IL")) {
                k = s.nextInt();
                x = s.nextInt();
                insert(l[k+1], x);
            } else if (o.equals("IR")) {
                k = s.nextInt();
                x = s.nextInt();
                insert(k+1, x);
            } else {
                continue;
            }
        }
            // 0是左端点，1是右端点
        for(int i = r[0];i!=1;i = r[i]){
            System.out.print(e[i]+" ");
        }

    }

    // 初始化
    public static void init() {
        int n = 100000;
        e = new int[n];
        l = new int[n];
        r = new int[n];
        // 0是左端点，1是右端点，占用2个空点
        idx = 2;
        r[0] = 1;
        l[1] = 0;
    }

    // 在k节点右侧插入一个节点
    public static void insert(int k, int x) {
        e[idx] = x;
        l[idx] = k;
        r[idx] = r[k];
        l[r[idx]] = idx;
        r[k] = idx;
        idx++;
    }

    // 删除第k个节点
    public static void remove(int k) {
        l[r[k]] = l[k];
        r[l[k]] = r[k];
    }

}
