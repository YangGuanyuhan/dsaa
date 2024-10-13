package lab2;

import java.util.Scanner;

public class testC2_0 {
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
            int min = findMin(arr, target1);  // 找到第一个大于target1的位置
            int max = findMax(arr, target2);  // 找到最后一个小于target2的位置
            System.out.println(min + " " + max);

            // 判断是否存在满足条件的元素
            if (min == -1 || max == -1 || max <= min) {
                System.out.println("NO");
            } else {
                System.out.println("YES " + (max - min));
            }
        }

        in.close();
    }

    // 找到第一个大于target1的索引
    public static int findMin(int[] arr, int target1) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left < arr.length ? left : -1;
    }


    public static int findMax(int[] arr, int target2) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target2) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right >= 0 ? right : -1;
    }
}

