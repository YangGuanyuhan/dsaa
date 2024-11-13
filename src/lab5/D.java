package lab5;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        for (int i = 0; i < t; i++) {
            String necklace = in.nextLine();
            int n = necklace.length();
            int ans = 0;
            char[] lacearray = necklace.toCharArray();
            int[] next = computeNext(necklace);
            if (next[n - 1] == 0) {
                ans = n;

            } else if (n % (n - next[n - 1]) == 0) {
                ans = 0;

            } else {
                int temp = n % (n - next[n - 1]);
                ans = n - next[n - 1] - temp;
            }
            System.out.println(ans);

        }


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
