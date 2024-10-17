package lab1;

import java.util.Scanner;

public class testA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testNumber = in.nextInt();
        int[] array = new int[testNumber];
        for (int i = 0; i < testNumber; i++) {
            array[i] = in.nextInt();
        }
        int left = 0;
        int right = testNumber - 1;
        int loopbNumber = in.nextInt();
        for (int i = 0; i < loopbNumber; i++) {

            if (binarysearch(in, left, right, array)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }

    private static boolean binarysearch(Scanner in, int left, int right, int[] array) {
        int mid;
        int target = in.nextInt();
        while (left <= right) {
            mid = left + (right - left) / 2;
            
            if (array[mid] == target) {
                return true;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
