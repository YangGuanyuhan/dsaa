package lab2;

import java.util.Scanner;

public class testF3_0 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[][] aLessOrEqualb = new int[n][2];
            int[][] aGreaterb = new int[n][2];

            int lessOrEqualCount = 0;  // 蓝珠数量 <= 红珠数量的计数
            int greaterCount = 0;      // 蓝珠数量 > 红珠数量的计数

            // 读取每个珠串的蓝珠数量和红珠数量
            for (int j = 0; j < n; j++) {
                int a = in.nextInt();  // 蓝珠数量
                int b = in.nextInt();  // 红珠数量
                if (a <= b) {
                    aLessOrEqualb[lessOrEqualCount][0] = a;
                    aLessOrEqualb[lessOrEqualCount][1] = b;
                    lessOrEqualCount++;
                } else {
                    aGreaterb[greaterCount][0] = a;
                    aGreaterb[greaterCount][1] = b;
                    greaterCount++;
                }
            }

            mergeSort(aLessOrEqualb, 0, lessOrEqualCount, true);
            mergeSort(aGreaterb, 0, greaterCount, false);

            int[][] combinedArray = new int[lessOrEqualCount + greaterCount][2];

            // 合并排序后的数组
            for (int k = 0; k < lessOrEqualCount; k++) {
                combinedArray[k] = aLessOrEqualb[k];
            }
            for (int k = 0; k < greaterCount; k++) {
                combinedArray[lessOrEqualCount + k] = aGreaterb[k];
            }

            // 计算最大魔法能量
            int magicPower = 0;
            for (int j = 0; j < combinedArray.length - 1; j++) {
                if (combinedArray[j][1] <= combinedArray[j + 1][0]) {  // 如果当前红珠数量 <= 下一个蓝珠数量
                    magicPower += combinedArray[j][1];
                } else {
                    magicPower += combinedArray[j + 1][0];
                    combinedArray[j + 1][1] += (combinedArray[j][1] - combinedArray[j][0]);
                }
            }
            System.out.println(magicPower);
        }
        in.close();
    }

    // 归并排序
    public static void mergeSort(int[][] arr, int left, int right, boolean ascending) {
        if (right - left <= 1) return; // 只有一个元素，返回

        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid, ascending);
        mergeSort(arr, mid, right, ascending);
        merge(arr, left, mid, right, ascending);
    }

    public static void merge(int[][] arr, int left, int mid, int right, boolean ascending) {
        int[][] temp = new int[right - left][2];
        int i = left, j = mid, k = 0;

        while (i < mid && j < right) {
            if (ascending) {
                if (arr[i][0] < arr[j][0] || (arr[i][0] == arr[j][0] && arr[i][1] >= arr[j][1])) {
                    temp[k++] = arr[i++];
                } else {
                    temp[k++] = arr[j++];
                }
            } else {
                if (arr[i][1] > arr[j][1] || (arr[i][1] == arr[j][1] && arr[i][0] <= arr[j][0])) {
                    temp[k++] = arr[i++];
                } else {
                    temp[k++] = arr[j++];
                }
            }
        }

        while (i < mid) temp[k++] = arr[i++];
        while (j < right) temp[k++] = arr[j++];

        System.arraycopy(temp, 0, arr, left, temp.length);
    }

    public static void print2DArray(int[][] array) {
        if (array == null || array.length == 0) {
            System.out.println("Array is empty or null.");
            return;
        }

        for (int[] row : array) {
            for (int value : row) {
                System.out.print(value + "\t"); // 使用制表符（\t）分隔
            }
            System.out.println(); // 换行
        }
    }
}
