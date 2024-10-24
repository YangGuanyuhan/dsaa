package lab3;

import java.util.Arrays;
import java.util.Scanner;

public class E2_0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arrayoribinal = new int[n];
        for (int i = 0; i < n; i++) {
            arrayoribinal[i] = sc.nextInt();
        }
        //复制arrayoriginal
        int[] arraynew = Arrays.copyOf(arrayoribinal, arrayoribinal.length);
        for (int i = 0; i < arrayoribinal.length; i++) {


        }



    }
}

