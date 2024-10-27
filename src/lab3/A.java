package lab3;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int k = in.nextInt();
            node head = new node(1);
            node current = head;
            for (int j = 2; j < n + 1; j++) {
                node temp = new node(j);
                current.setNext(temp);
                current = current.getNext();
            }
            current.setNext(head);
            current = head;
            if (current.getNext() == current) {
                System.out.println(current.getValue());
                continue;
            }
            while (current != current.getNext()) {
                int count = 0;
                if (k >= 2) {
                    while (count < k - 2) {
                        current = current.getNext();
                        count++;

                    }
                } else if (k == 2) {


                } else {
                    int count1 = 1;
                    while (count1 < n + 1) {
                        System.out.print(count1 + " ");
                        count1++;
                    }
                    break;

                }
                node temp = current;
                current = current.getNext();
                System.out.print(current.getValue() + " ");
                temp.setNext(current.getNext());
                current = current.getNext();


            }

            if (k!=1) {
                System.out.println(current.getValue());
            }else {
                System.out.println();
            }

        }
    }


    public static void print(node head) {
        node current = head;
        while (current.getNext() != head) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.println(current.getValue());
    }
}

class node {
    private int value;  // 节点的值
    private node next;  // 指向下一个节点的指针

    // 构造函数
    public node(int value) {
        this.value = value;
        this.next = null;  // 默认 next 为 null
    }

    // 获取节点的值
    public int getValue() {
        return value;
    }

    // 获取下一个节点
    public node getNext() {
        return next;
    }

    // 设置下一个节点
    public void setNext(node next) {
        this.next = next;
    }
}
