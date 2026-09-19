import java.util.Arrays;
import java.util.Scanner;

public class Q157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum = sc.nextInt();
        int n = sc.nextInt();

        long totalBallCount = 0;
        int[] bucketBall = new int[n];
        int maxInBuckets = 0;
        for (int i = 0; i < n; i++) {
            bucketBall[i] = sc.nextInt();
            totalBallCount += bucketBall[i];
            if (maxInBuckets < bucketBall[i]) maxInBuckets = bucketBall[i];
        }

        if (totalBallCount <= sum) {
            System.out.println("[]");
            return;
        }

        int l = 0, r = maxInBuckets;
        int best = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            long curRemaining = 0;
            for (int i = 0; i < n; i++) {
                curRemaining += Math.min(bucketBall[i], mid);
            }

            if (curRemaining <= sum) {
                best = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (bucketBall[i] > best) {
                res[i] = bucketBall[i] - best;
            } else res[i] = 0;
        }

        System.out.println(Arrays.toString(res).replaceAll(" ", ""));
    }
}
