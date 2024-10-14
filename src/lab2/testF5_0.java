package lab2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class testF5_0 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int testTimes = Integer.parseInt(input[1]);

        int[] a = new int[n];
        int[] b = new int[n];


        String[] arrayA = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(arrayA[i]);
        }


        String[] arrayB = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(arrayB[i]);
        }

        for (int i = 0; i < testTimes; i++) {
            String[] range = reader.readLine().split(" ");
            int l = Integer.parseInt(range[0]);
            int r = Integer.parseInt(range[1]);

            writer.write(findMedian(a, b, l, r) + "\n");
        }


        writer.flush();
        writer.close();
        reader.close();
    }

    private static int findMedian(int[] a, int[] b, int l, int r) {
        int aleftIndex = l - 1;
        int arightIndex = r - 1;
        int bleftIndex = l - 1;
        int brightIndex = r - 1;

        int k = r - l + 1;
        while (k > 1) {
            int p = k / 2;
            if (a[p - 1 + aleftIndex] <= b[p - 1 + bleftIndex]) {
                aleftIndex += p;
            } else {
                bleftIndex += p;
            }
            k = k - p;

            if (arightIndex - aleftIndex == 0) {
                return b[k - 1 + bleftIndex];
            } else if (brightIndex - bleftIndex == 0) {
                return a[k - 1 + aleftIndex];
            }
        }

        if (a[aleftIndex] <= b[bleftIndex]) {
            return a[aleftIndex];
        } else {
            return b[bleftIndex];
        }
    }


}
