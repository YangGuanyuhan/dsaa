package lab5;

import java.util.Scanner;

public class F {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 读取替换密码表
        String[] cipherTable = sc.nextLine().split(" ");
        // 读取字符串 S
        String S = sc.nextLine();
        StringBuilder result = new StringBuilder();
        result.append(S);
        for (char ch : S.toCharArray()) {
            if (ch == ' ') {
                result.append(' ');
            } else {
                result.append(cipherTable[ch - 'a']);
            }
        }
        int n = S.length();
        int[] next = computeNext(result.toString());

        int j = next[2 * n - 1];
        //int ans = next[j - 1];
        while (j > n / 2) {
            j = next[j - 1];
            // ans = next[j - 1];
        }
        System.out.println(n - j);


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
                next[i] = j + 1;
                i++;
                j++;
            } else if (j != 0) {
                j = next[j - 1];
            } else {
                next[i] = 0;
                i++;
            }


        }
        return next;
    }
}
