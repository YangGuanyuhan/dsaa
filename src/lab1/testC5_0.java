package lab1;

import java.util.Scanner;

public class testC5_0 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arrLength = in.nextInt();
        int testNumber = in.nextInt();
        int[] arr = new int[arrLength];


        for (int i = 0; i < arrLength; i++) {
            arr[i] = in.nextInt();
        }


        for (int i = 0; i < testNumber; i++) {
            int target1 = in.nextInt();
            int target2 = in.nextInt();
            int min = findMax(arr, target1);
            if (target1 >= arr[arrLength - 1]) min = Integer.MAX_VALUE;
            int max = findMin(arr, target2);
            if (target2 <= arr[0]) max = Integer.MIN_VALUE;

//            if (binarysearch(target1, 0, arr.length - 1, arr) ^ binarysearch(target2, 0, arr.length - 1, arr)) {
//                if (max - min > 0) {
//                    System.out.println("YES"+(max - min));
//                } else {
//                    System.out.println("NO");
//                }
//            } else if (binarysearch(target1, 0, arr.length - 1, arr) && binarysearch(target2, 0, arr.length - 1, arr)) {
//                if (max - min - 2 > 0) {
//                    System.out.println("YES"+(max - min - 2));
//                } else {
//                    System.out.println("NO");
//                }
//            } else {
//                if (max - min +1> 0) {
//                    System.out.println("YES"+(max - min+1));
//                } else {
//                    System.out.println("NO");
//                }
//            }

            if (max < min) System.out.println("NO");
            else System.out.println("YES " + (max - min + 1));

        }

        in.close();
    }


    public static int findMin(int[] arr, int n) {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left < right) {
            mid = left + (right - left + 1) / 2;
            if (arr[mid] >= n) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return right;
    }

    public static int findMax(int[] arr, int n) {
        int left = 0;
        int right = arr.length - 1;
        int mid;

        while (left < right) {
            mid = left + (right - left) / 2;
            if (arr[mid] <= n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
    private static boolean binarysearch(int target, int left, int right, int[] array) {
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return true;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}

