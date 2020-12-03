package bob.linkedlist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {

    }
}

// ˫�����������
class DoubleLinkdeList {

    // ����һ��ͷ�ڵ㣬ͷ�ڵ㲻�������
    private DoubleLinkedNode head = new DoubleLinkedNode(0, "", "");

    public DoubleLinkedNode getHead() {
        return this.head;
    }

    // ��ʾ����[����]  �͵�������һ��
    public void list() {
        if (this.head == null) {
            System.out.println("����Ϊ��");
            return;
        }
        // ��Ϊͷ�ڵ㲻���ƶ�����Ҫһ�������ڵ�������
        DoubleLinkedNode temp = head.next;
        while (true) {
            if (temp.next == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }


    // ���һ���ڵ㵽�������   �͵�������������
    public void add(DoubleLinkedNode node) {
        // ͷ�ڵ㲻���ƶ�����Ҫ�����ڵ�����������
        DoubleLinkedNode temp = this.head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }

        // ��Ԫ��ĩβ���
        temp.next = node;
        node.pre = temp;
    }

    // ���½ڵ�    �� ��������ȫһ��
    public void update(DoubleLinkedNode node) {
        if (this.head.next == null) {
            System.out.println("����Ϊ�գ�");
            return;
        }

        // ͷ�ڵ㲻���ƶ��������ڵ���������
        DoubleLinkedNode temp = head.next;
        // �Ƿ��ҵ���־
        boolean flag = false;
        while (true) {
            // �����꣬����
            if (temp == null) {
                break;
            }
            // �ҵ��ڵ�
            if (temp.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = node.name;
            temp.value = node.value;
        } else {
            System.out.printf("û���ҵ� ��� %d �Ľڵ㣡", node.no);
        }
    }


    // ɾ�����Ϊno�Ľڵ�  �͵�����ͬ��������ɾ��
    public void del(int no){
        if(this.head == null){
            System.out.println("����Ϊ�գ�");
            return;
        }
        // ͷ�ڵ㲻���ƶ��������ڵ���������
        DoubleLinkedNode temp = head.next;
        // �Ƿ��ҵ���־
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            // �ҵ�Ҫɾ���ڵ�
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag){
            temp.pre.next = temp.next;
            // �����ɾ���ڵ������һ���ڵ㣬����Ҫָ��ǰһ���ڵ㣬������ָ�롣
            if(temp.next != null){
                temp.next.pre = temp.pre;
            }
        }else {
            System.out.println("δ�ҵ���Ҫɾ���Ľڵ㣡");
        }

    }


}


// ����˫������ �ڵ�
class DoubleLinkedNode {

    public int no;
    public String name;
    public String value;
    public DoubleLinkedNode pre;
    public DoubleLinkedNode next;

    public DoubleLinkedNode(int no, String name, String value) {
        this.no = no;
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "DoubleLinkedNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", pre=" + pre +
                ", next=" + next +
                '}';
    }
}
