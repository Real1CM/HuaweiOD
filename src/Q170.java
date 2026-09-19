import java.util.*;

public class Q170 {
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Integer> res = new ArrayList<>();

        if (n <= 4) {
            res.add(n);
        } else {
            while (n > 4) {
                res.add(3);
                n -= 3;
            }

            if (n > 0) {
                res.add(n);
            }
        }

        Collections.sort(res);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.size(); i++) {
            sb.append(res.get(i));
            if (i < res.size() - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb);
    }*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();

        long[] val = new long[x + 1];
        List<Integer>[] dp = new ArrayList[x + 1];
        for (int i = 1; i <= x; i++) {
            val[i] = i;
            dp[i] = new ArrayList<>();
            dp[i].add(i);
        }

        for (int i = 2; i <= x; i++) {
            for (int j = 1; j <= i / 2; j++) {
                long curPrice = val[j] * val[i - j];
                int curCut = dp[j].size() + dp[i - j].size();

                if (curPrice > val[i] || (curPrice == val[i] && curCut < dp[i].size())) {
                    val[i] = curPrice;
                    List<Integer> tmp = new ArrayList<>();
                    tmp.addAll(dp[j]);
                    tmp.addAll(dp[i - j]);
                    dp[i] = tmp;
                }
            }
        }

        List<Integer> res = dp[x];
        Collections.sort(res);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i));
            if (i < res.size() - 1) System.out.print(" ");
        }
    }
}