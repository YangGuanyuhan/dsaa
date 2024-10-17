package lab1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class testF6_0 {

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
        int k = r - l + 1;
        int aleftIndex = l - 1;
        int bleftIndex = l - 1;


        while (k > 1) {
            int p = k / 2;  // 找到中间位置
            int aMid = Math.min(aleftIndex + p, r) - 1;
            int bMid = Math.min(bleftIndex + p, r) - 1;

            if (a[aMid] <= b[bMid]) {
                aleftIndex = aMid + 1;  // 舍弃 a 中的前半部分
            } else {
                bleftIndex = bMid + 1;  // 舍弃 b 中的前半部分
            }
            k -= p;
        }

        // 比较a和b剩下的最前面的元素，返回较小的那个
        return Math.min(a[aleftIndex], b[bleftIndex]);
    }
}
