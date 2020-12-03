package bob.HuffmanTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {

    // ǰ�����
    public void preOrder(Node root) {
        System.out.println(this);
    }



    public static Node createHuffmanTree(int[] arr){
        // ����ת����
        List<Node> nodes = new ArrayList<>();
        for(int value:arr){
            nodes.add(new Node(value));
        }

        while (nodes.size()>1){
            // ��С��������
            Collections.sort(nodes);
            // ȡ����С��2���ڵ�
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            // ����һ�����ڵ㣬value���ӽڵ��
            Node parent = new Node(leftNode.value+rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;

            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }
        return nodes.get(0);
    }



    public static void main(String[] args) {
        int arr[] = { 13, 7, 8, 3, 29, 6, 1 };
        Node root =createHuffmanTree(arr);
        root.preOrder();

    }

}


// �����ڵ㣬 ʵ��Comparable�ӿ�ʵ������
class Node implements Comparable<Node> {
    int value;  // ���Ȩֵ
    Node left;
    Node right;

    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        // ��ʾ��С��������
        return this.value - o.value;
    }
}
