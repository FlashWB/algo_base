package bob.tree.ThreadedBinaryTree;


public class ThreadedBinaryTreeDemo {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, "tom");
        TreeNode node2 = new TreeNode(3, "jack");
        TreeNode node3 = new TreeNode(6, "smith");
        TreeNode node4 = new TreeNode(8, "mary");
        TreeNode node5 = new TreeNode(10, "king");
        TreeNode node6 = new TreeNode(14, "dim");

        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        ThreadedBinaryTree tree = new ThreadedBinaryTree(root);
        tree.threadedNodes();
        tree.threadedList();

    }

}


class ThreadedBinaryTree {
    private TreeNode root;

    //Ϊ��ʵ������������Ҫ����Ҫ��ָ��ǰ����ǰ������ָ��
    //�ڵݹ����������ʱ��pre ���Ǳ���ǰһ�����
    private TreeNode pre = null;

    public ThreadedBinaryTree() {
    }

    public ThreadedBinaryTree(TreeNode root) {
        this.root = root;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }


    // ��������������
    // һֱ����ָ�뷽�����
    public void threadedList() {
        //����һ���������洢��ǰ�����Ľ�㣬��root��ʼ
        TreeNode node = root;
        while (node != null) {
            //ѭ�����ҵ�leftType == 1�Ľ�㣬��һ���ҵ�����8���
            //�������ű������仯,��Ϊ��leftType==1ʱ��˵���ý���ǰ���������
            //��������Ч���
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }

            //��ӡ��ǰ������
            System.out.println(node);
            //�����ǰ������ָ��ָ����Ǻ�̽��,��һֱ���
            while (node.getRightType() == 1) {
                //��ȡ����ǰ���ĺ�̽��
                node = node.getRight();
                System.out.println(node);
            }
            //�滻��������Ľ��
            node = node.getRight();

        }
    }


    public void threadedNodes() {
        this.threadedNodes(root);
    }

    // ������ ����������
    public void threadedNodes(TreeNode node) {
        // �ݹ���ڣ����node==null������������
        if (node == null) {
            return;
        }
        // ��������������
        threadedNodes(node.getLeft());
        // ��������ǰ���
        // �����ָ��Ϊ�գ�ָ��ǰ�����
        // ��ʼpreָ��Ϊ�գ��������������
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        // ��ӡ��ǰ���
//        System.out.println(node);
        // ���ǰ��������ָ��Ϊ�գ�ָ��ǰ���
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        //ÿ����һ�������õ�ǰ�������һ������ǰ�����
        pre = node;
        threadedNodes(node.getRight());
    }


    // ɾ�������
    public void delNode(int n) {
        if (root != null) {
            if (root.getNo() == n) {
                root = null;
            } else {
                root.deleteNode(n);
            }
        } else {
            System.out.println("������Ϊ�գ�����ɾ��");
        }
    }


    // ǰ�����
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("������Ϊ�գ����ܱ���!");
        }
    }

    // �������
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("������Ϊ�գ����ܱ�����");
        }
    }


    // �������
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("������Ϊ�գ����ܱ�����");
        }
    }

    /**
     * ��������
     */
    public TreeNode preOrderSearch(int no) {
        if (this.root != null) {
            return this.root.preOrderSearch(no);
        } else {
            return null;
        }
    }

    public TreeNode infixOrderSearch(int no) {
        if (this.root != null) {
            return this.root.infixOrderSearch(no);
        } else {
            return null;
        }
    }

    public TreeNode postOrderSearch(int no) {
        if (this.root != null) {
            return this.root.postOrderSearch(no);
        } else {
            return null;
        }
    }
}

class TreeNode {
    private int no;
    private String name;
    private TreeNode left;  //  Ĭ��Ϊnull
    private TreeNode right;
    // type==0������;type ==1ǰ�����
    private int leftType;
    private int rightType;

    public TreeNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
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
     * �ݹ�ɾ���ڵ�
     *
     * @param
     * @return
     */
    public void deleteNode(int no) {
        if (this.getLeft() != null && this.getLeft().getNo() == no) {
            this.setLeft(null);
            return;
        }
        if (this.getRight() != null && this.getRight().getNo() == no) {
            this.setRight(null);
            return;
        }
        if (this.getLeft() != null) {
            deleteNode(this.getLeft().getNo());
        }
        if (this.getRight() != null) {
            deleteNode(this.getRight().getNo());
        }
    }


    // �������
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    // �������
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    // �������
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    /**
     * ��������
     */
    //ǰ���������
    public TreeNode preOrderSearch(int no) {
        System.out.println("����ǰ�����");
        if (this.no == no) {
            return this;
        }
        TreeNode resNode = null;
        // �ݹ��ѯ��������
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        // ����ҵ��򷵻ؽڵ�
        if (resNode != null) {
            return resNode;
        }
        // �ݹ��ѯ������
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        // ���۲�û�鵽������
        return resNode;
    }


    // �������
    public TreeNode infixOrderSearch(int no) {
        TreeNode resNode = null;
        if (this.left != null) {
            resNode = this.infixOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        System.out.println("�����������");
        if (this.no == no) {
            return this;
        }
        if (this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }


    // �������
    public TreeNode postOrderSearch(int no) {
        TreeNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        System.out.println("����������");
        if (this.no == no) {
            return this;
        }
        return resNode;
    }
}
