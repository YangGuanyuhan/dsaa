import javax.swing.*;
import java.io.PushbackInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();  // 读取整个输入字符串
        int a = input.length();
        stack s = new stack();
        int ans=0;
        s.push(0);
        for (char ch : input.toCharArray()) {
            if (ch == '(') {
                s.push(0);
            } else {
                if (s.top() == 0) {
                   s.pop();
                   int x = s.top();
                    s.setTop(x + 1);
                } else {
                    int x = s.pop();
                    int y = s.top();
                    s.setTop(y+ x * 2);
                    ans = s.top();
                }

            }

        }
        System.out.println(ans);
    }
}

class stack {
    int[] data;
    int top;

    stack() {
        data = new int[100010];
        for (int i = 0; i < data.length; i++) {
            data[i] = -1;

        }
        top = -1;
    }

    void push(int x) {
        data[++top] = x;
    }

    int pop() {
        return data[top--];
    }

    int top() {
        return data[top];
    }

    void setTop(int x) {
        data[top] = x;
    }

    boolean empty() {
        return top == -1;
    }
}