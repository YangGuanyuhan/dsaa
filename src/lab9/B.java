package lab9;

import java.util.ArrayList;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long m = in.nextLong();
        long total = 0;
        graphNode9B[] nodes = new graphNode9B[(int) (n + 1)];
        ArrayList<Long> edges = new ArrayList<>();
        for (long j = 1; j <= n; j++) {
            nodes[(int) j] = new graphNode9B(j);
        }
        for (long i = 0; i < m; i++) {
            long u = in.nextLong();
            long v = in.nextLong();
            long w = in.nextLong();
            edges.add(w);
            if (w > 0) {
                total += w;
            }
            nodes[(int) u].children.add(nodes[(int) v]);
            nodes[(int) v].children.add(nodes[(int) u]);
            nodes[(int) u].weight.add(w);
            nodes[(int) v].weight.add(w);
        }
        //实现prim算法获得最小生成树
        ArrayList<Long> needEdges = new ArrayList<>();
        minHeap9B heap = new minHeap9B((int) (n + 10));
        nodes[1].minimumDistance = 0;
        for (long i = 0; i < nodes[1].children.size(); i++) {
            nodes[1].children.get((int) i).minimumDistance = nodes[1].weight.get((int) i);
            heap.insert(new heapNode9B(nodes[1].children.get((int) i), nodes[1].weight.get((int) i)));
        }
        nodes[1].isGhost = true;
        while (heap.size > 0) {
            heapNode9B current = heap.delete();
            graphNode9B currentGraphNode = current.node;
            if (currentGraphNode.isGhost) {
                continue;
            }
            currentGraphNode.isGhost = true;
            needEdges.add(current.distance);
            for (long i = 0; i < currentGraphNode.children.size(); i++) {
                if (!currentGraphNode.children.get((int) i).isGhost) {
                    graphNode9B child = currentGraphNode.children.get((int) i);
                    long weight = currentGraphNode.weight.get((int) i);
                    if (child.minimumDistance > weight) {
                        child.minimumDistance = weight;
                        heap.insert(new heapNode9B(child, weight));
                    }
                }
            }
        }

        //统计剩余边的权值
        long result = 0;
        for (int i = 0; i < needEdges.size(); i++) {
            if (needEdges.get(i) > 0) {
                result += needEdges.get(i);
            }

        }
        System.out.println(total - result);
    }
}


class graphNode9B {
    long id;
    boolean isGhost;
    long minimumDistance;
    ArrayList<graphNode9B> children = new ArrayList<>();
    ArrayList<Long> weight = new ArrayList<>();

    public graphNode9B(long id) {
        this.id = id;
        this.isGhost = false;
        this.minimumDistance = Long.MAX_VALUE;
    }
}

class heapNode9B {
    graphNode9B node;
    long distance;

    public heapNode9B(graphNode9B node, long distance) {
        this.node = node;
        this.distance = distance;
    }
}

class minHeap9B {
    heapNode9B[] heap;
    int size;

    public minHeap9B(int n) {
        heap = new heapNode9B[n];
        size = 0;
    }

    public void insert(heapNode9B node) {
        heap[size] = node;
        int current = size;
        int parent = (current - 1) / 2;
        while (heap[current].distance < heap[parent].distance) {
            heapNode9B temp = heap[current];
            heap[current] = heap[parent];
            heap[parent] = temp;
            current = parent;
            parent = (current - 1) / 2;
        }
        size++;
    }

    public heapNode9B delete() {
        heapNode9B result = heap[0];
        heap[0] = heap[size - 1];
        size--;
        int current = 0;
        int left = 2 * current + 1;
        int right = 2 * current + 2;
        while (left < size) {
            int smallest = left;
            if (right < size && heap[right].distance < heap[left].distance) {
                smallest = right;
            }
            if (heap[current].distance < heap[smallest].distance) {
                break;
            }
            heapNode9B temp = heap[current];
            heap[current] = heap[smallest];
            heap[smallest] = temp;
            current = smallest;
            left = 2 * current + 1;
            right = 2 * current + 2;
        }
        return result;
    }
}

