import java.util.Arrays;
import java.util.Scanner;

public class Q136 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            max += a[i];
        }

        if (max % 2 != 0) {
            System.out.println(-1);
            return;
        }

        int tar = max / 2;
        int[] dp = new int[tar + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = tar; j >= a[i]; j--) {
                if (dp[j - a[i]] != n + 1)
                    dp[j] = Math.min(dp[j], dp[j - a[i]] + 1);
            }
        }

        if (dp[tar] == n + 1) System.out.println(-1);
        else System.out.println(dp[tar]);
    }
}
