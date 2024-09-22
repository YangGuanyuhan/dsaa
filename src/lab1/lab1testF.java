package lab1;

import java.util.Scanner;
public class lab1testF {
    public static void main(String[] args) {
        int[][] MahhJong = new int[4][10];
        Scanner in = new Scanner(System.in);
        String str = in.next();
        String[] parts = str.split("(?<=\\G\\d\\w)");  // 按照数字+字母的组合切割
        for (String part : parts) {
            int row ;
            int col = Character.getNumericValue(part.charAt(0));
            switch (part.charAt(1)) {
                case 'w':
                    row = 0;
                    break;
                case 'b':
                    row = 1;
                    break;
                case 's':
                    row = 2;
                    break;
                default:
                    row = 3;
                    break;
            }

            MahhJong[row][col]++;
            MahhJong[row][0]++;
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 10; j++) {
                if (MahhJong[i][j] >=2) {
                    MahhJong[i][j] -= 2;
                    MahhJong[i][0] -= 2;
                    if (checkwbs(MahhJong)&&checkz(MahhJong)) {
                        System.out.println("Blessing of Heaven");
                        return;
                    }
                    MahhJong[i][j] += 2;
                    MahhJong[i][0] += 2;


                }
            }

        }
        System.out.println("Bad luck");



        //   print2dArray(MahhJong);
    }
    private static boolean checkz(int[][] MahhJong) {
        for (int i = 0; i <10; i++) {
            if (MahhJong[3][0] == 0) {
                return true;
            }
            if (MahhJong[3][i] % 3 != 0) {
                return false;
            }
        }
        return false;
    }
    private static boolean checkwbs(int[][] MahhJong) {
        for (int i = 0; i < MahhJong.length-1; i++) {
            for (int j = 0; j < MahhJong[i].length; j++) {
                if (MahhJong[0][0] == 0&&MahhJong[1][0]==0&&MahhJong[2][0]==0&&MahhJong[3][0]==0) {
                    return true;
                }
                if (MahhJong[i][j] >= 3) {
                    MahhJong[i][j] -= 3;
                    MahhJong[i][0] -= 3;
                    if (checkwbs(MahhJong)) {
                        return true;
                    }
                    MahhJong[i][j] += 3;
                    MahhJong[i][0] += 3;
                }
                if (j < 8 && MahhJong[i][j] > 0 && MahhJong[i][j + 1] > 0 && MahhJong[i][j + 2] > 0) {
                    MahhJong[i][j]--;
                    MahhJong[i][j + 1]--;
                    MahhJong[i][j + 2]--;
                    MahhJong[i][0] -= 3;
                    if (checkwbs(MahhJong)) {
                        return true;
                    }
                    MahhJong[i][j]++;
                    MahhJong[i][j + 1]++;
                    MahhJong[i][j + 2]++;
                    MahhJong[i][0] += 3;
                }
            }
        }
        return false;
    }

    private static void print2dArray(int[][] MahhJong) {
        for (int i = 0; i < MahhJong.length; i++) {
            for (int j = 0; j < MahhJong[i].length; j++) {
                System.out.print(MahhJong[i][j] + " ");  // 打印每个元素
            }
            System.out.println();  // 换行打印
        }
    }
}