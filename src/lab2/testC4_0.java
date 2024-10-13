package lab2;

import java.util.Scanner;

public class testC4_0 {

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int arrLength = in.nextInt();
            int testNumber = in.nextInt();
            int[] arr = new int[arrLength];


            for (int i = 0; i < arrLength; i++) {
                arr[i] = in.nextInt();
            }


            for (int i = 0; i < testNumber; i++) {
                int x = in.nextInt();
                int y = in.nextInt();

                int leftIndex = findFirstGreater(arr, x);
                int rightIndex = findFirstGreaterOrEqual(arr, y);

                // 计算在 (x, y) 之间的元素个数

                if (rightIndex - leftIndex <= 0) {
                    System.out.println("No");
                } else {
                    System.out.println("Yes " + (rightIndex - leftIndex));
                }
            }

            in.close();
        }


        public static int findFirstGreater(int[] arr, int n) {
            int left = 0;
            int right = arr.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] > n) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }


        public static int findFirstGreaterOrEqual(int[] arr, int n) {
            int left = 0;
            int right = arr.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] >= n) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }


