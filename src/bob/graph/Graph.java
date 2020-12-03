package bob.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {

    private ArrayList<String> vertexList;  // 存储顶点集合
    private int[][] edges; // 存储对应的邻结矩阵
    private int numOfEdges; //

    private boolean[] isVisited;

    public static void main(String[] args) {
        int n = 8;  //结点的个数
        String Vertexs[] = {"1", "2", "3", "4", "5", "6", "7", "8"};

        //创建图对象
        Graph graph = new Graph(n);
        //循环的添加顶点
        for (String vertex : Vertexs) {
            graph.insertVertex(vertex);
        }


        //更新边的关系
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);

        graph.showGraph();

        //测试一把，我们的dfs遍历是否ok
        System.out.println("深度遍历");
        graph.dfs1();
        System.out.println("广度优先!");
        graph.bfs2(); // A->B->C->D-E [1->2->3->4->5->6->7->8]
    }

    //构造器
    public Graph(int n) {
        //初始化矩阵和vertexList
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;

    }

    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    public int getFirstNeighbor(int index) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    // v1就是index,获取当前访问index节点的邻接节点的下一邻接节点
    public int getNextNeighbor(int v1, int v2) {
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }


    // 获取邻接节点
    public int getNeighbor(int v1, int v2) {
        for (int i = v2; i < vertexList.size(); i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 深度优先遍历
     * 遍历所有节点，如果没有被访问，则进行深度优先遍历
     * 递归
     */
    public void dfs() {
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfsTrav1(isVisited, i);
            }
        }
    }

    /**
     * 深度
     */
    public void dfsTrav(boolean[] isVisited, int i) {
        System.out.printf(getValueByIndex(i) + "->");
        // 标记访问节点
        isVisited[i] = true;
        // 获取第一个邻接节点w
        int v2 = 0;
        while (v2 < vertexList.size()) {
            if (!isVisited[v2] && edges[i][v2] != 0) {
                dfsTrav(isVisited, v2);
            }
            v2++;
        }
    }


    public void dfsTrav1(boolean[] isVisited, int i) {
        System.out.printf(getValueByIndex(i)+ " ");
        isVisited[i]= true;
        for(int j = 0; j < vertexList.size();j++){
            if(!isVisited[j] && edges[i][j]!=0){
                dfsTrav1(isVisited,j);
            }
        }
    }


    public void dfs1(){
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i<vertexList.size();i++){
            if(!isVisited[i]){
                dfsTrav1(isVisited,i);
            }
        }
    }



    // 对一个结点进行广度优先遍历
    /**
     * 从队列首部选出一个顶点，并找出所有与之邻接的结点，将找到的邻接结点放入队列尾部
     */
    public void bfsTrav(boolean[] isVisited, int i) {
        LinkedList<Integer> queue = new LinkedList();

        System.out.printf(getValueByIndex(i) + " ");
        isVisited[i] = true;
        queue.addLast(i);

        while (!queue.isEmpty()) {
            //取出队列的头结点下标,
            int front = queue.removeFirst();

            for (int j = 0; j < vertexList.size(); j++) {
                if (!isVisited[j] && edges[front][j] != 0) {
                    System.out.printf(getValueByIndex(j) + " ");
                    isVisited[j] = true;
                    queue.addLast(j);
                }
            }

        }

    }

    // 遍历所有节点， 对所有 结点进行广度优先搜索
    public void bfs() {
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                bfsTrav(isVisited, i);
            }
        }
    }


    public void bfs2() {
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < vertexList.size(); i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                LinkedList<Integer> queue = new LinkedList<Integer>();
                queue.addLast(i);
                System.out.printf(getValueByIndex(i) + " ");

                //
                while (!queue.isEmpty()) {
                    int front = queue.removeFirst();
                    for (int j = 0; j < vertexList.size(); j++) {
                        if (edges[front][j] != 0 && !isVisited[j]) {
                            isVisited[j] = true;
                            queue.addLast(j);
                            System.out.printf(getValueByIndex(j) + " ");
                        }
                    }
                }
            }
        }
    }




    //返回结点的个数
    public int getNumOfVertex() {
        return vertexList.size();
    }

    //显示图对应的矩阵
    public void showGraph() {
        for (int[] x : edges) {
            System.out.println(Arrays.toString(x));
        }
    }

    public int getNumOfEdges() {
        return numOfEdges;
    }

    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }


}
