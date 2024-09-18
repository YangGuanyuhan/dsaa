package lab1;

import java.util.Scanner;

public class lab1testE {
    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        char[][] cuboid = new char[(b + c) * 2 + 1][(a + b) * 2 + 1];
        for (int i = 0; i < (b + c) * 2 + 1; i++) {
            for (int j = 0; j < (a + b) * 2 + 1; j++) {
                cuboid[i][j] = '.';
            }
        }
//        printTop(b, a, cuboid);
//
//        printFront(c, a, cuboid, b);

        printSide(a,b, c, cuboid);




        print2DCharArray(cuboid);


    }
    private static void printSide(int a,int b, int c, char[][] cuboid) {
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < c; j++) {
                cuboid[2*b+2*j][2*i+2*a] = '+';
                cuboid[2*b+2*j+1][2*i+2*a] = '|';
                cuboid[2*b+2*j][2*i+2*a] = '+';
            }
            for (int j = 0; j < c; j++) {
                cuboid[2*j+2*b][2*i+2*a] = '/';
                cuboid[2*j+2*b][2*i+2*a] = '.';
                cuboid[2*j+2*b][2*i+2*a] = '/';
            }
        }

    }

    private static void printFront(int c, int a, char[][] cuboid, int b) {
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < a; j++) {
                cuboid[2 * b + 2 * i][ 2 * j] = '+';
                cuboid[2 * b + 2 * i][ 2 * j + 1] = '-';
                cuboid[2 * b + 2 * i][(2* a)] = '+';
            }
            for (int j = 0; j < a; j++) {
                cuboid[2 * b + 2 * i + 1][ 2 * j] = '|';
                cuboid[2 * b + 2 * i + 1][ 2 * j + 1] = '.';
                cuboid[2 * b + 2 * i + 1][(2* a)] = '|';
            }
        }
        for (int j = 0; j < a; j++) {
            cuboid[(b + c) * 2][ 2 * j] = '+';
            cuboid[(b + c) * 2][ 2 * j + 1] = '-';
            cuboid[(b + c) * 2][(2* a)] = '+';


        }
    }



    private static void printTop(int b, int a, char[][] cuboid) {
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < a; j++) {
                cuboid[2*i][2 * b + 2 * j-2*i] = '+';
                cuboid[2*i][2 * b + 2 * j + 1-2*i] = '-';
                cuboid[2*i][(a + b) * 2-2*i] = '+';
            }
            for (int j = 0; j < a; j++) {
                cuboid[2*i+1][2 * b + 2 * j-1-2*i] = '/';
                cuboid[2*i+1][2 * b + 2 * j + 1-1-2*i] = '.';
                cuboid[2*i+1][(a + b) * 2-1-2*i] = '/';
            }
        }
    }

    public static void print2DCharArray(char[][] array) {
        for (char[] row : array) {
            System.out.println(new String(row));
        }
    }
}
