package lab6;

import java.util.ArrayList;
import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        //初始化n个node
        node6E[] node = new node6E[n + 1];
        for (int j = 1; j <= n; j++) {
            node[j] = new node6E(j);
        }
        //创建双向树
        for (int j = 0; j < n - 1; j++) {
            int u = in.nextInt();
            int v = in.nextInt();
            node[u].addChild(node[v]);
            node[v].addChild(node[u]);
        }
        //打印树
        //printTree(node[1], null, 0);

        //对树进行广度优先遍历，记录每一个节点到根节点的距离
        queue6E q = new queue6E(n + 10);
        q.enqueue(1);
        node[1].firstvisited = true;
        node[1].path = 0;
        while (!q.isEmpty()) {
            int current = q.dequeue();
            for (node6E child : node[current].children) {
                if (!child.firstvisited) {
                    q.enqueue(child.id);
                    child.path = node[current].path + 1;
                    child.firstvisited = true;
                }
            }
        }
        q.clear();

        //记录哪一些节点上有人
        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            int x = in.nextInt();
            node[x].isPeople = true;
        }
        //对子树进行层序遍历
        ArrayList<Integer> ans = new ArrayList<>();
        node6E root = node[1];
        root.secondvisited = true;
        for (int i = 0; i < root.children.size(); i++) {
            q.clear();
            ArrayList<Integer> temp = new ArrayList<>();
            q.enqueue(root.children.get(i).id);
            root.children.get(i).secondvisited = true;
            while (!q.isEmpty()) {
                int current = q.dequeue();
                if (node[current].isPeople) {
                    temp.add(node[current].path);
                }
                for (node6E child : node[current].children) {
                    if (!child.secondvisited) {
                        q.enqueue(child.id);
                        child.secondvisited = true;
                    }
                }
            }
            if (temp.isEmpty()) continue;
            int initial = temp.get(0);
            ArrayList<Integer> subans = new ArrayList<>();
            subans.add(initial);
            for (int j = 1; j < temp.size(); j++) {
                subans.add(Math.max(subans.get(j-1)+1, temp.get(j)));

            }
            ans.add(subans.get(subans.size()-1));
            /*//打印tmp
            System.out.println("tmp:");
            for (int j = 0; j < temp.size(); j++) {
                System.out.print(temp.get(j)+" ");
            }
            System.out.println();

            //打印subans
            System.out.println("subans:");
            for (int j = 0; j < subans.size(); j++) {
                System.out.print(subans.get(j)+" ");
            }
            System.out.println();*/


        }
      /*  //打印ans
        System.out.println("ans:");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i)+" ");
        }
        System.out.println();*/
        //打印ans中的最大值
        int max = ans.get(0);
        for (int i = 1; i < ans.size(); i++) {
            max = Math.max(max, ans.get(i));
        }
        System.out.println(max);


    }
    //写一个打印树的方法
    public static void printTree(node6E currentNode, node6E parentNode, int level) {
        // 打印当前节点
        for (int i = 0; i < level; i++) {
            System.out.print("  "); // 缩进
        }
        System.out.print("Node " + currentNode.id);
        if (parentNode != null) {
            System.out.print(" (Parent: " + parentNode.id + ")");
        }
        System.out.println();

        // 递归打印子节点
        for (int i = 0; i < currentNode.children.size(); i++) {
            node6E child = currentNode.children.get(i);
            if (child != parentNode) { // 防止重复打印回父节点
                printTree(child, currentNode, level + 1);
            }
        }

    }
}

class node6E {
    int id;
    int path;
    boolean firstvisited;
    boolean secondvisited;
    boolean isPeople;
    ArrayList<node6E> children;

    public node6E(int id) {
        this.id = id;
        this.path = 0;
        this.firstvisited = false;
        this.secondvisited = false;
        this.isPeople = false;
        this.children = new ArrayList<>();
    }

    public void addChild(node6E child) {
        this.children.add(child);
    }


}

class queue6E {
    int[] q;
    int head;
    int tail;

    public queue6E(int n) {
        q = new int[n];
        head = 0;
        tail = 0;
    }

    public void enqueue(int x) {
        q[tail] = x;
        tail++;
    }

    public int dequeue() {
        int x = q[head];
        head++;
        return x;
    }

    public boolean isEmpty() {
        return head == tail;
    }
    public void clear() {
        head = 0;
        tail = 0;
    }
}