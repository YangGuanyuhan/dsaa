package lab8;

import java.util.Scanner;


public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            //创建邻接矩阵
            int[][] graph = new int[n][n];
            for (int j = 0; j < m; j++) {
                int u = in.nextInt();
                int v = in.nextInt();
                graph[u-1][v-1] = 1;
            }
            //输出邻接矩阵
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    System.out.print(graph[j][k] + " ");
                }
                System.out.println();
            }


        }
    }
}