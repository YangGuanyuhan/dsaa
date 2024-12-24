package Bonuslab;


import java.util.Scanner;

public class I {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[][] aLessOrEqualb = new int[n][2];
            int[][] aGreaterb = new int[n][2];
            int total = 0;// 记录总共的珠串数量

            int lessOrEqualCount = 0;  // 蓝珠数量 <= 红珠数量的计数
            int greaterCount = 0;      // 蓝珠数量 > 红珠数量的计数

            // 读取每个珠串的蓝珠数量和红珠数量
            for (int j = 0; j < n; j++) {
                int a = in.nextInt();  // 蓝珠数量
                int b = in.nextInt();  // 红珠数量
                total += a + b;
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

            quickSort(aLessOrEqualb, 0, lessOrEqualCount - 1, true);
            quickSort(aGreaterb, 0, greaterCount - 1, false);

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
                    combinedArray[j + 1][1] += (combinedArray[j][1] - combinedArray[j+1][0]);
                }
            }
            System.out.println(total-magicPower*2);
        }
        in.close();
    }

    // 快速排序
    public static void quickSort(int[][] arr, int low, int high, boolean ascending) {
        if (low < high) {
            int pi = partition(arr, low, high, ascending);
            quickSort(arr, low, pi - 1, ascending);
            quickSort(arr, pi + 1, high, ascending);
        }
    }

    public static int partition(int[][] arr, int low, int high, boolean ascending) {
        int[] pivot = arr[high]; // 选择最后一个元素作为枢轴
        int i = (low - 1); // 小于枢轴的元素的索引

        for (int j = low; j < high; j++) {
            if (ascending) {
                if (arr[j][0] < pivot[0] || (arr[j][0] == pivot[0] && arr[j][1] >= pivot[1])) {
                    i++;
                    swap(arr, i, j);
                }
            } else {
                if (arr[j][1] > pivot[1] || (arr[j][1] == pivot[1] && arr[j][0] <= pivot[0])) {
                    i++;
                    swap(arr, i, j);
                }
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    public static void swap(int[][] arr, int i, int j) {
        int[] temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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

