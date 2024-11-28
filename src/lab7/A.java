package lab7;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//tree size
        int[] heap = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            heap[i] = in.nextInt();
        }
        int maxcount = 0;
        int mincount = 0;
        for (int i = 1; i < heap.length; i++) {
            if (2 * i < heap.length && 2 * i + 1 < heap.length) {
                if (heap[i]>heap[2*i]&&heap[i]>heap[2*i+1]){
                    maxcount++;
                }
                if (heap[i]<heap[2*i]&&heap[i]<heap[2*i+1]){
                    mincount++;
                }
            }else if (2 * i < heap.length){
                if (heap[i]>heap[2*i]){
                    maxcount++;
                }
                if (heap[i]<heap[2*i]){
                    mincount++;
                }
            }


        }
        if (maxcount==0){
            System.out.println("Min");
        }else if (mincount==0){
            System.out.println("Max");
        }else {
            System.out.println("Neither");
        }
    }
}

