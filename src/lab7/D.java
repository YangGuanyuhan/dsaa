package lab7;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long t = in.nextLong(); // 修改为long类型
        long k = in.nextLong(); // 修改为long类型
        long s = in.nextLong(); // 修改为long类型
        long i = 1; // 表示当前的时间
        long last_ans = s;

        // 构建新的heap
        MinHeap7D heap = new MinHeap7D(k);
        while (i <= t) {
            if (!heap.isFull()) { // 如果堆不满
                node7D temp = new node7D(solve(i + last_ans));
                heap.insert(temp);
            } else { // 如果堆满了
                node7D temp = new node7D(solve(i + last_ans));
                if (temp.value >= heap.peek()) {
                    heap.extractMin();
                    heap.insert(temp);
                }
            }

            if (i % 100 == 0) {
                System.out.print(heap.peek() + " ");
                last_ans = heap.peek();
            }
            i++;
        }
    }

    // 计算数字 n 的各位数字和
    public static long sumOfDigits(long n) { // 修改为long类型
        long sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static long solve(long n) { // 修改为long类型
        long ans = 0;
        ans = n + sumOfDigits(n);
        return ans;
    }
}

class node7D {
    long value; // 修改为long类型

    public node7D(long value) { // 修改为long类型
        this.value = value;
    }
}

class MinHeap7D {
    node7D[] heap;
    long size; // 修改为long类型

    public MinHeap7D(long n) { // 修改为long类型
        heap = new node7D[(int) (n + 1)]; // 使用1-based索引
        size = 0;
    }

    // 插入一个节点到堆中
    public void insert(node7D n) {
        size++;
        heap[(int) size] = n; // 插入节点
        shiftUp(size);  // 调整堆
    }

    // 提取堆中的最小值
    public node7D extractMin() {
        node7D root = heap[1];
        heap[1] = heap[(int) size];
        size--;
        shiftDown(1);
        return root;
    }

    // 下沉操作，保证堆的最小值在堆顶
    public void shiftDown(long pointer) { // 修改为long类型
        while (2 * pointer <= size) {
            long minIndex = pointer; // 记录当前节点
            if (2 * pointer <= size && heap[(int) (2 * pointer)].value < heap[(int) minIndex].value) {
                minIndex = 2 * pointer; // 更新最小值索引
            }
            if (2 * pointer + 1 <= size && heap[(int) (2 * pointer + 1)].value < heap[(int) minIndex].value) {
                minIndex = 2 * pointer + 1; // 更新最小值索引
            }
            if (pointer != minIndex) {
                swap(pointer, minIndex); // 交换当前节点和最小值节点
                pointer = minIndex; // 更新指针
            } else {
                break;
            }
        }
    }

    // 上浮操作，保证父节点小于子节点
    public void shiftUp(long pointer) { // 修改为long类型
        while (pointer > 1 && heap[(int) pointer].value < heap[(int) (pointer / 2)].value) {
            swap(pointer, pointer / 2); // 如果父节点大于当前节点，交换
            pointer = pointer / 2; // 更新指针
        }
    }

    // 交换堆中的两个元素
    public void swap(long a, long b) { // 修改为long类型
        node7D temp = heap[(int) a];
        heap[(int) a] = heap[(int) b];
        heap[(int) b] = temp;
    }

    // 打印堆的值（调试用）
    public void print() {
        for (long i = 1; i <= size; i++) { // 修改为long类型
            System.out.print(heap[(int) i].value + " ");
        }
        System.out.println();
    }

    // 判断堆是否已满
    public boolean isFull() {
        return size == heap.length - 1;
    }

    // 获取堆顶的最小值
    public long peek() { // 修改为long类型
        return heap[1].value;
    }
}
