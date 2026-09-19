import java.util.Arrays;
import java.util.Scanner;

public class Q271 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        sc.nextLine();
        int[] a = Arrays.stream(sc.nextLine().trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] dp = new int[m + 1];
        for (int i = 1; i <= a.length; i++) {
            for (int j = i; j <= m; j++)
                dp[j] = Math.max(dp[j], dp[j - i] + a[i - 1]);
        }

        System.out.println(dp[m]);
    }
}