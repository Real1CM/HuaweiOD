import java.util.HashSet;
import java.util.Scanner;

public class Q52 {
    public static void main(String[] args) {
        /*
        如果两个不同的前缀和取模后的结果相等PrefixSum[A]%m == PrefixSum[B]%m）
        它们之间的差值部分一定能被m整除
         */
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[] cards = new int[n];
            for (int i = 0; i < n; i++) {
                cards[i] = sc.nextInt();
            }
            System.out.println(solve(n, m, cards) ? 1 : 0);
        }
    }

    private static boolean solve(int n, int m, int[] cards) {
        boolean[] used = new boolean[n];
        long currentSum = 0;

        for (int i = 0; i < n; i++) {
            currentSum += cards[i];
            int reminder = (int) (currentSum % m);

            if (reminder == 0) {
                return true;
            }

            if (used[reminder]) {
                return true;
            }

            used[reminder] = true;
        }
        return false;
    }
}