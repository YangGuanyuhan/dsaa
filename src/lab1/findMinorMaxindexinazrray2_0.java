package lab1;

public class findMinorMaxindexinazrray2_0 {
    public static void main(String[] args) {
        int arr[] = {1, 1, 3, 3, 3, 3,4,5, 5, 5, 5};

        System.out.println(findMin(arr, 0,2,arr.length-1));
        System.out.println(findMax(arr, 3,7,arr.length-1));

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
}
