package lab7;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // int t = in.nextInt();
        //    for (int i = 0; i < t; i++) {
        int n = in.nextInt();
        maxHeap7B heap = new maxHeap7B(n);
        for (int j = 1; j <= n; j++) {
            node7B temp = new node7B();
            temp.index = j;
            temp.value = in.nextInt();
            heap.insert(temp);
        }


        //    }
        heap.print();
    }

}

class node7B {
    int index;
    int value;
}

class maxHeap7B {
    node7B[] heap;
    int size;

    public maxHeap7B(int n) {
        heap = new node7B[n + 1];
        size = 0;
    }

    public void insert(node7B n) {
        size++;
        heap[size] = n;
        shiftUp(size);

    }

    public void shiftUp(int pointer) {
        while (pointer > 1 && heap[pointer].value > heap[pointer / 2].value) {
            swap(pointer, pointer / 2);
            pointer = pointer / 2;
        }

    }

    public void swap(int a, int b) {
        node7B temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    //打印堆
    public void print() {
        for (int i = 1; i <= size; i++) {
            System.out.print(heap[i].value + " ");
        }
        System.out.println();
    }

}