package lab3;

import java.util.Scanner;

public class B2_0 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int numTerms = scanner.nextInt();
            Node head = new Node(0, 0); // 头节点

            for (int j = 0; j < numTerms; j++) {
                int coefficient = scanner.nextInt();
                int exponent = scanner.nextInt();
                insertTerm(head, coefficient, exponent); // 插入多项式项
            }

            int numQueries = scanner.nextInt();
            for (int j = 0; j < numQueries; j++) {
                int x = scanner.nextInt();
                System.out.println(evaluate(head, x)); // 评估多项式
            }
        }
    }

    static class Node {
        int coefficient; // 系数
        int exponent; // 指数
        Node next; // 下一个节点

        public Node(int coefficient, int exponent) {
            this.coefficient = coefficient;
            this.exponent = exponent;
            this.next = null;
        }
    }

    // 插入多项式项的方法
    static void insertTerm(Node head, int coefficient, int exponent) {
        Node current = head;

        // 遍历找到正确的插入位置
        while (current.next != null && current.next.exponent > exponent) {
            current = current.next;
        }

        // 如果同样的指数存在，增加系数
        if (current.next != null && current.next.exponent == exponent) {
            current.next.coefficient += coefficient;
        } else {
            Node newTerm = new Node(coefficient, exponent);
            newTerm.next = current.next;
            current.next = newTerm; // 插入新节点
        }
    }

    // 评估多项式的方法
    static int evaluate(Node head, int x) {
        int result = 0;
        Node current = head.next; // 跳过头节点

        while (current != null) {
            result += current.coefficient * Math.pow(x, current.exponent); // 计算多项式的值
            current = current.next; // 移动到下一个节点
        }

        return result; // 返回多项式在 x 处的值
    }
}

