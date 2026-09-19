import java.util.Arrays;
import java.util.Scanner;

public class Q193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] a = Arrays.stream(sc.nextLine().trim().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        int car = sc.nextInt();

        int[] dp = new int[car + 1];
        dp[0] = 1;

        for (int x : a) {
            for (int j = car; j >= x; j--) {
                dp[j] += dp[j - x];
            }
        }

        System.out.println(dp[car]);
    }
}