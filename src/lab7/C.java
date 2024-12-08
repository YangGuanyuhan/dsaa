package lab7;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            player7c[] players = new player7c[n];
            for (int j = 0; j < n; j++) {
                players[j] = new player7c(in.nextInt());
            }
            for (int j = 0; j < n; j++) {
                players[j].time = in.nextInt();
            }
            mergeSort(players, 0, n - 1);
            int time = players[0].time;
            int power = 0;
            int index = 0;
            maxHeap7c heap = new maxHeap7c(n);
            while (time > 0) {
                // 插入所有time等于当前time的玩家
                while (index < players.length && players[index].time == time) {
                    heap.insert(players[index]);
                    index++;
                }

                // 如果堆中有玩家，则增加最大玩家的power
                if (heap.size > 0) {
                    player7c temp = heap.extractMax();
                    power += temp.power;
                }

                // 递减时间
                time--;
            }
            System.out.println(power);
        }
    }

    //based on the time of the player, use mergesort the players in descending order
    public static void mergeSort(player7c[] players, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(players, l, m);
            mergeSort(players, m + 1, r);
            merge(players, l, m, r);
        }
    }

    public static void merge(player7c[] players, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        player7c[] L = new player7c[n1];
        player7c[] R = new player7c[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = players[l + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = players[m + 1 + i];
        }
        int i = 0;
        int j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].time > R[j].time) {
                players[k] = L[i];
                i++;
            } else if (L[i].time == R[j].time) {
                if (L[i].power > R[j].power) {
                    players[k] = L[i];
                    i++;
                } else {
                    players[k] = R[j];
                    j++;
                }
            } else {
                players[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            players[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            players[k] = R[j];
            j++;
            k++;
        }
    }

}

class player7c {
    int power;
    int time;

    public player7c(int power) {
        this.power = power;
    }
}

//maxHeap class based on the power of the player
class maxHeap7c {
    player7c[] heap;
    int size;

    public maxHeap7c(int n) {
        heap = new player7c[n + 1];
        size = 0;
    }

    public void insert(player7c n) {
        size++;
        heap[size] = n;
        shiftUp(size);

    }

    public player7c extractMax() {
        player7c result = heap[1];
        heap[1] = heap[size];
        size--;
        shiftDown(1);
        return result;
    }


    public void shiftUp(int pointer) {
        while (pointer > 1 && heap[pointer].power > heap[pointer / 2].power) {
            swap(pointer, pointer / 2);
            pointer = pointer / 2;
        }

    }

    private void shiftDown(int i) {
        if (2 * i <= size && 2 * i + 1 <= size) {
            if (heap[2 * i].power >= heap[2 * i + 1].power) {
                if (heap[2 * i].power > heap[i].power) {
                    swap(i, 2 * i);
                    shiftDown(2 * i);
                } else {
                    return;
                }
            } else {
                if (heap[2 * i + 1].power > heap[i].power) {
                    swap(i, 2 * i + 1);
                    shiftDown(2 * i + 1);
                } else {
                    return;
                }
            }
        } else if (2 * i <= size) {
            if (heap[2 * i]. power> heap[i].power) {
                swap(i, 2 * i);
                shiftDown(2 * i);
            } else {
                return;
            }

        } else {
            return;
        }

    }

    public void swap(int a, int b) {
        player7c temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    //print the heap
    public void print() {
        for (int i = 1; i <= size; i++) {
            System.out.print(heap[i].power + " ");
        }
        System.out.println();
    }
}
