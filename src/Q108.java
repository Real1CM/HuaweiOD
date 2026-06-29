import java.util.Arrays;
import java.util.Scanner;

public class Q108 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int[] a = new int[t];
        int sum = 0;
        int max = 0;
        for (int i = 0; i < t; i++) {
            a[i] = sc.nextInt();
            sum += a[i];
            if (max < a[i]) max = a[i];
        }

        Arrays.sort(a);

        for (int i = max; i <= sum; i++) {
            if (sum % i != 0) continue;

            int k = sum / i;
            int[] buckets = new int[k];

            if (dfs(a, t - 1, buckets, i)) {
                System.out.println(i);
                break;
            }
        }
    }

    private static boolean dfs(int[] a, int idx, int[] buckets, int tar) {
        if (idx < 0) return true;

        int score = a[idx];
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] + score > tar) continue;

            if (i > 0 && buckets[i] == buckets[i - 1]) continue;

            buckets[i] += score;

            if (dfs(a, idx - 1, buckets, tar)) return true;

            buckets[i] -= score;

            if (buckets[i] == 0) break;
        }

        return false;
    }
}
