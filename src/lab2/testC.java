package lab2;

import java.util.Scanner;

public class testC {
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
            int min = findMin(arr, target1);
            int max = findMax(arr, target2);
            System.out.println(min + " " + max);
            if (min == -1 && max == -1) {
                System.out.println("No");
            } else if (min == -1 || max == -1) {
                if (min == -1) {
                    if (max > 0) {
                        System.out.println("Yes " + (max ));
                    } else {
                        System.out.println("No");
                    }
                }
                if (max == -1) {
                    if (arr[arr.length - 1] - min - 1 > 0) {
                        System.out.println("Yes " + (arr[arr.length - 1] - min - 1));
                    } else {
                        System.out.println("No");
                    }
                }

            } else {
                if (max-min-1 <= 0) {
                    System.out.println("No");
                } else {
                    System.out.println("Yes " + (max - min - 1));
                }
            }


        }

    }
    public static int findMin(int[] arr, int n) {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (arr[mid] > n) {
                right = mid - 1;
            } else if (arr[mid] == n) {
                while (mid > 0 && arr[mid] == arr[mid - 1]) {
                    mid--;
                }
                return mid;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
    public static int findMax(int[] arr, int n) {
        int left = 0;
        int right = arr.length - 1;
        int mid;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (arr[mid] > n) {
                right = mid - 1;
            } else if (arr[mid] == n) {
                while (mid < arr.length - 1 && arr[mid] == arr[mid + 1]) {
                    mid++;
                }
                return mid;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

}



