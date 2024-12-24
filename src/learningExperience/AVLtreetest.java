package learningExperience;

import java.util.Scanner;

public class AVLtreetest {
    public static void main(String[] args) {
        // 写一些程序利用 Scanner 根据输入测试 AVL 树
        Scanner in = new Scanner(System.in);
        AVLTree tree = new AVLTree();

        System.out.println("输入操作数量：");
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("选择操作: 1. 插入 2. 删除 3. 查找 4. 打印");
            int operation = in.nextInt();

            switch (operation) {
                case 1:
                    System.out.println("输入要插入的值:");
                    int insertValue = in.nextInt();
                    tree.insert(insertValue);
                    break;
                case 2:
                    System.out.println("输入要删除的值:");
                    int deleteValue = in.nextInt();
                    tree.delete(deleteValue);
                    break;
                case 3:
                    System.out.println("输入要查找的值:");
                    int searchValue = in.nextInt();
                    System.out.println("查找结果: " + tree.search(searchValue));
                    break;
                case 4:
                    System.out.println("当前中序遍历:");
                    tree.inOrder();
                    break;
                default:
                    System.out.println("无效操作");
            }
        }

        in.close();
    }
}

class AVLTree {
     class Node {
        int key, height;
        Node left, right;

        Node(int key) {
            this.key = key;
            this.height = 1; // 初始高度为 1
        }
    }

    private Node root;

    // 获取节点高度
    private int height(Node node) {
        return node == null ? 0 : node.height;
    }

    // 计算平衡因子
    private int getBalance(Node node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    // 右旋操作
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // 执行旋转
        x.right = y;
        y.left = T2;

        // 更新高度
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x; // 新根节点
    }

    // 左旋操作
    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // 执行旋转
        y.left = x;
        x.right = T2;

        // 更新高度
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y; // 新根节点
    }

    // 插入节点
    public void insert(int key) {
        root = insertNode(root, key);
    }

    private Node insertNode(Node node, int key) {
        // 1. 普通二叉搜索树插入
        if (node == null)
            return new Node(key);

        if (key < node.key)
            node.left = insertNode(node.left, key);
        else if (key > node.key)
            node.right = insertNode(node.right, key);
        else
            return node; // 不允许插入重复键

        // 2. 更新高度
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        // 3. 检查平衡因子
        int balance = getBalance(node);

        // 4. 根据平衡因子选择旋转方式
        // LL
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // RR
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        // LR
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RL
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node; // 返回未失衡的节点
    }

    // 删除节点
    public void delete(int key) {
        root = deleteNode(root, key);
    }

    private Node deleteNode(Node node, int key) {
        // 1. 普通二叉搜索树删除
        if (node == null)
            return node;

        if (key < node.key)
            node.left = deleteNode(node.left, key);
        else if (key > node.key)
            node.right = deleteNode(node.right, key);
        else {
            // 找到待删除节点
            if ((node.left == null) || (node.right == null)) {
                Node temp = (node.left != null) ? node.left : node.right;
                node = temp; // 单子节点或无子节点
            } else {
                // 有两个子节点，找到中序后继
                Node temp = minValueNode(node.right);
                node.key = temp.key; // 替换值
                node.right = deleteNode(node.right, temp.key); // 删除后继节点
            }
        }

        if (node == null)
            return node;

        // 2. 更新高度
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        // 3. 检查平衡因子
        int balance = getBalance(node);

        // 4. 选择旋转方式
        // LL
        if (balance > 1 && getBalance(node.left) >= 0)
            return rightRotate(node);

        // LR
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RR
        if (balance < -1 && getBalance(node.right) <= 0)
            return leftRotate(node);

        // RL
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // 查找节点
    public boolean search(int key) {
        return searchNode(root, key);
    }

    private boolean searchNode(Node node, int key) {
        if (node == null)
            return false;

        if (key == node.key)
            return true;

        return key < node.key ? searchNode(node.left, key) : searchNode(node.right, key);
    }

    // 中序遍历（用于打印）
    public void inOrder() {
        inOrderTraversal(root);
        System.out.println();
    }

    private void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.key + " ");
            inOrderTraversal(node.right);
        }
    }

    // 获取最小值节点
    private Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }
}
