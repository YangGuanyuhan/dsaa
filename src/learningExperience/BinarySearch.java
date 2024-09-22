package learningExperience;

public class BinarySearch {
    public static int binarySearch(int[] arr, int target, int left, int right) {
        // 基准情况：如果左边界大于右边界，表示未找到
        if (left > right) {
            return -1;
        }

        // 找中间元素
        int mid = left + (right - left) / 2;

        // 基准情况：找到目标值
        if (arr[mid] == target) {
            return mid;
        }

        // 递归调用：查找左半边或右半边
        if (arr[mid] > target) {
            return binarySearch(arr, target, left, mid - 1);
        } else {
            return binarySearch(arr, target, mid + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int result = binarySearch(arr, 6, 0, arr.length - 1);
        System.out.println(result);  // 输出 5，表示 6 在数组中的索引为5
    }
}
