public class CuttingRope {
    public int solve1(int n) {
        int[] dp = new int[n + 1];

        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                int curMax = Math.max(j * (i - j), j * dp[i - j]);
                dp[i] = Math.max(dp[i], curMax);
            }
        }

        return dp[n];
    }

    public int solve2(int n) {
        if (n <= 3) return n - 1;

        int timesOf3 = n / 3;

        if (n % 3 == 1) {
            timesOf3 -= 1;
            return (int) Math.pow(3, timesOf3) * 4;
        }

        if (n % 3 == 2) {
            return (int) Math.pow(3, timesOf3) * 2;
        }

        return (int) Math.pow(3, timesOf3);
    }
}
