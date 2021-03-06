package bob.tree;

public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};

        ArrBinaryTree tree = new ArrBinaryTree(arr);
        tree.infixOrder();

    }
}

class ArrBinaryTree{
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder(){
        preOrder(0);
    }


    public void preOrder(int n){
        if(arr==null || arr.length==0){
            System.out.println("����Ϊ�գ����ܱ�����");
        }
        System.out.println(arr[n]);
        if(n*2+1<arr.length){
            preOrder(n*2+1);
        }
        if(n*2+2<arr.length){
            preOrder(n*2+2);
        }
    }

    public void infixOrder(){
        infixOrder(0);
    }
    public  void infixOrder(int n){
        if(arr==null || arr.length==0){
            System.out.println("����Ϊ�գ����ܱ�����");
        }
        if(n*2+1<arr.length){
            infixOrder(n*2+1);
        }
        System.out.println(arr[n]);
        if(n*2+2<arr.length){
            infixOrder(n*2+2);
        }
    }

}
