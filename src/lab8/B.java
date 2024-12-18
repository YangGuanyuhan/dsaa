package lab8;

import java.util.ArrayList;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            int s = in.nextInt();
            //初始化n个node
            node8B[] nodes = new node8B[n + 1];
            for (int j = 1; j <= n; j++) {
                nodes[j] = new node8B(j);
            }
            //创建图
            for (int j = 0; j < m; j++) {
                int u = in.nextInt();
                int v = in.nextInt();
                nodes[u].addChild(nodes[v]);
                nodes[v].addChild(nodes[u]);
            }
            //对图进行广度优先遍历，记录每一个节点到source节点的距离
            queue8B q = new queue8B(n + 10);
            q.enqueue(nodes[s]);
            nodes[s].path = 0;
            nodes[s].visited = true;
            while (!q.isEmpty()) {
                node8B current = q.dequeue();
                for (node8B child : current.children) {
                    if (!child.visited) {
                        q.enqueue(child);
                        child.path = current.path + 1;
                        child.visited = true;
                    }
                }
            }
            //打印所有节点，如果没找到是-1，如果j==s是0
            for (int j = 1; j <= n; j++) {
                if (j == s) {
                    System.out.print(0 + " ");
                } else if (nodes[j].visited) {
                    System.out.print(nodes[j].path + " ");
                } else {
                    System.out.print(-1 + " ");
                }
            }





        }

    }
}

class node8B {
    int value;
    int path;
    boolean visited;
    ArrayList<node8B> children;

    public node8B(int value) {
        this.value = value;
        this.path = 0;
        this.visited = false;
        this.children = new ArrayList<>();
    }

    public void addChild(node8B n) {
        children.add(n);
    }

}
class queue8B {
    node8B[] q;
    int head;
    int tail;
    int size;

    public queue8B(int n) {
        q = new node8B[n];
        head = 0;
        tail = 0;
        size = n;
    }

    public void enqueue(node8B n) {
        q[tail] = n;
        tail = (tail + 1) % size;
    }

    public node8B dequeue() {
        node8B temp = q[head];
        head = (head + 1) % size;
        return temp;
    }

    public boolean isEmpty() {
        return head == tail;
    }
}
