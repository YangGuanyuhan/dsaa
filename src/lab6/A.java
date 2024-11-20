package lab6;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long t = in.nextLong();
        for (long i = 0; i < t; i++) {
            long n = in.nextLong();
            long k = in.nextLong();
            long left = n;
            long layer = 0;
            long layernodes = 1;
            while (left > layernodes) {
                left -= layernodes;
                layernodes *= k;
                layer++;
            }
            long opop = layernodes - left;
            long ans = left + opop / k;
            System.out.println(ans);
        }
    }
}

