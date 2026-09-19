import java.util.Arrays;
import java.util.Scanner;

public class Q167 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) a[i] = sc.nextInt();
            Arrays.sort(a);

            boolean[] used = new boolean[n];

            int res = solve(a, used, 0);

            System.out.println(res);
        }
    }

    private static int solve(int[] a, boolean[] used, int idx) {
        int n = a.length;
        int max = 0;

        for (int i = 0; i < n; i++) {
            if (used[i]) continue;

            for (int j = i + 1; j < n; j++) {
                if (used[j]) continue;

                for (int k = j + 1; k < n; k++) {
                    if (used[k]) continue;

                    if (a[i] * a[i] + a[j] * a[j] == a[k] * a[k]) {
                        used[i] = true;
                        used[j] = true;
                        used[k] = true;

                        int sub = 1 + solve(a, used, i + 1);
                        max = Math.max(sub, max);

                        used[i] = false;
                        used[j] = false;
                        used[k] = false;
                    }
                }
            }
        }
        return max;
    }
}
