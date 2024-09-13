package lab1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class lab1test3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//重复的数字
        int[] bucket = new int[35];
        for (int l = 0; l <n ; l++) {
            for (int i = 0; i < 13; i++) extracted(in, bucket);
            for (int i = 0; i < 35; i++) {
                while (bucket[i] > 0) {
                    printSp(i);
                    System.out.print(" ");
                    bucket[i]--;
                }

            }
            System.out.println();
        }
    }

    public static void printSp(int i) {
        switch (i) {
            case 1:
                System.out.print("W1");
                break;
            case 2:
                System.out.print("W2");
                break;
            case 3:
                System.out.print("W3");
                break;
            case 4:
                System.out.print("W4");
                break;
            case 5:
                System.out.print("W5");
                break;
            case 6:
                System.out.print("W6");
                break;
            case 7:
                System.out.print("W7");
                break;
            case 8:
                System.out.print("W8");
                break;
            case 9:
                System.out.print("W9");
                break;
            case 10:
                System.out.print("T1");
                break;
            case 11:
                System.out.print("T2");
                break;
            case 12:
                System.out.print("T3");
                break;
            case 13:
                System.out.print("T4");
                break;
            case 14:
                System.out.print("T5");
                break;
            case 15:
                System.out.print("T6");
                break;
            case 16:
                System.out.print("T7");
                break;
            case 17:
                System.out.print("T8");
                break;
            case 18:
                System.out.print("T9");
                break;
            case 19:
                System.out.print("Y1");
                break;
            case 20:
                System.out.print("Y2");
                break;
            case 21:
                System.out.print("Y3");
                break;
            case 22:
                System.out.print("Y4");
                break;
            case 23:
                System.out.print("Y5");
                break;
            case 24:
                System.out.print("Y6");
                break;
            case 25:
                System.out.print("Y7");
                break;
            case 26:
                System.out.print("Y8");
                break;
            case 27:
                System.out.print("Y9");
                break;
            case 28:
                System.out.print("E");
                break;
            case 29:
                System.out.print("S");
                break;
            case 30:
                System.out.print("W");
                break;
            case 31:
                System.out.print("N");
                break;
            case 32:
                System.out.print("B");
                break;
            case 33:
                System.out.print("F");
                break;
            case 34:
                System.out.print("Z");
                break;
            default:
                System.out.print("Invalid input");
                break;
        }
    }

    private static void extracted(Scanner in, int[] bucket) {
        switch (in.next()) {
            case "W1":
                bucket[1]++;
                break;
            case "W2":
                bucket[2]++;
                break;
            case "W3":
                bucket[3]++;
                break;
            case "W4":
                bucket[4]++;
                break;
            case "W5":
                bucket[5]++;
                break;
            case "W6":
                bucket[6]++;
                break;
            case "W7":
                bucket[7]++;
                break;
            case "W8":
                bucket[8]++;
                break;
            case "W9":
                bucket[9]++;
                break;
            case "T1":
                bucket[10]++;
                break;
            case "T2":
                bucket[11]++;
                break;
            case "T3":
                bucket[12]++;
                break;
            case "T4":
                bucket[13]++;
                break;
            case "T5":
                bucket[14]++;
                break;
            case "T6":
                bucket[15]++;
                break;
            case "T7":
                bucket[16]++;
                break;
            case "T8":
                bucket[17]++;
                break;
            case "T9":
                bucket[18]++;
                break;
            case "Y1":
                bucket[19]++;
                break;
            case "Y2":
                bucket[20]++;
                break;
            case "Y3":
                bucket[21]++;
                break;
            case "Y4":
                bucket[22]++;
                break;
            case "Y5":
                bucket[23]++;
                break;
            case "Y6":
                bucket[24]++;
                break;
            case "Y7":
                bucket[25]++;
                break;
            case "Y8":
                bucket[26]++;
                break;
            case "Y9":
                bucket[27]++;
                break;
            case "E":
                bucket[28]++;
                break;
            case "S":
                bucket[29]++;
                break;
            case "W":
                bucket[30]++;
                break;
            case "N":
                bucket[31]++;
                break;
            case "B":
                bucket[32]++;
                break;
            case "F":
                bucket[33]++;
                break;
            case "Z":
                bucket[34]++;
                break;
        }
    }

}
