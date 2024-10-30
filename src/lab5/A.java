package lab5;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();  // 测试用例数
        for (int t = 0; t < T; t++) {
            String input = in.next();  // 读取整个输入字符串
            int a = input.length();
            System.out.println((1+a)*a/2);

        }

    }
}