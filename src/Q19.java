import java.util.*;

public class Q19 {
    static int N, M, K;
    static int[][] matrix;
    static int[] match;
    static boolean[] vis;
    static List<Integer>[] adj;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        matrix = new int[N][M];
        List<Integer> allValues = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrix[i][j] = sc.nextInt();
                allValues.add(matrix[i][j]);
            }
        }

        Collections.sort(allValues);

        int left = 0;
        int right = allValues.size() - 1;
        int ans = allValues.get(right);

        int targetMatch = N - K + 1;

        while (left <= right) {
            int midIdx = left + (right - left) / 2;
            int midVal = allValues.get(midIdx);

            if (isMatch(midVal, targetMatch)) {
                right = midIdx - 1;
                ans = midVal;
            } else {
                left = midIdx + 1;
            }
        }

        System.out.println(ans);
    }

    private static boolean isMatch(int limit, int target) {
        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] <= limit) {
                    adj[i].add(j);
                }
            }
        }

        int count = 0;
        match = new int[M];
        Arrays.fill(match, -1);

        for (int i = 0; i < N; i++) {
            vis = new boolean[M];
            if (dfs(i)) {
                count++;
            }
        }

        return count >= target;
    }

    private static boolean dfs(int u) {
        for (int v : adj[u]) {
            if (!vis[v]) {
                vis[v] = true;
                if (match[v] == -1 || dfs(match[v])) {
                    match[v] = u;
                    return true;
                }
            }
        }
        return false;
    }
}