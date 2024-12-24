package learningExperience;

import java.util.Scanner;

public class BSTTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BST tree = new BST();

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



class BST {
    class Node {
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    private Node root;

    // 插入节点
    public void insert(int key) {
        root = insertNode(root, key);
    }

    private Node insertNode(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }
        if (key < node.key) {
            node.left = insertNode(node.left, key);
        } else if (key > node.key) {
            node.right = insertNode(node.right, key);
        }
        return node;
    }

    // 删除节点
    public void delete(int key) {
        root = deleteNode(root, key);
    }

    private Node deleteNode(Node node, int key) {
        if (node == null) {
            return null;
        }

        if (key < node.key) {
            node.left = deleteNode(node.left, key);
        } else if (key > node.key) {
            node.right = deleteNode(node.right, key);
        } else {
            // 找到要删除的节点
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            // 用中序后继替代
            Node successor = minValueNode(node.right);
            node.key = successor.key;
            node.right = deleteNode(node.right, successor.key);
        }
        return node;
    }

    // 查找节点
    public boolean search(int key) {
        return searchNode(root, key);
    }

    private boolean searchNode(Node node, int key) {
        if (node == null) {
            return false;
        }
        if (key == node.key) {
            return true;
        }
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
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
}
