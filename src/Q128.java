import java.util.Scanner;

public class Q128 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String t1 = sc.nextLine();
        String t2 = sc.nextLine();
        int l1 = t1.length();
        int l2 = t2.length();

        if (l1 == 0 || l2 == 0) {
            System.out.println();
            return;
        }

        int maxL = 0;
        int endIdx = 0;
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (t1.charAt(i - 1) == t2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                    if (maxL < dp[i][j]) {
                        maxL = dp[i][j];
                        endIdx = i;
                    }
                } else dp[i][j] = 0;
            }
        }

        if (maxL == 0) System.out.println();
        else System.out.println(t1.substring(endIdx - maxL, endIdx));
    }
}
