package lab4;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();  // 读取测试用例数量

        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();  // 读取每个测试用例的 n
            int[] array = new int[n];
            int[] arraymin = new int[n];
            int[] ans = new int[n];
            int ansIndex = 0; // 用于跟踪 ans 数组的有效元素数量

            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();  // 读取卡片顺序
            }
            for (int i = n - 1; i > -1; i--) {
                arraymin[i] = array[i];
                if (i < n - 1 && arraymin[i] > arraymin[i + 1]) {
                    arraymin[i] = arraymin[i + 1];
                }

            }

            stackD poker = new stackD(n);


            for (int i = 0; i < n; i++) {
                int answer = -1; // 默认值为

                if (poker.isEmpty()) {
                    poker.push(array[i]);
                    continue;
                }
                if (arraymin[i] < poker.peek()) {
                    poker.push(array[i]);
                    continue;
                }else {
                    if (array[i] > poker.peek()) {
                        answer = poker.peek();
                        poker.pop();
                        i--;
                    } else {
                        poker.push(array[i]);
                    }
                }
                ans[ansIndex++] = answer;
            }

            // 把栈中剩余的元素加入到 ans 中
            while (!poker.isEmpty()) {
                ans[ansIndex++] = poker.pop();
            }

            // 打印结果
            for (int i = 0; i < ansIndex; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println(); // 换行
        }
    }
}

class stackD {
    int[] stack;
    int top = -1;

    public stackD(int n) {
        stack = new int[n];
    }

    public void push(int x) {
        stack[++top] = x;
    }

    public int pop() {
        return stack[top--];
    }

    public int peek() {
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
