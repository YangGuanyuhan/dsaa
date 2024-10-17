package lab1;

import java.util.Scanner;

public class testC3_0 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arrLength = in.nextInt();  // 数组长度
        int testNumber = in.nextInt();  // 查询次数
        int[] arr = new int[arrLength];

        // 输入数组
        for (int i = 0; i < arrLength; i++) {
            arr[i] = in.nextInt();
        }

        // 处理每个查询
        for (int i = 0; i < testNumber; i++) {
            int target1 = in.nextInt();  // 查询的x
            int target2 = in.nextInt();  // 查询的y
            int min = findMax(arr, target1);  // 找到第一个大于target1的位置
            int max = findMin(arr, target2);  // 找到最后一个小于target2的位置
           // System.out.println(min + " " + max);
            if (binarysearch(target1, 0, arr.length - 1, arr)^ binarysearch(target2, 0, arr.length - 1, arr)) {
                if (max - min > 0) {
                    System.out.println("YES"+(max - min));
                } else {
                    System.out.println("NO");
                }
            } else if (binarysearch(target1, 0, arr.length - 1, arr) && binarysearch(target2, 0, arr.length - 1, arr)) {
                if (max - min - 2 > 0) {
                    System.out.println("YES"+(max - min - 2));
                } else {
                    System.out.println("NO");
                }
            } else {
               if (max - min +1> 0) {
                    System.out.println("YES"+(max - min+1));
                } else {
                    System.out.println("NO");
                }
            }



        }

        in.close();
    }


    public static int findMin(int[] arr, int n) {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (arr[mid] >= n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    public static int findMax(int[] arr, int n) {
        int left = 0;
        int right = arr.length - 1;
        int mid;

        while (left < right) {
            mid = left + (right - left + 1) / 2;
            if (arr[mid] <= n) {
                left = mid;
            } else {
                right = mid - 1;
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

