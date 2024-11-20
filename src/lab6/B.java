package lab6;



import java.util.ArrayList;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            //初始化n个node
            node6B[] nodes = new node6B[n + 1];
            for (int j = 1; j <= n; j++) {
                nodes[j] = new node6B(j);
            }


            for (int j = 0; j < n - 1; j++) {
                int parent = in.nextInt();
                nodes[parent].addChild(nodes[j + 2]);

            }
            queue6B q = new queue6B(n + 1);
            q.enqueue(nodes[1]);
            while (!q.isEmpty()) {
                node6B current = q.dequeue();
                System.out.print(current.data+" ");
                for (node6B child : current.children) {
                    q.enqueue(child);
                }

            }
            System.out.println();



        }
    }

}

class node6B {
    int data;
    ArrayList<node6B> children = new ArrayList<>();

    node6B(int data) {
        this.data = data;
    }

    //加入孩子
    void addChild(node6B child) {
        children.add(child);
    }
}

class queue6B {
    int front = 0;
    int rear = 0;
    int size;
    node6B[] arr;

    queue6B(int size) {
        this.size = size;
        arr = new node6B[size];
    }

    void enqueue(node6B data) {
        if (rear == size) {
            System.out.println("Queue is full");
            return;
        }
        arr[rear] = data;
        rear++;
    }

    node6B dequeue() {
        if (front == rear) {
            System.out.println("Queue is empty");
            return null;
        }
        node6B temp = arr[front];
        front++;
        return temp;
    }

    boolean isEmpty() {
        return front == rear;
    }


}
