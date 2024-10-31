package lab4;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            String str = in.next();

            if (bracketmatching(str, n)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }


        }
    }

    private static boolean bracketmatching(String str, int n) {
        stackA s = new stackA(n);
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{') {
                s.push(str.charAt(i));
            } else {
                if (s.isEmpty()) {
                    return false;
                }
                char x;
                switch (str.charAt(i)) {
                    case ')':
                        x = s.pop();
                        if (x == '{' || x == '[') {
                            return false;
                        }
                        break;
                    case '}':
                        x = s.pop();
                        if (x == '(' || x == '[') {
                            return false;
                        }
                        break;
                    case ']':
                        x = s.pop();
                        if (x == '(' || x == '{') {
                            return false;
                        }
                        break;
                }




            }
        }
        if (s.isEmpty()) {
            return true;
        } else {
            return false;
        }


    }
}



class stackA {
    int top;
    char[] a;

    stackA(int n) {
        a = new char[n];
        top = 0;
    }

    void push(char x) {
        a[top] = x;
        top++;
    }

    char pop() {
        top--;
        return a[top];
    }



    boolean isEmpty() {
        return top == 0;
    }
}
