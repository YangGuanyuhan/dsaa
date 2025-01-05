package lab9;

import java.util.ArrayList;
import java.util.Scanner;

public class E {
    public static ArrayList<Integer> outStackOrder;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        graphNode9E[] nodes = new graphNode9E[n + 1];
        for (int j = 1; j <= n; j++) {
            nodes[j] = new graphNode9E(j);
        }
        int m = in.nextInt();
        int s = in.nextInt();
        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            nodes[u].children.add(nodes[v]);
            nodes[v].inverseChildren.add(nodes[u]);
        }
        outStackOrder = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!nodes[i].visited) {
                dfs2(nodes, i);
            }
        }
        for (int i = 1; i <= n; i++) {
            nodes[i].visited = false;
        }
        //对出栈顺序进行逆序
        ArrayList<Integer> reverseOutStackOrder = new ArrayList<>();
        for (int i = outStackOrder.size() - 1; i >= 0; i--) {
            reverseOutStackOrder.add(outStackOrder.get(i));
        }
        //根据逆序的出栈顺序进行dfs
        int count = 0;//强连通分量的个数
        for (int i = 0; i < reverseOutStackOrder.size(); i++) {
            if (!nodes[reverseOutStackOrder.get(i)].visited) {
                dfs(nodes, reverseOutStackOrder.get(i), count);
                count++;

            }
        }
        int[] inDegree = new int[count];
        for (int i = 1; i <= n; i++) {
            for (graphNode9E child : nodes[i].children) {
                if (nodes[i].identity != child.identity) {
                    inDegree[child.identity]++;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i <count; i++) {
            if (inDegree[i] == 0) {
                ans++;
            }
        }
        if (inDegree[nodes[s].identity] == 0) {
            System.out.println(ans - 1);
        } else {
            System.out.println(ans);
        }


    }

    public static void dfs(graphNode9E[] nodes, int s, int identity) {
        nodes[s].visited = true;
        nodes[s].identity = identity;
        for (graphNode9E child : nodes[s].children) {
            if (!child.visited) {
                dfs(nodes, child.index, identity);
            }
        }
    }
    public static void dfs2(graphNode9E[] nodes, int s) {
        nodes[s].visited = true;
        for (graphNode9E child : nodes[s].inverseChildren) {
            if (!child.visited) {
                dfs2(nodes, child.index);
            }
        }
        outStackOrder.add(s);
    }
}

class graphNode9E {
    int index;
    int path;
    int identity;
    boolean visited;
    ArrayList<graphNode9E> children;
    ArrayList<graphNode9E> inverseChildren;

    public graphNode9E(int index) {
        this.index = index;
        this.visited = false;
        this.children = new ArrayList<>();
        this.inverseChildren = new ArrayList<>();

    }
}
