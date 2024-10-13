package lab2;

import java.util.Scanner;

public class testD {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long m = in.nextLong();
        long answer = 1;
        if (n == 0) {

            System.out.println(1%m);
            return;
        }
        if (n>0&&n<= 2) {
            answer=n%m;
            System.out.println(answer);
            return;
        }
        if (n >= 4) {
            System.out.println(0);
            return;
        }
        for (long i = 2; i <= 720; i++) {
            answer = (answer * i%m) % m;

        }
        System.out.println(answer);
        return;
    }
}
