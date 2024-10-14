package lab2;



import java.util.Scanner;

public class testF2_0 {

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
        }
        input.close();
    }

    private static int findMedian(int[] a, int[] b, int l, int r) {
        int k = r - l + 1;
        int[] suba = new int[k];
        int[] subb = new int[k];
        for (int i = 0; i < k; i++) {
            // 修正索引，使其不越界
            suba[i] = a[l + i - 1];
            subb[i] = b[l + i - 1];
        }
        int power = 1;
        while (k > 1) {
            // 使用 Math.pow 来代替递归的 power 方法
            int divisor = (int) Math.pow(2, power);
            k = k / divisor;
            if (suba[k - 1] <= subb[k - 1]) {
                int[] newArray = new int[suba.length - k];
                System.arraycopy(suba, k, newArray, 0, suba.length - k);
                suba = newArray;
            } else {
                int[] newArray = new int[subb.length - k];
                System.arraycopy(subb, k, newArray, 0, subb.length - k);
                subb = newArray;
            }
            power++;
        }
        return (suba[0] <= subb[0]) ? suba[0] : subb[0];
    }

    // 移除了递归的 power 方法，直接使用 Math.pow 代替
}

