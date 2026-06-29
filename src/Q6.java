import java.util.HashMap;
import java.util.Scanner;

public class Q6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();   //工作总时长
        int n = sc.nextInt();   //工作数量

        int[] time = new int[n + 1];
        int[] value = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            time[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }

        int[][] dp = new int[n + 1][T + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= T; j++) {
                dp[i][j] = dp[i - 1][j];

                if(j >= time[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - time[i]] + value[i]);
                }
            }
        }

        System.out.println(dp[n][T]);
        sc.close();
    }
}