import java.util.Arrays;
import java.util.Scanner;

public class Q112 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int max = sc.nextInt();

        int[] arr = new int[num];
        for (int i = 0; i < num; i++) arr[i] = sc.nextInt();
        Arrays.sort(arr);

        int[][] dp = new int[num + 1][2];
        for (int i = 2; i <= num; i++) {
            int noMatchCnt = dp[i - 1][0];
            int noMatchSum = dp[i - 1][1];

            int diff = arr[i - 1] - arr[i - 2];

            if (diff <= max) {
                int matchCnt = dp[i - 1][0] + 1;
                int matchSum = dp[i - 1][1] + diff;

                if (matchCnt > noMatchCnt) {
                    dp[i][0] = matchCnt;
                    dp[i][1] = matchSum;
                } else if (matchCnt == noMatchCnt) {
                    dp[i][0] = matchCnt;
                    dp[i][1] = Math.min(noMatchSum, matchSum);
                } else {
                    dp[i][0] = noMatchCnt;
                    dp[i][1] = noMatchSum;
                }
            }
        }

        if (dp[num][0] == 0) System.out.print(-1);
        else System.out.print(dp[num][1]);
    }
}
