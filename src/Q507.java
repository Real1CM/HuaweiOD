import java.io.*;
import java.util.*;

public class Q507 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int defaultCnt = Integer.parseInt(st.nextToken());
        int extraCnt = Integer.parseInt(st.nextToken());

        long[] arr = new long[n];
        long maxlog = 0;
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st2.nextToken());
            if (arr[i] > maxlog) maxlog = arr[i];
        }

        long left = 1, right = maxlog;
        long ans = maxlog;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (solve(mid, arr, defaultCnt, extraCnt)) {
                ans = mid;
                left = mid + 1;
            } else right = mid - 1;
        }

        System.out.println(ans);
    }

    private static boolean solve(long mid, long[] arr, int defaultCnt, int extraCnt) {
        long totalExtra = 0;
        long maxExtra = extraCnt * mid;

        for (long log : arr) {
            long baseMount = defaultCnt * mid;
            if(log > baseMount) {
                totalExtra += log - baseMount;
            }
            if(totalExtra > maxExtra) return false;
        }
        return  totalExtra <= maxExtra;
    }
}