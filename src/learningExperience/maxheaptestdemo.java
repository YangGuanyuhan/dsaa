package learningExperience;

import java.util.Scanner;

public class maxheaptestdemo {
    public static void main(String[] args) {
        //写一些程序利用scanner根据输入测试最大堆
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        maxHeaptestdemotest heap = new maxHeaptestdemotest(n);
        for (int i = 1; i <= n; i++) {
            nodetestdemo temp = new nodetestdemo();
            temp.value = in.nextInt();
            heap.insert(temp);
        }
        heap.print();



    }


}

class nodetestdemo {
    int value;
}

// 最大堆类
class maxHeaptestdemotest {
    nodetestdemo[] heap;
    int size;

    public maxHeaptestdemotest(int n) {
        heap = new nodetestdemo[n + 1]; // 使用1-based索引
        size = 0;
    }

    public void insert(nodetestdemo n) {
        size++;
        heap[size] = n; // 插入节点
        shiftUp(size);  // 调整堆
    }

    public nodetestdemo extractMax() {
        nodetestdemo root = heap[1];
        heap[1] = heap[size];
        size--;
        shiftDown(1);
        return root;
    }

    private void shiftDown(int i) {
        if (2 * i <= size && 2 * i + 1 <= size) {
            if (heap[2 * i].value >= heap[2 * i + 1].value) {
                if (heap[2 * i].value > heap[i].value) {
                    swap(i, 2 * i);
                    shiftDown(2 * i);
                } else {
                    return;
                }
            } else {
                if (heap[2 * i + 1].value > heap[i].value) {
                    swap(i, 2 * i + 1);
                    shiftDown(2 * i + 1);
                } else {
                    return;
                }
            }
        } else if (2 * i <= size) {
            if (heap[2 * i].value > heap[i].value) {
                swap(i, 2 * i);
                shiftDown(2 * i);
            } else {
                return;
            }

        } else {
            return;
        }

    }

    /*
    public void shiftDown(int pointer) {
        while (2 * pointer <= size) {
            int maxIndex = pointer; // 记录当前节点
            if (2 * pointer <= size && heap[2 * pointer].value > heap[maxIndex].value) {
                maxIndex = 2 * pointer; // 更新最大值索引
            }
            if (2 * pointer + 1 <= size && heap[2 * pointer + 1].value > heap[maxIndex].value) {
                maxIndex = 2 * pointer + 1; // 更新最大值索引
            }
            if (pointer != maxIndex) {
                swap(pointer, maxIndex); // 交换当前节点和最大值节点
                pointer = maxIndex; // 更新指针
            } else {
                break;
            }
        }
    }
    */


    public void shiftUp(int pointer) {
        while (pointer > 1 && heap[pointer].value > heap[pointer / 2].value) {
            swap(pointer, pointer / 2); // 如果父节点小于当前节点，交换
            pointer = pointer / 2; // 更新指针
        }
    }

    public void swap(int a, int b) {
        nodetestdemo temp = heap[a];
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