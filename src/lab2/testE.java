package lab2;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class testE {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        int tempArr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(mergeSort(arr, tempArr, 0, n - 1));
    }

    public static long mergeSort(int[] array, int[] tempArray, int left, int right) {
        long count = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;
            count += mergeSort(array, tempArray, left, mid);
            count += mergeSort(array, tempArray, mid + 1, right);
            count += merge(array, tempArray, left, mid, right);

        }
        return count;
    }

    public static long merge(int[] array, int[] tempArray, int left, int mid, int right) {
        long count = 0;
        for (int i = left; i <= right; i++) {
            tempArray[i] = array[i];
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (tempArray[i] <= tempArray[j]) {
                array[k] = tempArray[i];
                i++;
            } else {
                array[k] = tempArray[j];

                count += (long) (mid - i + 1) * tempArray[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            array[k] = tempArray[i];
            i++;
            k++;
        }
        return count;

    }
}

