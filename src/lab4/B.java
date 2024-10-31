package lab4;

import java.util.Scanner;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();  // 读取整个输入字符串
        int a = input.length();
        stackB s = new stackB();
        int ans=0;
        s.push(0);
        for (char ch : input.toCharArray()) {
            if (ch == '(') {
                s.push(0);
            } else {
                if (s.top() == 0) {
                    s.pop();
                    int x = s.top();
                    x++;
                    x=x%514329;
                    s.setTop(x);
                } else {
                    int x = s.pop();
                    int y = s.top();
                    x=x*2;
                    x=x%514329;
                    y=y+x;
                    y=y%514329;
                    s.setTop(y);
                }

            }

        }

        ans=s.top();
        System.out.println(ans);
    }
}

class stackB {
    int[] data;
    int top;

    stackB() {
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