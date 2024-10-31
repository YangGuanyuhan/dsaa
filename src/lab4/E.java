package lab4;

import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt(); // 读取测试用例数量
        for (int t = 1; t <= T; t++) {
            int n = in.nextInt(); // 读取学生数量
            int[] heights = new int[n];
            // 读取每个学生的身高
            for (int i = 0; i < n; i++) {
                heights[i] = in.nextInt();
            }
            int[] leftAns = new int[n]; // 记录每个学生和左边第一个比自己高的学生中间最高的学生的索引
            int[] rightAns = new int[n]; // 记录每个学生和右边第一个比自己高的学生中间最高的学生的索引
            NodeStack4E stackleft = new NodeStack4E(n);
            NodeStack4E stackright = new NodeStack4E(n);
            for (int i = 0; i < n; i++) {
                int answer = 0;
                if (stackleft.isEmpty()) {//栈为空的情况
                    stackleft.push(new Node4E(heights[i], i+1));
                } else {
                    while (!stackleft.isEmpty() && stackleft.peek().value <= heights[i]) {
                        answer= stackleft.pop().index;
                    }
                    stackleft.push(new Node4E(heights[i], i+1));
                }
                leftAns[i] = answer;

            }

            for (int i = n-1; i >= 0; i--) {
                int answer = 0;
                if (stackright.isEmpty()) {//栈为空的情况
                    stackright.push(new Node4E(heights[i], i+1));
                } else {
                    while (!stackright.isEmpty() && stackright.peek().value <= heights[i]) {
                        answer= stackright.pop().index;
                    }
                    stackright.push(new Node4E(heights[i], i+1));
                }
                rightAns[i] = answer;
            }
            System.out.println("Case " + t + ":");
            for (int i = 0; i < n; i++) {
                System.out.print(leftAns[i] + " ");
                System.out.println(rightAns[i]);
            }



        }
    }
}
class Node4E {
    int value;
    int index;
    Node4E(int value, int index) {
        this.value = value;
        this.index = index;
    }
}
class NodeStack4E {
    Node4E[] node4ES;
    int top;
    NodeStack4E(int n) {
        node4ES = new Node4E[n];
        top = -1;
    }
    void push(Node4E node4E) {
        node4ES[++top] = node4E;
    }
    Node4E pop() {
        return node4ES[top--];
    }
    Node4E peek() {
        return node4ES[top];
    }
    boolean isEmpty() {
        return top == -1;
    }
}
