import java.io.*;
import java.util.*;

public class ok {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] a = new int[n];
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            pre[i + 1] = pre[i] + a[i];
        }

        double meanS = (double) pre[n] / m;

        double[][] dp = new double[m + 1][n + 1];
        int[][] path = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) dp[i][j] = Double.MAX_VALUE;
        }
        dp[0][0] = 0.0;

        for (int i = 1; i <= m; i++) {
            for (int j = i; j <= n; j++) {
                for (int k = i - 1; k < j; k++) {
                    double bathCost = pre[j] - pre[k];
                    double costDiff = bathCost - meanS;
                    double val = dp[i - 1][k] + costDiff * costDiff;

                    if(val<dp[i][j]){
                        dp[i][j] = val;
                        path[i][j] = k;
                    }
                }
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        int curj = n;
        for(int i =m;i>0;i--){
            int prevK = path[i][curj];
            res.add(curj-prevK);
            curj = prevK;
        }
        Collections.reverse(res);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.size(); i++) {
            sb.append(res.get(i));
            if (i < res.size() - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}