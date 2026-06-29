import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Q135 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        int k = sc.nextInt();

        int[] dp = new int[n];

        dp[0] = a[0];
        Deque<Integer> q = new ArrayDeque<>();
        q.offerLast(0);

        for (int i = 1; i < n; i++) {
            if (!q.isEmpty() && q.peekFirst() < i - k) q.pollFirst();

            dp[i] = a[i] + dp[q.peekFirst()];

            while (!q.isEmpty() && dp[q.peekLast()] <= dp[i]) q.pollLast();

            q.offerLast(i);
        }

        System.out.println(dp[n - 1]);
    }
}