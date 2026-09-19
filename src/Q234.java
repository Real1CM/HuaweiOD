import java.util.Scanner;

public class Q234 {
    static int n;
    static int[][] a;
    static boolean[] used;
    static int minCost = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        used = new boolean[n];

        used[0] = true;
        dfs(0, 1, 0);
        System.out.println(minCost);
    }

    private static void dfs(int u, int cnt, int curCost) {
        if (curCost >= minCost) return;

        if (cnt == n) {
            minCost = Math.min(minCost, curCost + a[u][0]);
            return;
        }

        for (int v = 0; v < n; v++) {
            if (!used[v]) {
                used[v] = true;
                dfs(v, cnt + 1, curCost + a[u][v]);
                used[v] = false;
            }
        }
    }
}