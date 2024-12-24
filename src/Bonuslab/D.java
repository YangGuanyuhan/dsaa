package Bonuslab;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] predictor = new int[n];
            for (int j = 0; j < n; j++) {
                predictor[j] = in.nextInt();
            }
            int[] nextRise = new int[n];
            for (int j = 0; j < n; j++) {
                nextRise[j] = -1;
            }
            //维护一个单调递减栈
            stack s = new stack(n);
            for (int j = n - 1; j >= 0; j--) {
                while (!s.isEmpty() && predictor[j] >= predictor[s.top()]) {
                    s.pop();
                }
                if (!s.isEmpty()) {
                    nextRise[j] = s.top();
                }
                s.push(j);
            }
            int q = in.nextInt();
            for (int j = 0; j < q; j++) {
                int k = in.nextInt();
                k=k-1;
                int ans = -1;
                if (nextRise[k] != -1) {
                    ans = nextRise[k]-k;
                }
                System.out.println(ans);

            }


        }

    }
}

class stack {
    int[] stack;
    int top;

    public stack(int n) {
        stack = new int[n];
        top = 0;
    }

    public void push(int x) {
        stack[top++] = x;
    }

    public int pop() {
        return stack[--top];
    }

    public int top() {
        return stack[top - 1];
    }

    public boolean isEmpty() {
        return top == 0;
    }
}
