package lab9;

import java.util.ArrayList;
import java.util.Scanner;

public class F {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long m = in.nextLong();
        long p = in.nextLong();
        long k = in.nextLong();//最多用k个传送门
        graphNode9F[][] nodes = new graphNode9F[(int) n + 1][(int) k + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                nodes[i][j] = new graphNode9F(i, j);
            }
        }
        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();
            for (int j = 0; j < k+1; j++) {
                nodes[u][j].children.add(nodes[v][j]);
                nodes[u][j].weight.add(w);
            }
        }
        for (int i = 0; i < p; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            for (int j = 0; j < k; j++) {
                nodes[u][j].portals.add(nodes[v][j + 1]);
            }

        }
        int s=in.nextInt();//origin
        int t=in.nextInt();//destination

        minHeap9F heap = new minHeap9F((int) (n * (k + 1) + 1000));
        nodes[s][0].minimumDistance = 0;
        heap.insert(new heapNode9F(nodes[s][0], 0));
        while (heap.size > 0) {
            heapNode9F current = heap.delete();
            graphNode9F currentGraphNode = current.node;
            if (current.node.index == t) {
                break;
            }
            if (currentGraphNode.isGhost) {
                continue;
            }
            currentGraphNode.isGhost = true;
            for (int i = 0; i < currentGraphNode.children.size(); i++) {
                graphNode9F child = currentGraphNode.children.get(i);
                int weight = currentGraphNode.weight.get(i);
                if (child.minimumDistance > currentGraphNode.minimumDistance + weight) {
                    child.minimumDistance = currentGraphNode.minimumDistance + weight;
                    heap.insert(new heapNode9F(child, child.minimumDistance));
                }
            }
            for (int i = 0; i < currentGraphNode.portals.size(); i++) {
                graphNode9F portal = currentGraphNode.portals.get(i);
                int weight = 0;
                if (portal.minimumDistance > currentGraphNode.minimumDistance + weight) {
                    portal.minimumDistance = currentGraphNode.minimumDistance + weight;
                    heap.insert(new heapNode9F(portal, portal.minimumDistance));
                }
            }
        }
        long result = Long.MAX_VALUE;
        for (int i = 0; i < k+1; i++) {
            result = Math.min(result, nodes[t][i].minimumDistance);


        };

        System.out.println(result);



    }
}
class graphNode9F {
    int index;
    int portalTimes;
    long  minimumDistance;
    boolean isGhost;

    ArrayList<graphNode9F> children;
    ArrayList<graphNode9F> portals;
    ArrayList<Integer> weight;

    public graphNode9F(int index, int portalTimes) {
        this.index = index;
        this.portalTimes = portalTimes;
        this.minimumDistance = Long.MAX_VALUE;
        this.isGhost = false;
        this.children = new ArrayList<>();
        this.portals = new ArrayList<>();
        this.weight = new ArrayList<>();
    }

}
class heapNode9F {
    graphNode9F node;
    long distance;

    public heapNode9F(graphNode9F node, long distance) {
        this.node = node;
        this.distance = distance;
    }
}
class minHeap9F {
    heapNode9F[] heap;
    int size;

    minHeap9F(int n) {
        heap = new heapNode9F[n + 1];
        size = 0;
    }

    void insert(heapNode9F node) {
        size++;
        heap[size] = node;
        int current = size;
        while (current > 1 && heap[current].distance < heap[current / 2].distance) {
            heapNode9F temp = heap[current];
            heap[current] = heap[current / 2];
            heap[current / 2] = temp;
            current /= 2;
        }
    }

    heapNode9F delete() {
        heapNode9F result = heap[1];
        heap[1] = heap[size];
        size--;
        int current = 1;
        while (current * 2 <= size) {
            int child = current * 2;
            if (child + 1 <= size && heap[child + 1].distance < heap[child].distance) {
                child++;
            }
            if (heap[current].distance > heap[child].distance) {
                heapNode9F temp = heap[current];
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
