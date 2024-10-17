package lab0;

import java.util.Scanner;

public class lab1test4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {


            extracted(in);
        }

    }

    private static void extracted(Scanner in) {
        int n = in.nextInt();
        int[] arr1 = new int[n + 1];
        int[] difference = new int[n + 1];
        difference[0] = Integer.MIN_VALUE;
        difference[n] = Integer.MIN_VALUE;

        for (int i = 1; i < n + 1; i++) {
            arr1[i] = in.nextInt();
        }
        int min = arr1[n];
        for (int i = n; i > 1; i--) {
            difference[i - 1] = arr1[i - 1] - min;
            if (arr1[i - 1] < min) {
                min = arr1[i - 1];
            }
        }
        int max = difference[0];
        for (int i = 1; i < difference.length; i++) {
            if (difference[i] > max) {
                max = difference[i];
            }
        }

        System.out.println(max);
    }
}
