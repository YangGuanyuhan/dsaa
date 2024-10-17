package lab1;

import java.util.Scanner;

public class testF3_0 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int testTimes = input.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = input.nextInt();
        }
        for (int i = 0; i < testTimes; i++) {
            int l = input.nextInt();
            int r = input.nextInt();
            System.out.println(findMedian(a, b, l, r));
            //  System.out.println("--------------");


        }

    }

    private static int findMedian(int[] a, int[] b, int l, int r) {
        int aleftIndex = 0;
        int arightIndex = a.length - 1;
        int bleftIndex = 0;
        int brightIndex = b.length - 1;

        int k = r - l + 1;
        int[] suba = new int[k];
        int[] subb = new int[k];
        for (int i = 0; i < k; i++) {
            suba[i] = a[l + i - 1];
            subb[i] = b[l + i - 1];
        }
        while (k > 1) {
            if (k <= 1) {
                break;
            }

            int p = k / 2;

            if (suba[p - 1+aleftIndex] <= subb[p - 1+bleftIndex]) {
                aleftIndex += p;

                // int[] newArray = new int[suba.length - p];
                // System.arraycopy(suba, p, newArray, 0, suba.length - p);
                //suba = newArray;
            } else {
                bleftIndex += p;
                // int[] newArray = new int[subb.length - p];
                //  System.arraycopy(subb, p, newArray, 0, subb.length - p);
                //  subb = newArray;
            }
            k = k - p;

            if (arightIndex - aleftIndex == 0) {
                return subb[k - 1+bleftIndex];
            } else if (subb.length == 0) {
                return suba[k - 1+aleftIndex];
            }
//
//            System.out.println("k:" + k);
//            System.out.println(Arrays.toString(suba));
//            System.out.println(Arrays.toString(subb));

        }
        if (suba[aleftIndex] <= subb[bleftIndex]) {
            return suba[aleftIndex];
        } else {
            return subb[bleftIndex];
        }

    }

    public static int power(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        } else {
            return base * power(base, exponent - 1);
        }
    }
}