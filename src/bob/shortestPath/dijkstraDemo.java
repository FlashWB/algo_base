package bob.shortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.text.html.MinimalHTMLWriter;

/* 
https://my.oschina.net/u/4678692/blog/4654834  

指定起点s(即从顶点s开始计算)
两个集合S和U。S的作用是记录已求出最短路径的顶点(以及相应的最短路径长度)，
而U则是记录还未求出最短路径的顶点(以及该顶点到起点s的距离)。 
1. 初始时，S只包含起点s；U包含除s外的其他顶点，且U中顶点的距离为”起点s到该顶点的距离”
[例如，U中顶点v的距离为(s,v)的长度，然后s和v不相邻，则v的距离为∞]。
2. 从U中选出”距离最短的顶点k”，并将顶点k加入到S中；同时，从U中移除顶点k。
3. 更新U中各个顶点到起点s的距离。之所以更新U中顶点的距离，是由于上一步中确定了k是求出最短路径的顶点，从而可以利用k来更新其它顶点的距离；
例如，(s,v)的距离可能大于(s,k)+(k,v)的距离。
重复步骤(2)和(3)，直到遍历完所有顶点。

问题：求起点到所有点的最短路径；求两点之间最短路径



*/
public class dijkstraDemo {
    private static int MAXLEN = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' }; // 邻接矩阵
        int[][] matrix = new int[vertex.length][vertex.length];
        matrix[0] = new int[] { MAXLEN, 5, 7, MAXLEN, MAXLEN, MAXLEN, 2 };
        matrix[1] = new int[] { 5, MAXLEN, MAXLEN, 9, MAXLEN, MAXLEN, 3 };
        matrix[2] = new int[] { 7, MAXLEN, MAXLEN, MAXLEN, 8, MAXLEN, MAXLEN };
        matrix[3] = new int[] { MAXLEN, 9, MAXLEN, MAXLEN, MAXLEN, 4, MAXLEN };
        matrix[4] = new int[] { MAXLEN, MAXLEN, 8, MAXLEN, MAXLEN, 5, 4 };
        matrix[5] = new int[] { MAXLEN, MAXLEN, MAXLEN, 4, 5, MAXLEN, 6 };
        matrix[6] = new int[] { 2, 3, MAXLEN, MAXLEN, 4, 6, MAXLEN };

        System.out.println(Arrays.toString(vertex));
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

        VisitedVertex visitedVertex = new VisitedVertex(vertex, matrix);
        visitedVertex.dijkstra(2);

        System.out.println("最短路径：");
        System.out.println(Arrays.toString(visitedVertex.dis));

    }

}

class VisitedVertex {

    int[] alreadyArr; // 每次选出的最短路径节点
    int[] preVisited; // 记录每个节点前驱节点
    int[] dis; // 到各个顶点的最短路径
    int[][] graph;
    char[] vertex;
    int size;

    public VisitedVertex(char[] vertex, int[][] matrix) {
        size = vertex.length;
        alreadyArr = new int[size]; // 每次选出的最短路径节点
        preVisited = new int[size]; // 记录每个节点前驱节点
        dis = new int[size]; // 到各个顶点的最短路径
        for (int i = 0; i < size; i++) {
            dis[i] = Integer.MAX_VALUE;
        }
        graph = matrix;
        this.vertex = vertex;
    }

    /**
     * 从index点出发，到其他点距离最小
     * 
     * @param index
     */
    public void dijkstra(int index) {
        dis[index] = 0;
        alreadyArr[index] = 1;
        // updatePreDis(index); // 更新出发点的距离和前驱顶点
        for (int i = 1; i < size; i++) {
            // index = updateVisited(index);
          index =  updatePreDis(index);
        }

    }

    /**
     * 更新index顶点到周围顶点的距离dis和前驱节点preVisited
     * 
     * @param index
     */
    public int updatePreDis(int index) {
        int len = Integer.MAX_VALUE; // 记录出发点
        int minLen = Integer.MAX_VALUE; // 记录最小路径
        int minLenIndex = index; // 记录最小路径的终点
        alreadyArr[index] = 1;
        for (int i = 0; i < graph[index].length; i++) {
            if (graph[index][i] == Integer.MAX_VALUE || alreadyArr[i] == 1) {
                continue;
            }
            len = dis[index] + graph[index][i];
            if (len < dis[i]) {
                preVisited[i] = index; // 更新i顶点前驱节点
                dis[i] = len; // 更新i节点，从起点到终点的距离
            }
            if(len<minLen){
                minLen = len;
                minLenIndex = i;
            }
        }
        return minLenIndex;
    }

    /**
     * 从访问过的节点中，选出最短路径，并标识
     * 
     * @param index
     */
    public int updateVisited(int index) {
        int minDis = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < size; i++) {
            if (alreadyArr[i] == 0 && dis[i] < minDis) {
                minDis = dis[i];
                minIndex = i;
            }
        }
        // 选出最短路径并标识
        alreadyArr[minIndex] = 1;
        return minIndex;
    }

    public void showShortDis(int start, int end) {
    }

}
