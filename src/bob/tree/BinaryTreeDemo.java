package bob.tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1,"宋江");
        BinaryTree binaryTree = new BinaryTree(root);

        TreeNode node2 = new TreeNode(2,"吴用");
        TreeNode node3 = new TreeNode(3,"林冲");
        TreeNode node4 = new TreeNode(4,"阮小二");
        TreeNode node5 = new TreeNode(5,"武松");

        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node3.setLeft(node5);
        System.out.println("前序遍历");
        binaryTree.preOrder();

        System.out.println("中序遍历");
        binaryTree.infixOrder();

        System.out.println("后序遍历");
        binaryTree.postOrder();

    }
}


class BinaryTree {

    private TreeNode root;

    public BinaryTree() {
    }

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    // 删除树结点
    public void delNode(int n){
        if(root!=null){
            if(root.getNo() == n){
                root = null;
            }else {
                root.deleteNode(n);
            }
        }else {
            System.out.println("二叉树为空，不能删除");
        }
    }


    // 前序遍历
    public void preOrder(){
        if(this.root!=null){
            this.root.preOrder();
        }else {
            System.out.println("二叉树为空，不能遍历!");
        }
    }

    // 中序遍历
    public void infixOrder(){
        if(this.root!=null){
            this.root.infixOrder();
        }else {
            System.out.println("二叉树为空，不能遍历！");
        }
    }


    // 后序遍历
    public void postOrder(){
        if(this.root!=null){
            this.root.postOrder();
        }else {
            System.out.println("二叉树为空，不能遍历！");
        }
    }

    /**
     * 遍历查找
     */
    public TreeNode preOrderSearch(int no){
        if(this.root!=null){
            return this.root.preOrderSearch(no);
        }
        else {
            return null;
        }
    }

    public TreeNode infixOrderSearch(int no){
        if(this.root!=null){
            return this.root.infixOrderSearch(no);
        }
        else {
            return null;
        }
    }
    public TreeNode postOrderSearch(int no){
        if(this.root!=null){
            return this.root.postOrderSearch(no);
        }
        else {
            return null;
        }
    }

}


class TreeNode {
    private int no;
    private String name;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * 递归删除节点
     *
     * @param
     * @return
     */
    public void deleteNode(int no) {
        if( this.getLeft() != null && this.getLeft().getNo()==no){
            this.setLeft(null);
            return;
        }
        if(this.getRight()!=null && this.getRight().getNo() == no){
            this.setRight(null);
            return;
        }
        if(this.getLeft()!=null){
            deleteNode(this.getLeft().getNo());
        }
        if(this.getRight()!=null){
            deleteNode(this.getRight().getNo());
        }
    }


    // 先序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    // 中序遍历
    public void infixOrder() {
        if (this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right!=null){
            this.right.infixOrder();
        }
    }

    // 后序遍历
    public void postOrder() {
        if (this.left!=null){
            this.left.postOrder();
        }
        if(this.right!=null){
            this.right.postOrder();
        }
        System.out.println(this);
    }

    /**
     * 遍历查找
     */
    //前序遍历查找
    public TreeNode preOrderSearch(int no){
        System.out.println("进入前序遍历");
        if(this.no == no){
            return this;
        }
        TreeNode resNode = null;
        // 递归查询左子树，
        if(this.left!=null){
            resNode =this.left.preOrderSearch(no);
        }
        // 如果找到则返回节点
        if(resNode!=null){
            return resNode;
        }
        // 递归查询右子树
        if(this.right!=null){
            resNode = this.right.preOrderSearch(no);
        }
        // 无论查没查到都返回
        return resNode;
    }



    // 中序遍历
    public TreeNode infixOrderSearch(int no){
        TreeNode resNode = null;
        if(this.left!=null){
            resNode = this.infixOrderSearch(no);
        }
        if(resNode!=null){
            return resNode;
        }
        System.out.println("进入中序查找");
        if(this.no == no){
            return this;
        }
        if(this.right!=null){
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }


    // 后序遍历
    public TreeNode postOrderSearch(int no){
        TreeNode resNode = null;
        if(this.left!=null){
            resNode = this.left.preOrderSearch(no);
        }
        if(resNode!=null){return resNode;}
        if(this.right!=null){
            resNode = this.right.preOrderSearch(no);
        }
        if(resNode!=null){
            return resNode;
        }
        System.out.println("进入后序遍历");
        if(this.no == no){
            return this;
        }
        return resNode;
    }
}
