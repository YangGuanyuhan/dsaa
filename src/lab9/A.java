package lab9;

import java.util.ArrayList;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // 初始化 n 个 graphNode
        graphNode9A[] nodes = new graphNode9A[n + 1];
        for (int j = 1; j <= n; j++) {
            nodes[j] = new graphNode9A(j);
        }
        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            long w = in.nextLong();
            nodes[u].children.add(nodes[v]);
            nodes[u].weight.add(w);
        }
        long[] result = dijkstra(nodes);
        if (result[n] == Long.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result[n]);
        }
    }

    // 使用幽灵节点找单源最小路径，起始为 1
    public static long[] dijkstra(graphNode9A[] nodes) {
        minHeap9A heap = new minHeap9A(nodes.length + 10);
        nodes[1].minimumDistance = 0;
        heap.insert(new heapNode9A(nodes[1], 0));
        long[] result = new long[nodes.length];
        while (heap.size > 0) {
            heapNode9A current = heap.delete();
            graphNode9A currentGraphNode = current.node;
            if (currentGraphNode.isGhost) {
                continue;
            }
            currentGraphNode.isGhost = true;
            for (int i = 0; i < currentGraphNode.children.size(); i++) {
                graphNode9A child = currentGraphNode.children.get(i);
                long weight = currentGraphNode.weight.get(i);
                if (child.minimumDistance == Long.MAX_VALUE) {
                    child.minimumDistance = currentGraphNode.minimumDistance + weight;
                    heap.insert(new heapNode9A(child, child.minimumDistance));
                } else if (child.minimumDistance > currentGraphNode.minimumDistance + weight) {
                    child.minimumDistance = currentGraphNode.minimumDistance + weight;
                    heap.insert(new heapNode9A(child, child.minimumDistance));
                }
            }
        }
        for (int i = 1; i < nodes.length; i++) {
            result[i] = nodes[i].minimumDistance;
        }
        return result;
    }
}

class graphNode9A {
    int id;
    boolean isGhost;
    long minimumDistance;
    ArrayList<graphNode9A> children = new ArrayList<>();
    ArrayList<Long> weight = new ArrayList<>();

    graphNode9A(int id) {
        this.id = id;
        this.isGhost = false;
        this.minimumDistance = Long.MAX_VALUE;
    }
}

class heapNode9A {
    graphNode9A node;
    long distance;

    heapNode9A(graphNode9A node, long distance) {
        this.node = node;
        this.distance = distance;
    }
}

class minHeap9A {
    heapNode9A[] heap;
    int size;

    minHeap9A(int n) {
        heap = new heapNode9A[n + 1];
        size = 0;
    }

    void insert(heapNode9A node) {
        size++;
        heap[size] = node;
        int current = size;
        while (current > 1 && heap[current].distance < heap[current / 2].distance) {
            heapNode9A temp = heap[current];
            heap[current] = heap[current / 2];
            heap[current / 2] = temp;
            current /= 2;
        }
    }

    heapNode9A delete() {
        heapNode9A result = heap[1];
        heap[1] = heap[size];
        size--;
        int current = 1;
        while (current * 2 <= size) {
            int child = current * 2;
            if (child + 1 <= size && heap[child + 1].distance < heap[child].distance) {
                child++;
            }
            if (heap[current].distance > heap[child].distance) {
                heapNode9A temp = heap[current];
                heap[current] = heap[child];
                heap[child] = temp;
                current = child;
            } else {
                break;
            }
        }
        return result;
    }
}
