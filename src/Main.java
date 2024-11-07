import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        String s2 = scanner.next();
        int ans = Math.min(s1.length(), s2.length());
        // 二分查找答案
        int left = 0;
        int right = ans;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;  // 中间偏大
            if (hashcheck(mid, s1, s2)) {
                left = mid;  // 找到更大的长度
            } else {
                right = mid - 1;  // 找不到则缩小范围
            }
        }
        System.out.println(left);  // 输出最长公共子串的长度


    }

    private static boolean hashcheck(int ans, String s1, String s2) {
        //创建s1的hash值
        long[] hash1 = new long[s1.length() - ans + 1];
        hash1[0] = hash(s1.substring(0, ans));
        for (int i = 1; i < s1.length() - ans + 1; i++) {
            hash1[i] = (hash1[i - 1] - s1.charAt(i - 1) * pow(139, ans - 1)) + s1.charAt(i + ans - 1);
        }
        mergeSort(hash1);
        //创建s2的哈希值
       long[] hash2 = new long[s2.length() - ans + 1];
        hash2[0] = hash(s2.substring(0, ans));
        for (int i = 1; i < s2.length() - ans + 1; i++) {
            hash2[i] = (hash2[i - 1] - s2.charAt(i - 1) * pow(139, ans - 1)) + s2.charAt(i + ans - 1);
        }

        //对于s2的hash值在hash1中二分查找
        for (int i = 0; i < hash2.length; i++) {
            int left = 0;
            int right = hash1.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (hash1[mid] == hash2[i]) {
                    return true;
                } else if (hash1[mid] < hash2[i]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;

    }

    private static long hash(String s) {
        long hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash = hash * 139 + s.charAt(i);
        }
        return hash;
    }

    private static long pow(int a, int b) {
        long ans = 1;
        for (int i = 0; i < b; i++) {
            ans *= a;
        }
        return ans;
    }

    public static void mergeSort(long[] array) {
        if (array.length < 2) {
            return; // Base case: array is already sorted
        }

        int mid = array.length / 2;

        // Split the array into two halves
        long[] left = new long[mid];
        long[] right = new long[array.length - mid];

        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, array.length - mid);

        // Recursively sort both halves
        mergeSort(left);
        mergeSort(right);

        // Merge the sorted halves
        merge(array, left, right);
    }

    private static void merge(long[] array, long[] left, long[] right) {
        int i = 0, j = 0, k = 0;

        // Merge the two arrays into the original array
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        // Copy any remaining elements from the left array
        while (i < left.length) {
            array[k++] = left[i++];
        }

        // Copy any remaining elements from the right array
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

}

