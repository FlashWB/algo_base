package bob.hash;


public class HashTabDemo {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);

        hashTab.put(2,1);
        hashTab.put(3,6);
        hashTab.put(4,2);
        hashTab.put(1,1);
        hashTab.put(11,3);
        hashTab.put(8,9);
        hashTab.put(8,11);

        hashTab.list();

       Ele ele = hashTab.findByKey(8);
        System.out.println(ele.value);

    }
}


// ����HashTab�������������
class HashTab {

    // �洢Ͱ(����)������
    private HashLinkedList[] linkedListsArray;
    // hash��Ͱ������
    private int size;

    // ���캯��
    public HashTab(int size) {
        this.size = size;
        // ��ʼ��Ͱ����
        linkedListsArray = new HashLinkedList[size];
    }

    // ���Ԫ��
    public void put(int key, int value) {
        Ele ele = new Ele(key,value);
        int hashNo = hashFunc(ele.key);
        // ���ͰΪ�գ���ʼ��Ͱ
        if(linkedListsArray[hashNo]==null){
            linkedListsArray[hashNo] = new HashLinkedList();
        }
        linkedListsArray[hashNo].add(ele);
    }

    // ��������Ԫ��
    public void list() {
        for(int i=0; i<size; i++){
            if(linkedListsArray[i]!=null){

                linkedListsArray[i].list();
            }
        }
    }

    // ���ݼ���ȡֵ
    public Ele findByKey(int key) {
        int hashNo = hashFunc(key);
        return linkedListsArray[hashNo].findByKey(key);
    }

    // ��дɢ�к�����ʹ�ü�ȡģ��
    public int hashFunc(int key) {
        return key % size;
    }


}


class Ele {
    public int key;
    public int value;
    public Ele next;

    public Ele(int key, int value) {
        super();
        this.key = key;
        this.value = value;
    }
}

// Ͱ -- ����Ͱ��������
class HashLinkedList {

    // ͷָ��,ָ���һ��Ele��Ĭ��null
    private Ele head;

    // �������Ԫ��
    public void add(Ele ele) {
        // ��ӵ�һ��Ԫ��
        if(head == null){
            head = ele;
            return;
        }
        // ʹ�ø���ָ���ҵ���β,����β�����ele
        Ele curEle = head;
        while (curEle.next!=null){
            curEle = curEle.next;
        }
        curEle.next = ele;

    }

    // ��������
    public void list() {
        if(head == null){
            System.out.println("����Ϊ��");
            return;
        }
        // ���ø���ָ���������
        Ele curEle = head;
        while (curEle!=null){
            System.out.printf(" < %d: %d> ",curEle.key,curEle.value);
            curEle = curEle.next;
        }
    }

    // ����key����Ԫ��
    public Ele findByKey(int key) {
        if(head == null){
            System.out.println("����Ϊ��");
            return null;
        }

        // ���ø���ָ���������
        Ele curEle = head;
        while (curEle!=null){
            if(curEle.key == key){
                return curEle;
            }
            curEle = curEle.next;
        }
        return null;
    }

}




