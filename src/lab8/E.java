package lab8;

import java.util.Scanner;

public class E {
    public static int sum = 0;
    public static int historySum = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt(); // 矩阵的行数
            int m = in.nextInt(); // 矩阵的列数
            int[][] matrix = new int[n + 2][m + 2];
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= m; k++) {
                    matrix[j][k] = in.nextInt();
                }
            }
            // 设置外面的一圈为 -1
            for (int j = 0; j < m + 2; j++) {
                matrix[0][j] = -1;
                matrix[n + 1][j] = -1;
            }
            for (int j = 0; j < n + 2; j++) {
                matrix[j][0] = -1;
                matrix[j][m + 1] = -1;
            }
            // 设置一个状态矩阵，表示有没有选，0 表示没选，1 表示选了
            int[][] state = new int[n + 2][m + 2];
            dfs(matrix, state, 1, 1, n, m);
            System.out.println(historySum);
            // 重置全局变量，准备处理下一组数据
            sum = 0;
            historySum = 0;
        }
    }

    public static void dfs(int[][] matrix, int[][] state, int x, int y, int n, int m) {
        if (x > n || y > m) return; // 如果超出矩阵边界，终止递归

        // 如果当前可选
        if (canSelect(matrix, state, x, y)) {
            state[x][y] = 1;
            sum += matrix[x][y];
            historySum = Math.max(historySum, sum);

            // 递归处理下一个位置
            int[] next = getNextPosition(x, y, n, m);
            dfs(matrix, state, next[0], next[1], n, m);

            // 回溯
            state[x][y] = 0;
            sum -= matrix[x][y];
        }

        // 如果当前未选，直接递归下一个位置
        int[] next = getNextPosition(x, y, n, m);
        dfs(matrix, state, next[0], next[1], n, m);
    }

    public static boolean canSelect(int[][] matrix, int[][] state, int x, int y) {
        if (matrix[x][y] == -1) {
            return false;
        }
        if (state[x][y] == 1) {
            return false;
        }
        // 检查8邻域是否有已选的元素
        return state[x - 1][y] != 1 && state[x + 1][y] != 1 &&
                state[x][y - 1] != 1 && state[x][y + 1] != 1 &&
                state[x - 1][y - 1] != 1 && state[x - 1][y + 1] != 1 &&
                state[x + 1][y - 1] != 1 && state[x + 1][y + 1] != 1;
    }

    public static int[] getNextPosition(int x, int y, int n, int m) {
        if (y < m) {
            return new int[]{x, y + 1}; // 移动到当前行的下一列
        } else {
            return new int[]{x + 1, 1}; // 移动到下一行的第一列
        }
    }
}
