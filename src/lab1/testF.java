package lab1;

import java.util.Scanner;

public class testF {

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
        int leftIndex=0;
        int rightIndex=a.length-1;
        int k = r - l + 1;
        int[] suba = new int[k];
        int[] subb = new int[k];
        for (int i = 0; i < k; i++) {
            suba[i] = a[l + i - 1];
            subb[i] = b[l + i - 1];
        }
        int power = 1;
        while (k > 1) {
            if (k <= 1) {
                break;
            }

            int p = k / 2;

            if (suba[p - 1] <= subb[p - 1]) {


                int[] newArray = new int[suba.length - p];
                System.arraycopy(suba, p, newArray, 0, suba.length - p);
                suba = newArray;
            } else {
                int[] newArray = new int[subb.length - p];
                System.arraycopy(subb, p, newArray, 0, subb.length - p);
                subb = newArray;
            }
            k = k - p;
            power++;
            if (suba.length == 0) {
                return subb[k-1 ];
            } else if (subb.length == 0) {
                return suba[k - 1];
            }
//
//            System.out.println("k:" + k);
//            System.out.println(Arrays.toString(suba));
//            System.out.println(Arrays.toString(subb));

        }
        if (suba[0] <= subb[0]) {
            return suba[0];
        } else {
            return subb[0];
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