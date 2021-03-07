package bob.MST;

import java.util.HashSet;

/* 
kruskal算法和prim相似，都是求最小生成树
基本思想:按照权值从小到大的顺序选择n-1条边，并保证这n-1条边不构成回路
(1)将图G看做一个森林，每个顶点为一棵独立的树 
(2)将所有的边加入集合S，即一开始S = E 
(3)从S中拿出一条最短的边(u,v)，如果(u,v)不在同一棵树内，则连接u,v合并这两棵树，同时将(u,v)加入生成树的边集E' 
(4)重复(3)直到所有点属于同一棵树，边集E'就是一棵最小生成树  

具体实现：并查集
      并查集(Union Find)是一种用于管理分组的数据结构。它具备两个操作：
      (1)查询元素a和元素b是否为同一组   
      (2) 将元素a和b合并为同一组。
注意：并查集不能将在同一组的元素拆分为两组。


如何不构成回路：加入的边的两个顶点不能都指向同一 个终点，否则将构成回路
*/
public class Kruskal {
    static int n; // 结点数
    static int m; // 路径数
    static int check[];
    static int count = 0;
    public static HashSet<node> set = new HashSet<>();// 存储已经访问过的路径信息
    public static node[] list = new node[515556];// 存储路径信息，起点，终点，路径长

    public static void main(String[] args) {

    }

    class node implements Comparable<node> {
        int start;
        int end;
        int length;

        public node(int start, int end, int length) {
            this.end = start;
            this.end = end;
            this.length = length;
        }

        @Override
        public int compareTo(node o) {
            // TODO Auto-generated method stub
            return this.length - o.length;
        }
    }

    // 并查集中的并
    public static int find(int x) {
        return check[x] == x ? x : (check[x] = find(check[x]));
    }
}
