package bob.tree.binarySortTree;

public class BinarySortTreeDemo {
    public static void main(String[] args) {

        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};

        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }

        System.out.println("中序遍历二叉树：");
        binarySortTree.infixOrder();  // 中序遍历即 升序排序

        binarySortTree.delNode(12);


        binarySortTree.delNode(5);
        binarySortTree.delNode(10);
        binarySortTree.delNode(2);
        binarySortTree.delNode(3);

        binarySortTree.delNode(9);
        binarySortTree.delNode(1);
//        binarySortTree.delNode(7);

        System.out.println("root=" + binarySortTree.getRoot());
    }

}


class BinarySortTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    // 增加节点
    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    // 中序遍历
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("二叉排序树为空！");
        }
    }

    // 查询节点的父节点
    public Node searchParent(int value) {
        if (root != null) {
            return root.searchParent(value);
        } else {
            return null;
        }
    }

    // 查找节点
    public Node search(int value) {
        if (root != null) {
            return this.root.search(value);
        } else {
            return null;
        }
    }


    /**
     * 删除根节点为node子树的最小节点
     * 返回被删除的最小节点的值
     *
     * @param
     * @return
     */
    public int delRightTreeMin(Node node) {
        Node target = node;
        while (target.left != null) {
            target = target.left;
        }
        delNode(target.value);
        return target.value;
    }


    /**
     * 1.删除叶子节点
     * 2.删除只有一棵子树的节点
     * 3.删除有2棵子树的节点
     *
     * @param
     * @return
     */
    public void delNode(int value) {
        if (root == null) {
            return;
        } else {
            Node targetNode = search(value);
            // 没找到需要删除的节点
            if (targetNode == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }

            // 查找你节点
            Node parent = searchParent(value);
            // 删除叶子节点
            if (targetNode.left == null && targetNode.right == null) {
                // 判断叶子节点是左子节点还是右节点
                if (parent.left != null && parent.left.value == value) {
                    parent.left = null;
                } else if (parent.right != null && parent.right.value == value) {
                    parent.right = null;
                } else {
                    // 叶子结点既不是左子节点也不是右子节点
                    return;
                }
            } else if (targetNode.left != null && targetNode.right != null) {
                // 删除有两个子节点的节点
                // 找到并删除目标节点 右子节点的最小值，并返回，赋给目标节点
                int minValue = delRightTreeMin(targetNode.right);
                targetNode.value = minValue;
            } else {
                // 删除只有一个子节点的树
                if (parent != null) {
                    if (targetNode.left != null) {
                        if (parent.left.value == value) {
                            parent.left = targetNode.left;
                        } else {
                            parent.right = targetNode.left;
                        }
                    } else {
                        if(parent.left.value == value){
                            parent.left = targetNode.right;
                        }else {
                            parent.right = targetNode.right;
                        }
                    }
                } else {
                    //  如果被删节点没父亲，那它就是根节点
                    if (targetNode.left != null) {
                        root = targetNode.left;
                    } else {
                        root = targetNode.right;
                    }
                }

            }


        }
    }

}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    // 中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    // 增加节点
    public void add(Node node) {
        if (node == null) {
            return;
        }
        // 递归增加节点
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }

    }


    /**
     * 查找要删除节点的父节点
     */
    public Node searchParent(int value) {
        // 找到父节点
        if ((this.left != null && this.left.value == value) ||
                (this.right != null && this.right.value == value)) {
            return this;
        } else {
            // 当前节点不是时，左右递归查找
            if (this.left != null && value < this.value) {
                return this.left.searchParent(value);
            } else if (this.right != null && value > this.value) {
                return this.right.searchParent(value);
            } else {
                return null; // 没有找到
            }
        }
    }

    /**
     * 查找要删除的节点
     *
     * @param value 需要查询的值
     * @return 如果找到，返回Node，否则返回null
     */
    public Node search(int value) {
        if (value == this.value) {
            return this;
        } else if (value < this.value) {
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }
}