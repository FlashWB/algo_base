package bob.shortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class dijkstraDemo {
    private static int MAXLEN = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' }; // 邻接矩阵
        int[][] matrix = new int[vertex.length][vertex.length];
        List<Edge> shortestList = new ArrayList<>();
        matrix[0] = new int[] { MAXLEN, 5, 7, MAXLEN, MAXLEN, MAXLEN, 2 };
        matrix[1] = new int[] { 5, MAXLEN, MAXLEN, 9, MAXLEN, MAXLEN, 3 };
        matrix[2] = new int[] { 7, MAXLEN, MAXLEN, MAXLEN, 8, MAXLEN, MAXLEN };
        matrix[3] = new int[] { MAXLEN, 9, MAXLEN, MAXLEN, MAXLEN, 4, MAXLEN };
        matrix[4] = new int[] { MAXLEN, MAXLEN, 8, MAXLEN, MAXLEN, 5, 4 };
        matrix[5] = new int[] { MAXLEN, MAXLEN, MAXLEN, 4, 5, MAXLEN, 6 };
        matrix[6] = new int[] { 2, 3, MAXLEN, MAXLEN, 4, 6, MAXLEN };

        System.out.println(Arrays.toString(vertex));
        for(int i = 0; i<matrix.length;i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
        for(int )

    }

}

class Edge {
    int x;
    int y;
    int weight;

    public Edge(int x, int y, int weight) {
        this.x = x;
        this.y = y;
        this.weight = weight;
    }

    public String toString() {
        return "<" + this.x + "," + this.y + ">=" + this.weight;
    }
}