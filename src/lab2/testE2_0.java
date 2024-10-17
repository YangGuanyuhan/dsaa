package lab2;

import java.util.Scanner;

public class testE2_0 {
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
        long cost = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;
            cost += mergeSort(array, tempArray, left, mid);
            cost += mergeSort(array, tempArray, mid + 1, right);
            cost += merge(array, tempArray, left, mid, right);

        }
        return cost;
    }

    public static long merge(int[] array, int[] tempArray, int left, int mid, int right) {
        long cost = 0;
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
                cost += (long) (mid - i + 1) * tempArray[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            array[k] = tempArray[i];
            i++;
            k++;
        }

        return cost;
    }
}
