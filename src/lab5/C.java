package lab5;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String pattern = in.next();
        int[][] transitionFunction = transition(pattern);
        //打印二维数组
        for (int i = 0; i < transitionFunction.length; i++) {
            for (int j = 0; j < transitionFunction[i].length; j++) {
                System.out.print(transitionFunction[i][j] + " ");
            }
            System.out.println();
        }


    }

    private static int[][] transition(String pattern) {
        int m = pattern.length();
        int[][] transitionFunction = new int[m][26];
        //状态
        int x = 0;

        //initialize the transition function
        for (int q = 0; q < m; q++) {
            for (int a = 0; a < 26; a++) {
                transitionFunction[q][a] = 0;
            }
        }
        //进行一个初始化操作
        int pointer = 0;
        for (char ch : pattern.toCharArray()) {
            transitionFunction[pointer][ch - 'a'] = pointer + 1;
            pointer++;
        }
        //开始根据状态填写方格
        char[] patternArray = pattern.toCharArray();
        for (int i = 1; i < pattern.length(); i++) {
            char ch = patternArray[i];
            for (int j = 0; j < 26; j++) {
                if (transitionFunction[i][j] == 0) {
                    transitionFunction[i][j] = transitionFunction[x][j];
                }

            }
            x=transitionFunction[x][ch-'a'];

        }
        return transitionFunction;


    }



}

