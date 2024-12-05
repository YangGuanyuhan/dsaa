package lab7;


import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        //构建链表的节点
        Node7E head = new Node7E(-1, 0);
        Node7E current = head;
        Node7E tail = new Node7E(-1, Integer.MAX_VALUE);
        //构建最大堆
        MinHeap7E heap = new MinHeap7E(n);
        //数据读入
        for (int i = 0; i < n; i++) {
            int temp = in.nextInt();
            Node7E newNode = new Node7E(temp, i + 1);
            current.next = newNode;
            newNode.prev = current;
            current = newNode;
            //插入最大堆
            heap.insert(newNode);

        }
        current.next = tail;
        tail.prev = current;

//        //打印链表和堆
//        print(head);
//        System.out.println(" ");
//        heap.printHeap();

        //循环n-1操作，计算胡萝卜的总数
        for (int i = 0; i < n - 1; i++) {
            //取出最小的节点
            Node7E min = heap.delete();
            //取出最小节点的前后节点，注意可能前后没有节点
            Node7E prev = min.prev;
            Node7E next = min.next;
            //对前后节点进行比较，选取合并后的值最大的那一个节点
            int calculatePrev = -2;
            int calculateNext = -2;
            if (prev.data != -1) {
                calculatePrev = (prev.data ^ min.data) + 1;

            }
            if (next.data != -1) {
                calculateNext = (next.data ^ min.data) + 1;
            }
            //选择前后节点中值最大的那一个节点进行合并
            if (calculatePrev >= calculateNext) {
                mergepre(min, prev, heap);

            } else {
                mergenext(min, next, heap);
            }
        }
        //取出最后一个节点，即为胡萝卜的总数
        Node7E result = heap.delete();
        System.out.println(result.data);

        //打印链表和堆
//        print(head);
//        System.out.println(" ");
//        heap.printHeap();


    }

    //打印链表
    public static void print(Node7E head) {
        System.out.println("linkedlist ");
        Node7E current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    public static void mergenext(Node7E min, Node7E delete, MinHeap7E heap) {
        //创建一个新的节点，值为两个节点的异或值，index为min的index
        Node7E newNode = new Node7E((min.data ^ delete.data) + 1, min.index);
        //删除min和delete节点
        delete.isGhost = true;
        //在链表中进行操作
        min.prev.next = newNode;
        newNode.prev = min.prev;
        newNode.next = delete.next;
        delete.next.prev = newNode;
        //在堆中插入新的节点
        heap.insert(newNode);

    }

    public static void mergepre(Node7E min, Node7E delete, MinHeap7E heap) {
        //创建一个新的节点，值为两个节点的异或值，index为min的index
        Node7E newNode = new Node7E((min.data ^ delete.data) + 1, min.index);
        //删除min和delete节点
        delete.isGhost = true;
        //在链表中进行操作
        delete.prev.next = newNode;
        newNode.prev = delete.prev;
        newNode.next = min.next;
        min.next.prev = newNode;

        //在堆中插入新的节点
        heap.insert(newNode);

    }
}


class Node7E {
    int data;
    int index;
    Node7E next;
    Node7E prev;
    boolean isGhost;

    Node7E(int data, int index) {
        this.data = data;
        this.index = index;
        this.isGhost = false;
    }

    public String toString() {
        return "data: " + data + " index: " + index;
    }

}

//基于node的值的大小来构建以数组为类型的最小堆，堆的大小为n+1，插入一个新的节点如果data相同，index小的优先
class MinHeap7E {
    Node7E[] heap;
    int size;

    MinHeap7E(int n) {
        this.size = 0;
        this.heap = new Node7E[n + 1];
    }

    public void insert(Node7E node) {
        size++;
        heap[size] = node;
        int current = size;
        while (current > 1) {
            if (heap[current].data < heap[current / 2].data) {
                swap(current, current / 2);
                current = current / 2;
            } else if (heap[current].data == heap[current / 2].data) {
                if (heap[current].index < heap[current / 2].index) {
                    swap(current, current / 2);
                    current = current / 2;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
    }

    public Node7E delete() {
        // 非递归检查堆顶是否为Ghost
        while (heap[1].isGhost) {
            // 删除堆顶元素
            heap[1] = heap[size];
            size--;
            // 调整堆结构
            heapifyDown(1);
        }

        // 记录结果
        Node7E result = heap[1];
        // 删除堆顶元素并重构堆
        heap[1] = heap[size];
        size--;
        heapifyDown(1);

        return result;
    }

    // 下沉操作，调整堆
    private void heapifyDown(int current) {
        while (current * 2 <= size) {
            int minIndex = current * 2;
            if (current * 2 + 1 <= size && heap[current * 2 + 1].data < heap[current * 2].data) {
                minIndex = current * 2 + 1;
            } else if (current * 2 + 1 <= size && heap[current * 2 + 1].data == heap[current * 2].data) {
                if (heap[current * 2 + 1].index < heap[current * 2].index) {
                    minIndex = current * 2 + 1;
                }
            }
            if (heap[current].data > heap[minIndex].data) {
                swap(current, minIndex);
                current = minIndex;
            } else if (heap[current].data == heap[minIndex].data) {
                if (heap[current].index > heap[minIndex].index) {
                    swap(current, minIndex);
                    current = minIndex;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
    }


    public void swap(int i, int j) {
        Node7E temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void printHeap() {
        System.out.println("heap ");
        for (int i = 1; i <= size; i++) {
            System.out.println(heap[i].data + " " + heap[i].index);
        }
    }
}



