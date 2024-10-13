package learningExperience;

import java.util.Random;

public class MonteCarloPi {
    public static void main(String[] args) {
        long totalPoints = 100000000; // 总点数
        long insideCircle = 0; // 在圆内的点数
        Random random = new Random();

        for (long i = 0; i < totalPoints; i++) {
            double x = random.nextDouble(); // 随机生成 x 坐标 (0, 1)
            double y = random.nextDouble(); // 随机生成 y 坐标 (0, 1)

            // 判断点是否在单位圆内
            if (x * x + y * y <= 1) {
                insideCircle++;
            }
        }

        // 计算 π
        double piEstimate = 4.0 * insideCircle / totalPoints;
        System.out.println("估算的 π 值为: " + piEstimate);
    }
}
