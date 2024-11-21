package lab6;

import java.util.ArrayList;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int num = in.nextInt();
        //初始化n个node
        node6c[] node = new node6c[n + 1];
        for (int j = 1; j <= n; j++) {
            node[j] = new node6c(j);
        }
        //创建双向树
        for (int j = 0; j < n - 1; j++) {
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();
            node[u].addChild(node[v]);
            node[u].addWeight(w);
            node[v].addChild(node[u]);
            node[v].addWeight(w);

        }


        //对树进行广度优先遍历，记录每一个节点到根节点的距离
        queue6c q = new queue6c(n + 10);
        q.enqueue(node[1]);
        node[1].path = 0;
        node[1].visited = true;
        while (!q.isEmpty()) {
            node6c current = q.dequeue();
            for (node6c child : current.children) {
                if (!child.visited) {
                    q.enqueue(child);
                    child.path = current.path + current.weight.get(current.children.indexOf(child));
                    child.visited = true;
                }
            }

        }

        //寻找叶子节点，获得答案
        int ans = 0;
        for (int i = 2; i < node.length; i++) {
            if (node[i].children.size() == 1) {
                if (node[i].path == num) {
                    ans++;
                }


            }


        }
        System.out.println(ans);
       /* // 打印树
        System.out.println("Tree Structure:");
        printTree(node[1], null, 0);*/
    }

    // 打印树的方法
    public static void printTree(node6c currentNode, node6c parentNode, int level) {
        // 打印当前节点
        for (int i = 0; i < level; i++) {
            System.out.print("  "); // 缩进
        }
        System.out.print("Node " + currentNode.data);
        if (parentNode != null) {
            int weightIndex = currentNode.children.indexOf(parentNode);
            System.out.print(" (Weight: " + currentNode.weight.get(weightIndex) + ")");
        }
        System.out.println();

        // 递归打印子节点
        for (int i = 0; i < currentNode.children.size(); i++) {
            node6c child = currentNode.children.get(i);
            if (child != parentNode) { // 防止重复打印回父节点
                printTree(child, currentNode, level + 1);
            }
        }

    }
}


class node6c {
    int data;
    int path;
    boolean visited = false;
    ArrayList<node6c> children = new ArrayList<>();
    ArrayList<Integer> weight = new ArrayList<>();

    node6c(int data) {
        this.data = data;
    }

    //加入孩子
    void addChild(node6c child) {
        children.add(child);
    }

    void addWeight(int w) {
        weight.add(w);
    }


}

class queue6c {
    int front = 0;
    int rear = 0;
    int size;
    node6c[] arr;

    queue6c(int size) {
        this.size = size;
        arr = new node6c[size];
    }

    void enqueue(node6c data) {
        if (rear == size) {
            System.out.println("Queue is full");
            return;
        }
        arr[rear] = data;
        rear++;
    }

    node6c dequeue() {
        if (front == rear) {
            System.out.println("Queue is empty");
            return null;
        }
        node6c temp = arr[front];
        front++;
        return temp;
    }

    boolean isEmpty() {
        return front == rear;
    }
}
