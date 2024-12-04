import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt(); // 节点数量
            maxHeap7B heap = new maxHeap7B(n);
            for (int j = 1; j <= n; j++) {
                node7B temp = new node7B();
                temp.index = j;  // 节点的原始索引
                temp.value = in.nextInt(); // 节点的值
                heap.insert(temp); // 插入堆中
            }
            int target = in.nextInt(); // 目标节点的索引

            // 查找目标节点在堆中的位置
            int position = 0;
            int levelX = 1;
            int levelY = 0;

            // 遍历堆找到目标节点
            for (int j = 0; j < heap.size; j++) {
                if (heap.heap[j + 1].index == target) {
                    position = j + 1;

                    // 计算层级 levelX
                    while (position > 1) {
                        position = position / 2;
                        levelX++;
                    }

                    // 计算层内索引 levelY
                    int nodesInPreviousLevels = (1 << (levelX - 1)) - 1; // 之前层级的节点总数
                    levelY = (j + 1) - nodesInPreviousLevels; // 当前层级的索引

                    System.out.println(levelX + " " + levelY);
                    break;
                }
            }
        }
    }
}

// 节点类
class node7B {
    int index;
    int value;
}

// 最大堆类
class maxHeap7B {
    node7B[] heap;
    int size;

    public maxHeap7B(int n) {
        heap = new node7B[n + 1]; // 使用1-based索引
        size = 0;
    }

    public void insert(node7B n) {
        size++;
        heap[size] = n; // 插入节点
        shiftUp(size);  // 调整堆
    }

    public void shiftUp(int pointer) {
        while (pointer > 1 && heap[pointer].value > heap[pointer / 2].value) {
            swap(pointer, pointer / 2); // 如果父节点小于当前节点，交换
            pointer = pointer / 2; // 更新指针
        }
    }

    public void swap(int a, int b) {
        node7B temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    // 打印堆的值（调试用）
    public void print() {
        for (int i = 1; i <= size; i++) {
            System.out.print(heap[i].value + " ");
        }
        System.out.println();
    }
}
