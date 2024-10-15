package lab3;

import java.sql.SQLOutput;
import java.util.Scanner;

public class testc {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        quickSort(arr, 0, n - 1);


        System.out.println(findTripleNumber(arr, m));
    }

    private static int findTripleNumber(int[] arr, int m) {
        int pointer1 = 0;
        int pointer2 = 1;
        int pointer3 = 2;
        int stillLeft =0;
        int count = 0;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length-1; j++) {
                stillLeft = m - arr[i] - arr[j];
                pointer3 = j + 1;
                count += findMax(arr, stillLeft, pointer3, arr.length - 1) - findMin(arr, stillLeft, pointer3, arr.length - 1) + 1;
                System.out.println( "count "+ count);
                System.out.println("pointer1 "+pointer1);
                System.out.println("pointer2 "+pointer2);
                System.out.println("pointer3 "+pointer3);
                System.out.println("stillleft: "+stillLeft);
                System.out.println("findmax  "+findMax(arr, stillLeft, pointer2, arr.length - 1));
                System.out.println("findmin  "+findMin(arr, stillLeft, pointer2, arr.length - 1));

                System.out.println("-----------------");



            pointer2 ++;
            }
            pointer1++;
            pointer2 = pointer1 + 1;
        }


    return count;
    }
    public static int findMin(int[] arr, int n,int left,int right) {
        right = arr.length - 1;
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

    public static int findMax(int[] arr, int n,int left,int right) {

        right = arr.length - 1;
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
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            // Recursively sort elements before and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Partition method to find the pivot and rearrange elements
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];  // Pivot element (last element in this case)
        int i = (low - 1);  // Index of smaller element

        for (int j = low; j < high; j++) {
            // If the current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++;

                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i + 1] with arr[high] (or the pivot element)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;  // Return the partitioning index
    }

}
