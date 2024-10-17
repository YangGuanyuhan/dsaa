package lab2;

import java.util.Scanner;

public class testA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testtime = in.nextInt();
        for (int o = 0; o < testtime; o++) {


            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            bubbleSort(arr);
            if (n >= 4) {  // 确保数组长度至少为4
                if (arr[n - 1 - 2] == arr[n - 1 - 1] || arr[n - 1 - 2] == arr[n - 4]) {
                    System.out.println("wa");
                } else {
                    System.out.println(arr[n - 3]);
                }
            } else {
                if (arr[n - 1 - 2] == arr[n - 1 - 1] ) {
                    System.out.println("wa");
                } else {
                    System.out.println(arr[n - 3]);
                }

            }

        //    System.out.println(Arrays.toString(arr));

        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i -1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];//swap
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}



