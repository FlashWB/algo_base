package bob.MST;

import java.util.Arrays;
import java.util.HashSet;

/*{ /* A *//* B *//* C *//* D *//* E *//* F *//* G */
/* A  { 0, 12, INF, INF, INF, 16, 14 }, 
/* B  { 12, 0, 10, INF, INF, 7, INF },
/* C  { INF, 10, 0, 3, 5, 6, INF },
 /* D  { INF, INF, 3, 0, 4, INF, INF },
/* E  { INF, INF, 5, 4, 0, 2, 8 },
 /* F { 16, 7, 6, INF, 2, 0, 9 },
/* G { 12, INF, INF, INF, 8, 9, 0 } };
Kruskal算法找出最小生成树

*/
public class KruskalDemo2 {
    public static int INF = Integer.MAX_VALUE;
    public int[] parent; // 并查集父节点
    public int[] rank; // 并查集秩
    public int edgeNum;
    public static int nodeNum;
    public static char[] nodes;
    public static int[][] matrixArr;

    public static HashSet<edge> result = new HashSet<>();  //最小生成树结果

    public static void main(String[] args) {
        char[] vertexs = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        int matrix[][] = { /* A *//* B *//* C *//* D *//* E *//* F *//* G */
                /* A */ { 0, 12, INF, INF, INF, 16, 14 }, /* B */ { 12, 0, 10, INF, INF, 7, INF },
                /* C */ { INF, 10, 0, 3, 5, 6, INF }, /* D */ { INF, INF, 3, 0, 4, INF, INF },
                /* E */ { INF, INF, 5, 4, 0, 2, 8 }, /* F */{ 16, 7, 6, INF, 2, 0, 9 },
                /* G */{ 12, INF, INF, INF, 8, 9, 0 } };

        KruskalDemo2 kd = new KruskalDemo2(vertexs, matrix);
        edge[] edges = kd.getEdges();
        System.out.println("排序前");
        System.out.println(Arrays.toString(edges));
        kd.sortEdges(edges);
        System.out.println("排序后");
        System.out.println(Arrays.toString(edges));
        kd.initUnionFindSet();
        for (edge item : edges) {
            if (kd.find(Arrays.binarySearch(vertexs, item.start)) != kd.find(Arrays.binarySearch(vertexs, item.end))) {
                kd.merge(Arrays.binarySearch(vertexs, item.start), kd.find(Arrays.binarySearch(vertexs, item.end)));
                result.add(item);
            }
        }
        for (edge item : result) {
            System.out.print("<" + item.start + "," + item.end + ">=" + item.length);
        }
    }

    public KruskalDemo2(char[] vertexs, int[][] matrix) {
        nodeNum = vertexs.length;
        edgeNum = 0;
        nodes = Arrays.copyOf(vertexs, vertexs.length);
        matrixArr = new int[nodeNum][nodeNum];
        for (int i = 0; i < nodeNum; i++) {
            for (int j = i + 1; j < nodeNum; j++) {
                if (matrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }
        for (int j = 0; j < nodeNum; j++) {
            matrixArr[j] = Arrays.copyOf(matrix[j], matrix[j].length);
        }

    }

    // 取边
    public edge[] getEdges() {
        edge[] edges = new edge[edgeNum];
        int index = 0;
        for (int i = 0; i < nodeNum; i++) {
            for (int j = i + 1; j < nodeNum; j++) {
                if (matrixArr[i][j] != INF) {
                    edge item = new edge(nodes[i], nodes[j], matrixArr[i][j]);
                    edges[index++] = item;
                }
            }
        }
        return edges;
    }

    // 冒泡
    public void sortEdges(edge[] edges) {
        for (int i = 0; i < edgeNum - 1; i++) {
            for (int j = 0; j < edgeNum - 1 - i; j++) {
                if (edges[j].compareTo(edges[j + 1]) > 0) {
                    edge tmp = edges[j + 1];
                    edges[j + 1] = edges[j];
                    edges[j] = tmp;
                }
            }
        }
    }

    // 并查集初始
    public void initUnionFindSet() {
        parent = new int[nodeNum + 1];
        rank = new int[nodeNum + 1];
        for (int i = 0; i < nodeNum + 1; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        return x == parent[x] ? x : (parent[x] = find(parent[x]));
    }

    public void merge(int i, int j) {
        if (rank[i] <= rank[j]) {
            parent[find(i)] = find(j);
        } else {
            parent[find(j)] = find(i);
        }
        if (rank[i] == rank[j]) {
            rank[j]++;
        }
    }

}

class edge implements Comparable<edge> {
    char start;
    char end;
    int length;

    edge(char start, char end, int length) {
        this.start = start;
        this.end = end;
        this.length = length;
    }

    @Override
    public int compareTo(edge o) {
        // TODO Auto-generated method stub
        return this.length - o.length;
    }

    public String toString() {
        return "<" + start + "," + end + ">=" + length;
    }
}
