package bob.shortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class dijkstraDemo {
    private static List<edge> result; // 存储最短路径
    private static int MAXLEN = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' }; // 邻接矩阵
        int[][] matrix = new int[vertex.length][vertex.length];
        result = new ArrayList<>();
        matrix[0] = new int[] { MAXLEN, 5, 7, MAXLEN, MAXLEN, MAXLEN, 2 };
        matrix[1] = new int[] { 5, MAXLEN, MAXLEN, 9, MAXLEN, MAXLEN, 3 };
        matrix[2] = new int[] { 7, MAXLEN, MAXLEN, MAXLEN, 8, MAXLEN, MAXLEN };
        matrix[3] = new int[] { MAXLEN, 9, MAXLEN, MAXLEN, MAXLEN, 4, MAXLEN };
        matrix[4] = new int[] { MAXLEN, MAXLEN, 8, MAXLEN, MAXLEN, 5, 4 };
        matrix[5] = new int[] { MAXLEN, MAXLEN, MAXLEN, 4, 5, MAXLEN, 6 };
        matrix[6] = new int[] { 2, 3, MAXLEN, MAXLEN, 4, 6, MAXLEN };

        DijGraph DijGraph = new DijGraph(vertex, matrix);
        DijGraph.show();

    }

    // 起点终点
    public int dijkstra(int start, int end, DijGraph dijGraph) {
        int nodeNum = dijGraph.getNodeNum();
        dijGraph.visit(start,0);
        int minPath;
        // 贪心框架
        while(!dijGraph.isVisited(end)){
            minPath = MAXLEN;
            for(int i = 0; i <= nodeNum; i++ ){
                if()
            }
        }
        return 0;
    }
}

class DijGraph {
    private int nodeNum;
    private char[] vertex;
    private int[][] matrix;
    private int[] pathLen; // 被访问过的节点
    private List<edge> shortestList;

    public boolean isVisited(int i){
        return this.pathLen[i] < Integer.MAX_VALUE;
    }
    public void visit(int i,int len){
        this.pathLen[i] = len;
    }
    public int getNodeNum(){
        return this.nodeNum;
    }

    public DijGraph(char[] vertex, int[][] matrix) {
        nodeNum = vertex.length;
        this.pathLen = new int[nodeNum];
        this.vertex = new char[nodeNum];
        this.vertex = Arrays.copyOf(vertex, nodeNum);
        this.matrix = new int[nodeNum][nodeNum];
        shortestList = new ArrayList<>();
        for (int i = 0; i < nodeNum; i++) {
            this.matrix[i] = Arrays.copyOf(matrix[i], nodeNum);
            this.pathLen[i] = Integer.MAX_VALUE;
        }
    }

    public void show() {
        System.out.println(Arrays.toString(vertex));
        for (int i = 0; i < nodeNum; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

}

class edge {
    int start;
    int end;
    int length;

    public edge(int start, int end, int length) {
        this.start = start;
        this.end = end;
        this.length = length;
    }
}
