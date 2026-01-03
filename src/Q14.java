import java.util.Arrays;
import java.util.Scanner;

public class Q14 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   //士兵数
        int T = sc.nextInt();   //敌人到达时间
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);

        long[] dp = new long[N + 1];

        if (N >= 1) dp[1] = a[0];
        if (N >= 2) dp[2] = a[1];

        for (int i = 3; i <= N; i++) {
            long res1 = dp[i - 1] + a[i - 1] + a[0];
            long res2 = dp[i - 2] + a[i - 1] + a[0] + 2L * a[1];
            dp[i] = Math.min(res1, res2);
        }

        int num = 0;
        long time = 0;
        for (int i = N; i > 0; i--) {
            if (dp[i] <= T) {
                num = i;
                time = dp[i];
                break;
            }
        }

        System.out.println(num + " " + time);
    }
}
