import java.util.*;

public class Q217 {
    static int n, l;
    static double[] log;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        l = sc.nextInt();

        log = new double[n];
        double minV = Double.MAX_VALUE;
        double maxV = -Double.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            double v = sc.nextDouble();
            log[i] = Math.log(v);
            minV = Math.min(minV, log[i]);
            maxV = Math.max(maxV, log[i]);
        }

        double left = minV, right = maxV;
        double biggest = left;
        for (int i = 0; i < 60; i++) {
            double mid = left + (right - left) / 2;
            if (check(mid)) {
                biggest = mid;
                left = mid;
            } else right = mid;
        }

        int bestIdx = -1;
        int minL = Integer.MAX_VALUE;
        double maxS = -1e18;

        double[] pref = new double[n + 1];
        for (int i = 0; i < n; i++) pref[i + 1] = pref[i] + log[i] - biggest;

        int midIdx = 0;
        for (int i = l; i <= n; i++) {
            int curIdx = i - l;
            if(pref[curIdx]<pref[midIdx]) midIdx = curIdx;

            double curDiff = pref[i] - pref[midIdx];

            if (curDiff > maxS + 1e-9) {
                maxS = curDiff;
                bestIdx = midIdx;
                minL = i - midIdx;
            } else if (Math.abs(curDiff - maxS) <= 1e-9) {
                int curLen = i - midIdx;
                if (curLen < minL) {
                    minL = curLen;
                    bestIdx = midIdx;
                } else if (curLen == minL && midIdx < bestIdx) bestIdx = midIdx;
            }
        }
        System.out.println(bestIdx+" "+minL);
    }

    private static boolean check(double mid) {
        double[] pref = new double[n + 1];
        for (int i = 0; i < n; i++) pref[i + 1] = pref[i] + log[i] - mid;

        double best = 0.0;
        for (int i = l; i <= n; i++) {
            best = Math.min(best, pref[i - l]);
            if (pref[i] - best >= 0) return true;
        }
        return false;
    }
}
