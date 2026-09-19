import java.util.Arrays;
import java.util.Scanner;

public class Q230 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] a = Arrays.stream(sc.nextLine().trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = a.length;

        if (n == 1) {
            System.out.println(a[0]);
            return;
        }

        if (n == 2) {
            System.out.println(Math.max(a[0], a[1]));
            return;
        }

        int m1 = solve(a, 0, n - 2);
        int m2 = solve(a, 1, n - 1);
        System.out.println(Math.max(m1, m2));
    }

    private static int solve(int[] a, int start, int end) {
        int prev2 = 0;
        int prev1 = 0;

        for (int i = start; i <= end; i++) {
            int cur = Math.max(prev1, prev2 + a[i]);
            prev2 = prev1;
            prev1 = cur;
        }

        return prev1;
    }
}