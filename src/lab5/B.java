package lab5;


import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 读取输入
        String pattern = in.next().trim();
        int[] nextArray = computeNext(pattern);
    }

    private static int[] computeNext(String pattern) {
        int n = pattern.length();
        char[] p = pattern.toCharArray();
        int[] next = new int[n];
        int i = 1;
        int j = 0;
        next[0] = 0;
        while (i < n) {
            if (p[i] == p[j]) {
            }


        }
        return next;
    }
}