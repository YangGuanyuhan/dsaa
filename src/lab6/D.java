package lab6;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int ans = 0;
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = in.nextInt();
            }
            for (int j = 0; j < n-1; j++) {
                int min1 = Integer.MAX_VALUE;
                int min1Index = -1;
                int min2 = Integer.MAX_VALUE;
                int min2Index = -1;
                for (int k = 0; k < n; k++) {
                    if (arr[k] < min1) {
                        min1 = arr[k];
                        min1Index = k;
                    }
                }
                for (int k = 0; k < n; k++) {
                    if (arr[k] < min2 && k != min1Index) {
                        min2 = arr[k];
                        min2Index = k;
                    }
                }
                ans += min1 + min2;
                arr[min1Index] = min1 + min2;
                arr[min2Index] = Integer.MAX_VALUE;



            }

            System.out.println(ans);
        }

    }
}