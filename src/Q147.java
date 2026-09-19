import java.util.Arrays;
import java.util.Scanner;

public class Q147 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int block = 1474560 / 512;
        int[] dp = new int[block + 1];

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int w = (s + 511) / 512;

            for (int j = block; j >= w; j--) {
                dp[j] = Math.max(dp[j], dp[j - w] + s);
            }
        }

        System.out.println(dp[block]);
    }
}