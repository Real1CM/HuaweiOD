import java.util.*;

public class Q263 {
    private static List<Integer>[] tree;
    private static int[] dp;
    private static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) tree[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            int c1 = sc.nextInt();
            int c2 = sc.nextInt();

            tree[c1].add(c2);
            tree[c2].add(c1);
        }

        dp = new int[n + 1];

        dfs(1, 0);

        int minDP = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) minDP = Math.min(minDP, dp[i]);

        StringJoiner res = new StringJoiner(" ");
        for (int i = 1; i <= n; i++) {
            if (dp[i] == minDP) {
                res.add(String.valueOf(i));
            }
        }

        System.out.println(res.toString());
    }

    private static int dfs(int u, int p) {
        int size = 1;
        int maxSubtree = 0;

        for (int v : tree[u]) {
            if (v != p) {
                int subSize = dfs(v, u);
                size += subSize;
                maxSubtree = Math .max(maxSubtree, subSize);
            }
        }

        int parent = n - size;

        dp[u] = Math.max(maxSubtree, parent);

        return size;
    }
}