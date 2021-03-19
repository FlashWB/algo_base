package bob.MST;

import java.util.Arrays;

/* 
普利姆(Prim)算法求最小生成树，也就是在包含 n 个顶点的连通图中，找出只有(n-1)条边包含所有 n 个顶点的 连通子图，
也就是所谓的极小连通子图，贪心算法的应用
普利姆的算法如下:
1) 设G=(V,E)是连通网，T=(U,D)是最小生成树，V,U是顶点集合，E,D是边的集合
2) 若从顶点u开始构造最小生成树，则从集合V中取出顶点u放入集合U中，标记顶点v的visited[u]=1
3) 若集合U中顶点ui与集合V-U中的顶点vj之间存在边，则寻找这些边中权值最小的边，但不能构成回路，将
顶点 vj 加入集合 U 中，将边(ui,vj)加入集合 D 中，标记 visited[vj]=1
4) 重复步骤2，直到U与V相等，即所有顶点都被标记为访问过，此时D中有n-1条边

*/
/* 
prim 算法的最佳实践，修路问题
*/
public class PrimAlgo {
    public static void main(String[] args) {
        char[] data = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        int nodeNum = data.length;
        // 邻接矩阵的关系使用二维数组表示,10000 这个大数，表示两个点不联通
        int[][] weight = new int[][] { { 10000, 5, 7, 10000, 10000, 10000, 2 }, { 5, 10000, 10000, 9, 10000, 10000, 3 },
                { 7, 10000, 10000, 10000, 8, 10000, 10000 }, { 10000, 9, 10000, 10000, 10000, 4, 10000 },
                { 10000, 10000, 8, 10000, 10000, 5, 4 }, { 10000, 10000, 10000, 4, 5, 10000, 6 },
                { 2, 3, 10000, 10000, 4, 6, 10000 } };

        // 创建一个图对象
        MGraph mGraph = new MGraph(nodeNum);

        // 创建一个最小生成树对象
        MST mst = new MST();
        mst.createGraph(mGraph, nodeNum, data, weight);
        mst.showGraph(mGraph);
        Solution solution = new Solution();
        solution.prim(mGraph, 1);
    }

}

class MGraph {
    // 节点数
    int nodeNum;
    // 节点数据
    char[] data;
    // 边的权重
    int[][] weight;

    // 构造方法，初始化
    public MGraph(int nodeNum) {
        this.nodeNum = nodeNum;
        data = new char[nodeNum];
        weight = new int[nodeNum][nodeNum];
    }
}

class MST {
    /**
     * 
     * @param mGraph  图对象
     * @param nodeNum
     * @param data
     * @param weight
     */
    public void createGraph(MGraph mGraph, int nodeNum, char[] data, int[][] weight) {
        for (int i = 0; i < nodeNum; i++) {
            mGraph.data[i] = data[i];
            mGraph.weight[i] = Arrays.copyOf(weight[i], nodeNum);
        }
    }

    /**
     * 
     * @param mGraph
     */
    public void showGraph(MGraph mGraph) {
        for (int[] iterable_element : mGraph.weight) {
            System.out.println(Arrays.toString(iterable_element));
        }
    }
}

class Solution {
    /**
     * 
     * @param mGraph 初始化后的图
     * @param v      最先访问的节点
     */
    public void prim(MGraph mGraph, int v) {
        int[] visited = new int[mGraph.nodeNum];
        visited[v] = 1; // 第一个访问的点
        int minWeight = 10000; // 每次找出图中最小的边，要找nodeNum -1次
        // 记录最小边两个节点
        int h1 = -1;
        int h2 = -1;
        for (int k = 0; k < mGraph.nodeNum -1; k++) {
            // 下面这两个算法是prim核心，找出图中最小的边
            for (int i = 0; i < mGraph.nodeNum; i++) { // 被访问的节点
                for (int j = 0; j < mGraph.nodeNum; j++) { // 未访问的节点
                    // 替换 minWeight(寻找已经访问过的结点和未访问过的结点间的权值最小的边)
                    if (visited[i] == 1 && visited[j] == 0 && mGraph.weight[i][j] < minWeight) {
                        minWeight = mGraph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            // 输出边
            System.out.println("edge<" + mGraph.data[h1] + "," + mGraph.data[h2] + ">："+minWeight);
            // 新节点被访问
            visited[h2] = 1;
            // 最小边初始化
            minWeight = 10000; 
        }

    }
}
