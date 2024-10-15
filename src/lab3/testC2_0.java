package lab3;

import java.util.Scanner;

public class testC2_0 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long m = in.nextLong();
        long arr[] = new long[(int) n];  // Casting n to int for array size
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextLong();
        }
        quickSort(arr, 0, (int) n - 1);  // Casting n to int for method parameters

        System.out.println(findTripleNumber(arr, m));
    }

    private static long findTripleNumber(long[] arr, long m) {
        long count = 0;

        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                long stillLeft = m - arr[i] - arr[j];
                if (stillLeft < 0) {
                    break;
                }
                int leftIndex = j + 1;
                int rightIndex = arr.length - 1;

                int maxIndex = findMax(arr, stillLeft, leftIndex, rightIndex);
                int minIndex = findMin(arr, stillLeft, leftIndex, rightIndex);

                if (maxIndex >= minIndex && maxIndex != -1 && minIndex != -2) {
                    count += maxIndex - minIndex + 1;
                }
            }
        }

        return count;
    }

    public static int findMax(long[] arr, long n, int left, int right) {
        int mid;

        while (left < right) {
            mid = left + (right - left + 1) / 2;
            if (arr[mid] <= n) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return (arr[left] <= n) ? left : -1;
    }

    public static int findMin(long[] arr, long n, int left, int right) {
        int mid;

        while (left < right) {
            mid = left + (right - left) / 2;
            if (arr[mid] >= n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (arr[left] >= n) ? left : -2;
    }

    public static void quickSort(long[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(long[] arr, int low, int high) {
        long pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                long temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        long temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}