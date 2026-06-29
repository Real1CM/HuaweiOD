import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q111 {
    private static int[][][] dp = new int[32][2][2];
    private static ArrayList<Integer> digits = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int r = sc.nextInt();

        int ans = solve(r) - solve(l - 1);
        System.out.print(ans);
    }

    private static int solve(int n) {
        if (n <= 0) return 0;

        digits.clear();

        while (n > 0) {
            digits.add(n & 1);
            n >>= 1;
        }

        for (int[][] row1 : dp) {
            for (int[] row2 : row1) {
                Arrays.fill(row2, -1);
            }
        }

        return dfs(digits.size() - 1, 0, 0, true, false);
    }

    private static int dfs(int pos, int pre1, int pre2, boolean isLimit, boolean isNum) {
        if (pos < 0) return isNum ? 1 : 0;

        if (!isLimit && isNum && dp[pos][pre1][pre2] != -1) return dp[pos][pre1][pre2];

        int res = 0;

        if (!isNum) res += dfs(pos - 1, 0, 0, false, false);

        int up = isLimit ? digits.get(pos) : 1;
        int down = isNum ? 0 : 1;
        for (int i = down; i <= up; i++) {
            if (isNum && pre2 == 1 && pre1 == 0 && i == 1) continue;

            res += dfs(pos - 1, i, pre1, isLimit && (i == up), true);
        }

        if (!isLimit && isNum) dp[pos][pre1][pre2] = res;

        return res;
    }
}