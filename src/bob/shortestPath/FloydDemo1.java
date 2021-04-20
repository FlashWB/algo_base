package bob.shortestPath;

import java.util.Arrays;

/* 
Floyd算法是一种动态规划算法，稠密图效果最佳，边权可正可负。此算法简单有效，由于三重循环结构紧凑，对于稠密图，效率要高于执行|V|次Dijkstra算法。

弗洛伊德算法 VS 迪杰斯特拉算法:迪杰斯特拉算法通过选定的被访问顶点，求出从出发访问顶点到其他顶点
的最短路径;弗洛伊德算法中每一个顶点都是出发访问点，所以需要将每一个顶点看做被访问顶点，求出从每 一个顶点到其他顶点的最短路径。

1) 设置顶点vi到顶点vk的最短路径已知为Lik，顶点vk到vj的最短路径已知为Lkj，顶点vi到vj的路径为Lij， 则 vi 到 vj 的最短路径为:min((Lik+Lkj),Lij)，vk 的取值为图中所有顶点，则可获得 vi 到 vj 的最短路径
2) 至于vi到vk的最短路径Lik或者vk到vj的最短路径Lkj，是以同样的方式获得


*/
public class FloydDemo1 {
    public static void main(String[] args) {
        // 测试看看图是否创建成功
        char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' }; // 创建邻接矩阵
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = Integer.MAX_VALUE;
        matrix[0] = new int[] { 0, 5, 7, N, N, N, 2 };
        matrix[1] = new int[] { 5, 0, N, 9, N, N, 3 };
        matrix[2] = new int[] { 7, N, 0, N, 8, N, N };
        matrix[3] = new int[] { N, 9, N, 0, N, 4, N };
        matrix[4] = new int[] { N, N, 8, N, 0, 5, 4 };
        matrix[5] = new int[] { N, N, N, 4, 5, 0, 6 };
        matrix[6] = new int[] { 2, 3, N, N, 4, 6, 0 };

        FloydAlg f = new FloydAlg(vertex, matrix);
        f.floyd();
        f.show();
    }

}

class FloydAlg {
    int length;
    char[] vertex;
    int[][] dis; // 顶点到其他点的距离
    int[][] pre; // 前驱节点

    public FloydAlg(char[] vertex, int[][] matrix) {
        this.dis = matrix;
        this.vertex = vertex;
        this.length = vertex.length;
        pre = new int[length][length];
        for (int i = 0; i < length; i++) {
            Arrays.fill(pre[i], i);
        }
    }

    public void floyd() {
        int len = 0;
        for (int k = 0; k < length; k++) {
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    len = dis[i][k] + dis[k][j];
                    if (len < dis[i][j]) {
                        dis[i][j] = len;
                        pre[i][j] = pre[k][j];
                    }

                }
            }
        }
    }

    public void show() {
        for (int k = 0; k < dis.length; k++) {
            // 先将 pre 数组输出的一行
            for (int i = 0; i < dis.length; i++) {
                System.out.print(vertex[pre[k][i]] + " ");
            }
            System.out.println();
            // 输出 dis 数组的一行数据
            for (int i = 0; i < dis.length; i++) {
                System.out.print("(" + vertex[k] + "到" + vertex[i] + "的最短路径是" + dis[k][i] + ") ");
            }
            System.out.println();
            System.out.println();
        }
    }

}
