package lab2;

import java.util.Scanner;

public class testF {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[][] aLessOrEqualb = new int[n][2];
            int[][] aGreaterb = new int[n][2];

            int lessOrEqualCount = 0;  // 记录蓝珠 <= 红珠的数量
            int greaterCount = 0;      // 记录蓝珠 > 红珠的数量

            // 读取每个珠串的蓝珠数量 ai 和红珠数量 bi
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
            bubbleSortaincreasing(aLessOrEqualb);
            bubbleSortbdecreasing(aGreaterb);
            int[][] combinedArray = new int[lessOrEqualCount + greaterCount][2];


            for (int k = 0; k < lessOrEqualCount; k++) {
                combinedArray[k] = aLessOrEqualb[k];
            }


            for (int k = 0; k < greaterCount; k++) {
                combinedArray[lessOrEqualCount + k] = aGreaterb[k];
            }
            int magicpower = 0;
            int left = 0;
            for (int j = 0; j < combinedArray.length - 1; j++) {
                if (combinedArray[j][1] <= combinedArray[j + 1][0]) {//如果当前珠串的红珠数量小于等于下一个珠串的蓝珠数量
                    magicpower += combinedArray[j][1];

                }else {
                    magicpower += combinedArray[j][0];
                    combinedArray[j + 1][1]+=combinedArray[j][1]-combinedArray[j][0];


                }
            }
            System.out.println(magicpower);


            }
        }

        private static void bubbleSortbdecreasing ( int[][] arr){

            int n = arr.length;

            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (arr[j][1] < arr[j + 1][1]) {
                        int[] temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }

        }

        public static void bubbleSortaincreasing ( int[][] arr){
            int n = arr.length;

            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (arr[j][0] > arr[j + 1][0]) {
                        int[] temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }


    }

