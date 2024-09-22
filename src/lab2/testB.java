package lab2;

import java.util.Scanner;

public class testB {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int testNumber = in.nextInt();
        for (int i = 0; i < testNumber; i++) {


            long n = in.nextLong();
            long m = 1000000007;
            long answer = n * (n + 1) / 2;
            answer = answer % m;
            answer = answer * answer;
            answer = answer % m;
            System.out.println(answer);
        }

    }
}
