import java.util.Arrays;
import java.util.Scanner;

public class Q265 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int[] a = new int[m];

        int sum = 0;
        int maxVal = 0;
        for (int i = 0; i < m; i++) {
            a[i] = sc.nextInt();
            sum += a[i];
            maxVal = Math.max(maxVal, a[i]);
        }

        Arrays.sort(a);

        for (int tar = maxVal; tar <= sum; tar++) {
            if (sum % tar != 0) continue;

            int k = sum / tar;
            boolean[] used = new boolean[m];

            if (canPartition(a, used, m - 1, tar, 0, k)) {
                System.out.println(tar);
                break;
            }
        }
    }

    private static boolean canPartition(int[] a, boolean[] used, int startIdx, int tar, int curSum, int k) {
        if (k == 1) return true;

        if (curSum == tar) return canPartition(a, used, a.length - 1, tar, 0, k - 1);

        for (int i = startIdx; i >= 0; i--) {
            if (used[i] || curSum + a[i] > tar) continue;

            used[i] = true;

            if (canPartition(a, used, i - 1, tar, curSum + a[i], k)) return true;

            used[i] = false;

            if (curSum == 0) return false;

            if (curSum + a[i] == tar) return false;

            while (i > 0 && a[i] == a[i - 1]) i--;
        }

        return false;
    }
}
