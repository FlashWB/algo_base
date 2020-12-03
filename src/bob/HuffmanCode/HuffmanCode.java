package bob.HuffmanCode;

import java.util.*;
import java.util.stream.Collectors;

public class HuffmanCode {
    public static void main(String[] args) {
        String text = "i like like like java do you like a java";
        byte[] textBytes = text.getBytes();

        List<Node> nodes = getNodes(textBytes);

        Node root = createHuffmanTree(nodes);
        System.out.println("huffman�����������");
        root.preOrder();

        getHuffmanCodes(root, new StringBuilder());
        System.out.println("huffman���ֵ��");
        System.out.println(huffmanCodes);


    }


    private static Node createHuffmanTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            Node left = nodes.get(0);
            Node right = nodes.get(1);
            Node parent = new Node(null, left.weight + right.weight);
            parent.left = left;
            parent.right = right;

            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    private static List<Node> getNodes(byte[] bytes) {
        Map<Byte, Integer> byteCountMap = new HashMap<Byte, Integer>();

        for (byte item : bytes) {
            Integer count = byteCountMap.get(item);
            if (count == null) {
                byteCountMap.put(item, 1);
            } else {
                byteCountMap.put(item, count + 1);
            }
        }
        return byteCountMap.entrySet().stream()
                .map(e -> new Node(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    static Map<Byte, String> huffmanCodes = new HashMap<>();

    private static void getHuffmanCodes(Node node, StringBuilder stringBuilder) {
        if (node != null) {
            if (node.data == null) {
                getHuffmanCodes(node.left, new StringBuilder(stringBuilder).append("0"));  
                getHuffmanCodes(node.right, new StringBuilder(stringBuilder).append("1"));
            } else {
                huffmanCodes.put(node.data, stringBuilder.toString());
            }
        }
    }


    private static byte[] zip(byte[] bytes, Map<Byte,String> huffmanCodes){
        StringBuilder stringBuilder = new StringBuilder();
        for(byte b: bytes){
            stringBuilder.append(huffmanCodes.get(b));
        }
        int len;
        if(stringBuilder.length()%8==0){
            len = stringBuilder.length()/8;
        }else {
            len = stringBuilder.length()/8+1;
        }
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;
        for(int i =0; i<stringBuilder.length();i+=8){
            String strByte;
            if(i+8 > stringBuilder.length()){
                strByte = stringBuilder.substring(i);
            }else {
                strByte = stringBuilder.substring(i,i+8);
            }
            huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte,2);
            index++;
        }
        return huffmanCodeBytes;
    }

}


class Node implements Comparable<Node> {
    Byte data;
    int weight;
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }


    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}
