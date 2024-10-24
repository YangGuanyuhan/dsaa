package lab3;

import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int[] h = new int[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            h[i] = Integer.MAX_VALUE;
            for (int j =  1; j < n; j++) {
                h[i] = Math.min(h[i], Math.abs(a[j] - a[i]));
            }
        }

        for (int i = 0; i < n - 1; i++) {
            System.out.print(h[i] + " ");
        }
        System.out.println();

    }
}
