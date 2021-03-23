package bob.MST;

import java.lang.reflect.Constructor;
import java.util.Arrays;
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


如何不构成回路：加入的边的两个顶点不能都指向同一 个终点(即没有相同祖宗)，否则将构成回路
*/
public class Kruskal {
    private static int n; // 结点数
    private static int m; // 路径数
    private static int parent[]; // 父节点集合，判断是否同一个根节点，是否同一个祖宗
    private char[] vertexs; // 顶点数组
    private int[][] matrix; // 邻接矩阵
    private int count = 0;

    public static final int INF = Integer.MAX_VALUE;
    public static HashSet<Edata> set = new HashSet<>();// 存储已经访问过的路径信息

    public static void main(String[] args) {
        char[] vertexs = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        int matrix[][] = { /* A *//* B *//* C *//* D *//* E *//* F *//* G */
                /* A */ { 0, 12, INF, INF, INF, 16, 14 }, /* B */ { 12, 0, 10, INF, INF, 7, INF },
                /* C */ { INF, 10, 0, 3, 5, 6, INF }, /* D */ { INF, INF, 3, 0, 4, INF, INF },
                /* E */ { INF, INF, 5, 4, 0, 2, 8 }, /* F */{ 16, 7, 6, INF, 2, 0, 9 },
                /* G */{ 12, INF, INF, INF, 8, 9, 0 } };
        Kruskal kruskal = new Kruskal(vertexs, matrix);
        kruskal.print();
        Edata[] edges = kruskal.gEdatas();
        System.out.print("排序前：");
        System.out.println(Arrays.toString(edges));
        kruskal.sortEdges(edges);
        System.out.print("排序后：");
        System.out.println(Arrays.toString(edges));

        // 并查集初始化
        parent = new int[edges.length+1];
        for (int i = 1; i < edges.length + 1; i++) {
            parent[i] = i;
        }
        for (Edata eitem : edges) {
            if(find(Arrays.binarySearch(vertexs, eitem.start))!=find(Arrays.binarySearch(vertexs, eitem.end))){
            merge(Arrays.binarySearch(vertexs, eitem.start),Arrays.binarySearch(vertexs, eitem.end) );
            set.add(eitem);
            }
        }
        // for (Edata eitem : edges) {
        //     // 如果起点和终点不能在同一棵树上，否则会闭环
        //     if(find(Arrays.binarySearch(vertexs, eitem.start))==find(Arrays.binarySearch(vertexs, eitem.start))){
        //         set.add(eitem);
        //     }
        // }
        System.out.println("最小生成树：");
        for(Edata e : set){
            System.out.print("<"+e.start+","+e.end+">="+e.length);
            // System.out.printf("<%c,%c>=%d",e.start,e.end,e.length);
        }

    }

    // 构造 器
    public Kruskal(char[] ver, int[][] mat) {
        n = ver.length;
        m = 0;
        matrix = new int[n][n];
        vertexs = new char[n];

        // 初始化顶点
        vertexs = Arrays.copyOf(ver, n);
        // 初始化边
        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays.copyOf(mat[i], n);
        }
        // 统计边的个数
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (matrix[i][j] != INF) {
                    m++;
                }
            }
        }
    }

    // 打印
    public void print() {
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public Edata[] gEdatas() {
        int index = 0;
        Edata[] edatas = new Edata[m];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (matrix[i][j] != INF) {
                    Edata edata = new Edata(vertexs[i], vertexs[j], matrix[i][j]);
                    edatas[index++] = edata;
                }
            }
        }
        return edatas;
    }

    // 冒泡排序，每轮交换比较n-1-i次
    public void sortEdges(Edata[] edges) {
        for (int i = 0; i < edges.length - 1; i++) {
            for (int j = 0; j < edges.length - i - 1; j++) {
                if (edges[j].compareTo(edges[j + 1]) > 0) {
                    Edata tmp = edges[j + 1];
                    edges[j + 1] = edges[j];
                    edges[j] = tmp;
                }
            }
        }
    }

    // 边对象
    class Edata implements Comparable<Edata> {
        char start;
        char end;
        int length;

        public Edata(char start, char end, int length) {
            this.start = start;
            this.end = end;
            this.length = length;
        }

        @Override
        public int compareTo(Edata o) {
            // TODO Auto-generated method stub
            return this.length - o.length;
        }

        public String toString() {
            return "<" + start + "," + end + ">=" + length;
        }
    }

    // 并查集中的并
    public static int find(int x) {
        return parent[x] == x ? x : (parent[x] = find(parent[x]));
    }

    public static void merge(int x, int y) {
        parent[find(x)] = find(y);
    }

}
