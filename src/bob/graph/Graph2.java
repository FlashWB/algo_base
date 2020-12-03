package bob.graph;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Graph2 {

    // �洢����
    private ArrayList<String> vertexList;
    // �洢��Ӧ��������
    private int[][] edges;
    private boolean[] isvisited;
    private int numOfEdges;

    public static void main(String[] args) {
        Graph2 graph2 = new Graph2(8);
        String Vertexs[] = {"1", "2", "3", "4", "5", "6", "7", "8"};
        for(String i : Vertexs){
            graph2.insertVertex(i);
        }
        //���±ߵĹ�ϵ
        graph2.insertEdge(0, 1, 1);
        graph2.insertEdge(0, 2, 1);
        graph2.insertEdge(1, 3, 1);
        graph2.insertEdge(1, 4, 1);
        graph2.insertEdge(3, 7, 1);
        graph2.insertEdge(4, 7, 1);
        graph2.insertEdge(2, 5, 1);
        graph2.insertEdge(2, 6, 1);
        graph2.insertEdge(5, 6, 1);
        graph2.showGraph();

        System.out.println("������ȱ�����");
        graph2.dfs();

    }

    //-------------------------------------------------
    // ������ȱ���
    private void dfs(){
        isvisited = new boolean[vertexList.size()];
        for(int i = 0;i<vertexList.size();i++){
            if(!isvisited[i]){
                dfs(isvisited,i);
            }
        }
        System.out.println();
    }
    private void dfs(boolean[] isvisited, int i){
        System.out.print(getValueByIndex(i)+" ");
        isvisited[i] = true;
        int neighbor = getNextNeighbor(i,0);
        while (neighbor!=-1){
            if(!isvisited[neighbor]){
                dfs(isvisited,neighbor);
            }
            neighbor = getNextNeighbor(i,neighbor+1);
        }
    }


    private void bfs(){
        isvisited = new boolean[vertexList.size()];
        for(int i = 0; i<vertexList.size();i++){
            if(!isvisited[i]){
                bfs(isvisited,i);
            }
        }
        System.out.println();
    }

    private void bfs(boolean[] isvisited, int i){
//        System.out.printf(getValueByIndex(i)+" ");
//        isvisited[i] = true;
//        LinkedList<Integer> queue = new LinkedList<Integer>();
//        int neighbor = getNextNeighbor(i,0);
//        while (!queue.isEmpty()){
//            if(!isvisited[queue.]){
//                System.out.printf(getValueByIndex(neighbor)+" ");
//                queue.add(neighbor);
//            }
//        }


    }
    // ��ȡ��һ���ڵ�
    public int getNextNeighbor(int v1, int v2){
        for(int j = v2; j < vertexList.size();j++){
            if(edges[v1][j]>0){
                return j;
            }
        }
        return -1;
    }







    // -------------------------------------------------
    // ����Ϊ��������
    public Graph2(int n) {
        edges = new int[n][n];
        isvisited = new boolean[n];
        vertexList = new ArrayList<String>(n);
    }

    // vertextList�����б�  ���Ӷ���
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }


    // ���ӱ�
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    // ���ض�Ӧ�Ǳ�ֵ
    public String getValueByIndex(int index) {
        return vertexList.get(index);
    }

    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    public void showGraph() {
        for (int[] i : edges) {
            System.out.println(Arrays.toString(i));
        }
    }

}
