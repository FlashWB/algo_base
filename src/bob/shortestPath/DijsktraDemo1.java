package bob.shortestPath;

import java.util.Arrays;

public class DijsktraDemo1 {
    public static void main(String[] args) {
        int MAXLEN = Integer.MAX_VALUE;
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

        Dijkstra dij = new Dijkstra(matrix, vertex);
        dij.dijkstraAlph(2);
        System.out.println(Arrays.toString(dij.dis));
        System.out.println(Arrays.toString(dij.preVisitedVertex));
        dij.showPath(2, 3);

    }

}

class Dijkstra {

    int size;
    char[] vertex;
    int[][] graph;
    int[] dis; // 到顶点i的最小距离
    int[] selectedVertex; // 每次遍历被访问出的最小路径终点
    int[] preVisitedVertex; // 前驱节点，用于记录路径

    public Dijkstra(int[][] graph, char[] vertex) {
        size = vertex.length;
        this.vertex = vertex;
        this.graph = graph;
        selectedVertex = new int[size];
        dis = new int[size];
        preVisitedVertex = new int[size];
        for (int i = 0; i < size; i++) {
            dis[i] = Integer.MAX_VALUE;
            preVisitedVertex[i] = Integer.MAX_VALUE;
        }
    }

    public void dijkstraAlph(int start) {
        int minLen;
        int index = start;  // 当前访问的节点
        int minLenIndex = start;  // 每次选出一条最短的路径,标记为selected
        int len; // 当前顶点到邻接顶点距离和
        dis[start] = 0;

        // 遍历除起点其他点
        for (int i = 1; i < size; i++) {
            minLen = Integer.MAX_VALUE;
            len = Integer.MAX_VALUE;
            selectedVertex[index] = 1;
            index = minLenIndex;
            // dijkstra
            for (int j = 0; j < graph[index].length; j++) {
                if (selectedVertex[j] == 1 || graph[index][j] == Integer.MAX_VALUE) {
                    continue;
                }
                len = dis[index] + graph[index][j];
                if (len < dis[j]) { // 如果路径小于起点到该点路径长度，更新，同时更新前驱节点
                    preVisitedVertex[j] = index;
                    dis[j] = len;
                }
                if (dis[j] < minLen) {
                    minLen = dis[j];
                    minLenIndex = j;
                }
            }
        }
    }

    public void showPath(int start, int end){
        int index = end;
        int[] arr = new int[size];
        int i = 0;
        while(index!=start){
            arr[i++] = index;
            index = preVisitedVertex[index];
        }
        arr[i] = start;
        for(int j = 0;j <=i;j++){
            System.out.print(arr[i-j] + " ");
        }
    }


}
