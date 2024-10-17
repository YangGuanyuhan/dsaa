package lab1;

import java.util.Scanner;

public class demo3gpt {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = {1,1,3,3,3,3};
        int target1 = in.nextInt();
        int target2 = in.nextInt();
        System.out.println(findMax(arr, target1));
       System.out.println(findMin(arr, target2));
    }

    public static int findMin(int[] arr, int n) {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left <right) {
            mid = left + (right - left) / 2;
            if (arr[mid] >= n) {
                right = mid;
            } else {
                left = mid+1 ;
            }
        }
        return  left;
    }

    public static int findMax(int[] arr, int n) {
        int left = 0;
        int right = arr.length - 1;
        int mid;

        while (left < right) {
            mid = left + (right - left+1) / 2;
            if (arr[mid] <= n) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }


}
