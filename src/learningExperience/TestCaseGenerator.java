package learningExperience;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class TestCaseGenerator {
    public static void main(String[] args) {
        int T = 100000; // 生成5个测试用例
        Random random = new Random();

        try (FileWriter writer = new FileWriter("test_cases.txt")) {
            writer.write(T + "\n"); // 写入测试用例数

            for (int t = 0; t < T; t++) {
                int n = random.nextInt(20) + 1; // 随机字符数量，范围1到20
                writer.write(n + "\n"); // 写入字符总数

                StringBuilder input = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    // 随机生成字符，包括数字和命令
                    char ch;
                    int type = random.nextInt(5); // 0到4的随机数
                    switch (type) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                            ch = (char) ('0' + random.nextInt(10)); // 生成0-9的数字
                            break;
                        case 4:
                            // 随机选择命令
                            char[] commands = {'I', 'H', 'L', 'r', 'x'};
                            ch = commands[random.nextInt(commands.length)];
                            break;
                        default:
                            ch = '0'; // 默认值
                    }
                    input.append(ch);
                }

                writer.write(input.toString() + "\n"); // 写入输入字符串
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
