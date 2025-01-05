package lab9;

import java.util.ArrayList;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//节点数
        int m = in.nextInt();//边数
        int k = in.nextInt();//颜色种类
        int c = in.nextInt();//需要的前几个颜色
        node9D[] nodes = new node9D[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new node9D(i, k, in.nextInt()-1);
        }
        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            nodes[u].addChild(nodes[v]);
            nodes[v].addChild(nodes[u]);
        }
        //对每一种颜色进行广度优先遍历，记录每一种节点获取到这个颜色的最短距离
        for (int i = 0; i < k; i++) {
            queue9D q = new queue9D(n + 10);
            for (int j = 1; j <= n; j++) {
                nodes[j].visited = false;
                nodes[j].path = 0;
            }
            for (int j = 1; j <= n; j++) {
                if (nodes[j].identity == i) {
                    q.enqueue(nodes[j]);
                    nodes[j].visited = true;
                    nodes[j].path = 0;
                } else {
                    nodes[j].path = Integer.MAX_VALUE;
                }
            }
            while (!q.isEmpty()) {
                node9D current = q.dequeue();
                for (node9D child : current.children) {
                    if (child.path > current.path + 1 && !child.visited) {
                        q.enqueue(child);
                        child.path = current.path + 1;
                        child.visited = true;
                    }
                }
            }
            for (int j = 1; j <= n; j++) {
                nodes[j].color[i] = nodes[j].path;
                // System.out.print(nodes[j].color[i] + " ");
            }
            //System.out.println();

        }
        //对每一个节点进行排序，找到前c个颜色的最短距离
        for (int i = 1; i <= n; i++) {
            nodes[i].color = quickSort(nodes[i].color, 0, k - 1);
            int sum = 0;
            for (int j = 0; j < c; j++) {
                sum += nodes[i].color[j];
            }
            System.out.print(sum + " ");
        }


    }

    public static int[] quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int l = low;
            int h = high;
            int pivot = arr[low];
            while (l < h) {
                while (l < h && arr[h] >= pivot) {
                    h--;
                }
                if (l < h) {
                    arr[l] = arr[h];
                    l++;
                }
                while (l < h && arr[l] <= pivot) {
                    l++;
                }
                if (l < h) {
                    arr[h] = arr[l];
                    h--;
                }
            }
            arr[l] = pivot;
            quickSort(arr, low, l - 1);
            quickSort(arr, l + 1, high);
        }
        return arr;
    }
}

class node9D {
    int id;
    int identity;
    int path;
    int[] color;
    boolean visited;
    ArrayList<node9D> children = new ArrayList<node9D>();

    public node9D(int id, int k, int a) {
        this.id = id;
        this.identity = a;
        this.path = 0;
        this.visited = false;
        this.color = new int[k];
    }

    public void addChild(node9D child) {
        children.add(child);
    }
}

class queue9D {
    node9D[] data;
    int head;
    int tail;
    int size;

    public queue9D(int n) {
        data = new node9D[n];
        head = 0;
        tail = 0;
        size = n;
    }

    public void enqueue(node9D a) {
        data[tail] = a;
        tail = (tail + 1) % size;
    }

    public node9D dequeue() {
        node9D temp = data[head];
        head = (head + 1) % size;
        return temp;
    }

    public boolean isEmpty() {
        return head == tail;
    }

}
