package lab1;

import java.util.Scanner;

public class lab1test1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = input.nextInt();
        }
        int t = input.nextInt();
        int[] arr2 = new int[t];
        for (int i = 0; i < t; i++) {
            arr2[i] = input.nextInt();
        }
        for (int i = 0; i < t; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr1[j] == arr2[i]) {
                    count++;
                }
            }
            if (count == 0) {
                System.out.println("no");
            } else {
                System.out.println("yes");
            }


        }
    }
}

