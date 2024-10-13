package lab2;

public class findMinorMaxindexinazrray {
    public static void main(String[] args) {

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
