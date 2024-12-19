package lab8;

import java.util.ArrayList;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt(); // 节点数量
            int m = in.nextInt(); // 边的数量
            // 初始化n个node
            node8c[] nodes = new node8c[n + 1];
            for (int j = 1; j <= n; j++) {
                nodes[j] = new node8c(j);
            }
            for (int j = 0; j < m; j++) {
                int u = in.nextInt();
                int v = in.nextInt();
                nodes[u].addChild(nodes[v]);
                nodes[v].addChild(nodes[u]);
            }
            queue8c q = new queue8c(n + 10);
            int s = 1; // 源节点
            q.enqueue(nodes[s]);
            nodes[s].path = 0;
            nodes[s].visited = true;
            nodes[s].identity = 1;
            while (!q.isEmpty()) {
                node8c current = q.dequeue();
                for (node8c child : current.children) {
                    if (!child.visited) {
                        q.enqueue(child);
                        child.path = current.path + 1;
                        child.visited = true;
                        if (current.identity == 1) {
                            child.identity = 2;
                        } else {
                            child.identity = 1;
                        }
                    }
                }
            }
            int count1 = 0;
            int count2 = 0;
            for (int j = 1; j <n+1 ; j++) {
                if (nodes[j].identity == 1) {
                    count1++;

                } else {
                    count2++;
                }

            }
            if (count1 > count2) {
                System.out.println(count2);
                for (int j = 1; j < n + 1; j++) {
                    if (nodes[j].identity == 2) {
                        System.out.print(j + " ");
                    }
                }
            } else {
                System.out.println(count1);
                for (int j = 1; j < n + 1; j++) {
                    if (nodes[j].identity == 1) {
                        System.out.print(j + " ");
                    }
                }
            }


        }
    }
}

class node8c {
    int id;
    int path;
    int identity;
    boolean visited;

    ArrayList<node8c> children;

    public node8c(int id) {
        this.id = id;
        this.path = 0;
        this.identity = 0;
        this.visited = false;
        this.children = new ArrayList<node8c>();
    }

    public void addChild(node8c child) {
        this.children.add(child);
    }
}

//node类型的queue
class queue8c {
    node8c[] data;
    int head;
    int tail;

    public queue8c(int n) {
        data = new node8c[n];
        head = 0;
        tail = 0;
    }

    public void enqueue(node8c x) {
        data[tail] = x;
        tail++;
    }

    public node8c dequeue() {
        node8c x = data[head];
        head++;
        return x;
    }

    public boolean isEmpty() {
        return head == tail;
    }
}