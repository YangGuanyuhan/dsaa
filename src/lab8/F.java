package lab8;

import java.util.ArrayList;
import java.util.Scanner;

public class F {
    public static void main(String[] args) {
        final int mod = 1000000007;
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt(); // 节点数量
            int m = in.nextInt(); // 边的数量
            // 初始化n个node
            node8f[] nodes = new node8f[n + 1];
            //初始化函数f
            int[] function = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                nodes[j] = new node8f(j, in.nextInt(), in.nextInt());
            }
            for (int j = 0; j < m; j++) {
                int u = in.nextInt();
                int v = in.nextInt();
                nodes[u].addChild(nodes[v]);
                nodes[v].addParent(nodes[u]);
                nodes[v].in_degree++;
            }
            queue8F q = new queue8F(n + 10);
            for (int j = 1; j <= n; j++) {
                if (nodes[j].in_degree == 0) {
                    q.enqueue(nodes[j]);
                    function[j] = 0;
                }
            }

            while (!q.isEmpty()) {
                node8f current = q.dequeue();
                for (node8f child : current.children) {
                    child.in_degree--;
                    function[child.id] += ((function[current.id] + current.a)%mod);
                    function[child.id]%=mod;
                    if (child.in_degree == 0) {
                        q.enqueue(child);
                    }
                }
            }
            int ans = 0;
            for (int j = 1; j <= n; j++) {
                ans += ((function[j] * nodes[j].b)%mod);
                ans%=mod;
            }
            System.out.println(ans);


        }
    }

    public static void topological_sort(node8f[] nodes) {
        queue8F q = new queue8F(1000);
        for (node8f n : nodes) {
            if (n.in_degree == 0) {
                q.enqueue(n);
            }
        }
        while (!q.isEmpty()) {
            node8f current = q.dequeue();
            for (node8f child : current.children) {
                child.in_degree--;
                if (child.in_degree == 0) {
                    q.enqueue(child);
                }
            }
        }
    }

    public static void bfs(node8f source) {
        queue8F q = new queue8F(1000);
        q.enqueue(source);
        source.visited = true;
        while (!q.isEmpty()) {
            node8f current = q.dequeue();
            for (node8f child : current.children) {
                if (!child.visited) {
                    q.enqueue(child);
                    child.visited = true;
                    child.path = current.path + 1;
                }
            }
        }
    }

    public static void dfs(node8f current) {
        current.visited = true;
        for (node8f child : current.children) {
            if (!child.visited) {
                dfs(child);
            }
        }
    }
}

class node8f {
    int id;
    int path;
    int a;
    int b;

    int in_degree;
    boolean visited;

    node8f(int id, int a, int b) {
        this.id = id;
        this.a = a;
        this.b = b;
        this.visited = false;
        this.path = 0;
        this.in_degree = 0;
    }


    ArrayList<node8f> children = new ArrayList<>();
    ArrayList<node8f> parents = new ArrayList<>();

    void addChild(node8f child) {
        children.add(child);
    }

    void addParent(node8f parent) {
        parents.add(parent);
    }
}

class queue8F {
    node8f[] data;
    int head;
    int tail;

    queue8F(int n) {
        data = new node8f[n];
        head = 0;
        tail = 0;
    }

    void enqueue(node8f x) {
        data[tail] = x;
        tail++;
    }

    node8f dequeue() {
        node8f x = data[head];
        head++;
        return x;
    }

    boolean isEmpty() {
        return head == tail;
    }
}
