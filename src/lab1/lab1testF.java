package lab1;

import java.util.Scanner;
public class lab1testF {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testnumber= in.nextInt();
        outloop:
        for (int p = 0; p < testnumber; p++) {


            int[][] MahhJong = new int[4][10];
            String str = in.next();
            String[] parts = str.split("(?<=\\G\\d\\w)");
            for (String part : parts) {
                int row;
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
                    if (MahhJong[i][j] >= 2) {
                        MahhJong[i][j] -= 2;
                        MahhJong[i][0] -= 2;
                        if (checkwbs(MahhJong) &&
                                checkz(MahhJong)) {
                            System.out.println("Blessing of Heaven");
                            continue outloop;
                        }
                        MahhJong[i][j] += 2;
                        MahhJong[i][0] += 2;


                    }
                }

            }
            System.out.println("Bad luck");

        }
    }
    private static boolean checkz(int[][] MahhJong) {
        for (int i = 1; i <10; i++) {
            if (MahhJong[3][0] == 0) {
                return true;
            }
            if (MahhJong[3][i] >= 3) {
                MahhJong[3][i] -= 3;
                MahhJong[3][0] -= 3;
                if (checkz(MahhJong)) {
                    return true;
                }
                MahhJong[3][i] += 3;
                MahhJong[3][0] += 3;
            }
        }
        return false;
    }
    private static boolean checkwbs(int[][] MahhJong) {
        for (int i = 0; i < MahhJong.length-1; i++) {
            for (int j = 1; j < MahhJong[i].length; j++) {
                if (MahhJong[0][0] == 0&&MahhJong[1][0]==0&&MahhJong[2][0]==0) {
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

}