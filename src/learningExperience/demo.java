package learningExperience;

import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int k = in.nextInt();
        int s = in.nextInt();
        int i = 1;//表示当前的时间
        int last_ans = s;
        while (i <= t) {
            System.out.print(solve(i + last_ans) + " ");
            if (i % 100 == 0) {

                last_ans = solve(i + last_ans);
            }
            i++;
        }

    }
    public static int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static int solve(int n) {
        int ans = 0;
        ans = n + sumOfDigits(n);
        return ans;

    }
}
