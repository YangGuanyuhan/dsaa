package lab2;

import java.util.Scanner;

public class testF2_0 {
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
            bubbleSortIncreasing(aLessOrEqualb, lessOrEqualCount);
            bubbleSortDecreasing(aGreaterb, greaterCount);

            int[][] combinedArray = new int[lessOrEqualCount + greaterCount][2];


            for (int k = 0; k < lessOrEqualCount; k++) {
                combinedArray[k] = aLessOrEqualb[k];
            }
            for (int k = 0; k < greaterCount; k++) {
                combinedArray[lessOrEqualCount + k] = aGreaterb[k];
            }
           print2DArray(combinedArray);
            System.out.println("----------------------------------");


            // 计算最大魔法能量
            int magicPower = 0;
            for (int j = 0; j < combinedArray.length - 1; j++) {
                if (combinedArray[j][1] <= combinedArray[j + 1][0]) {  // 如果当前红珠数量 <= 下一个蓝珠数量
                    magicPower += combinedArray[j][1];
                } else {
                    magicPower += combinedArray[j+1][0];
                    combinedArray[j + 1][1] += (combinedArray[j][1] - combinedArray[j][0]);
                }
            }
            System.out.println(magicPower);
        }
        in.close();
    }

    // 升序排列（蓝珠数量）
    public static void bubbleSortIncreasing(int[][] arr, int length) {
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j][0] > arr[j + 1][0]) {
                    int[] temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // 降序排列（红珠数量）
    public static void bubbleSortDecreasing(int[][] arr, int length) {
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j][1] < arr[j + 1][1]) {
                    int[] temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
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
