package bob.MST;

import java.io.BufferedInputStream;
import java.util.Scanner;

/*
https://www.jianshu.com/p/89cea54d3f22
https://zhuanlan.zhihu.com/p/93647900/
并查集：主要解决元素分组问题
合并（Union）：把两个不相交的集合合并为一个集合。
查询（Find）：查询两个元素是否在同一个集合中。

并查集也是使用树形结构实现的，不过不是二叉树。



题目背景
若某个家族人员过于庞大，要判断两个是否是亲戚，确实还很不容易，现在给出某个亲戚关系图，
求任意给出的两个人是否具有亲戚关系。
题目描述
规定：x和y是亲戚，y和z是亲戚，那么x和z也是亲戚。如果x,y是亲戚，那么x的亲戚都是y的亲戚，
y的亲戚也都是x的亲戚。
输入格式
第一行：三个整数n,m,p，（n<=5000,m<=5000,p<=5000），分别表示有n个人，m个亲戚关系，
询问p对亲戚关系。
以下m行：每行两个数Mi，Mj，1<=Mi，Mj<=N，表示Mi和Mj具有亲戚关系。
接下来p行：每行两个数Pi，Pj，询问Pi和Pj是否具有亲戚关系。
输出格式
P行，每行一个’Yes’或’No’。表示第i个询问的答案为“具有”或“不具有”亲戚关系。

 */
public class UnionFindSets {
    int[] par; // 假如有编号为1, 2, 3, ..., n的n个元素，用数组par[]存储元素的父节点，每个元素有且只有一个父节点

    public static void main(String[] args) {
        // 家族题解
        int n, m, p, x, y;
        Scanner s = new Scanner(new BufferedInputStream(System.in));
        n = s.nextInt();
        m = s.nextInt();
        p = s.nextInt();
        UnionFindSets unionFindSets = new UnionFindSets(n);
        for (int i = 0; i < m; i++) {
            x = s.nextInt();
            y = s.nextInt();
            unionFindSets.merge(x, y);
        }
        for (int i = 0; i < p; ++i) {
            x = s.nextInt();
            y = s.nextInt();
            System.out.println(unionFindSets.find(x) == unionFindSets.find(y) ? "yes" : "no");
        }

    }

    public UnionFindSets(int n) {
        par = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            par[i] = i;
        }
    }

    // 查找树的根：一层一层访问父节点，直至根节点(找出祖宗)
    public int find(int x) {
        // 压缩路径 par[x] = find(par[x]) 查询过程中，把沿途的每个节点的父节点都设为根节点
        return par[x] == x ? x : (par[x] = find(par[x]));
    }

    public void merge(int i, int j) {
        // 先找到两个集合的代表元素，然后将前者的父节点设为后者
        par[find(i)] = find(j);
    }
}

/**
 * 进一下优化，按秩压缩
 */
class UnionFindSets2 {
    int[] par; // 存储父节点
    int[] rank; // 存放秩

    public UnionFindSets2(int n) {
        this.par = new int[n + 1];
        this.rank = new int[n+1];
        for (int i = 1; i <= n; i++) {
            par[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        return par[x] == x ? x : (par[x] = find(par[x]));
    }

    public void merge(int i, int j) {
        int x = find(i);
        int y = find(j);
        if (rank[x] <= rank[y]) {
            par[x] = y;
        } else {
            par[y] = x;
        }
        if (rank[x] == rank[y] && x != y) {
            // 秩相同时，被合上根节点的秩+1
            rank[y]++;
        }
    }

}