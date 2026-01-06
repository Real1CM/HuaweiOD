import java.util.*;

public class ok {
    static int N, M, K;
    static int[][] matrix;
    static int[] match;
    static boolean[] visited;
    static List<Integer>[] adj;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        List<Integer> allValues = new ArrayList<>();
        matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrix[i][j] = sc.nextInt();
                allValues.add(matrix[i][j]);
            }
        }

        Collections.sort(allValues);

        int left = 0;
        int right = allValues.size() - 1;
        int target = N - K + 1;
        int ans = allValues.get(right);

        while (left <= right) {
            int midIdx = left + (right - left) / 2;
            int midVal = allValues.get(midIdx);

            if (check(midVal, target)) {
                ans = midVal;
                right = midIdx - 1;
            } else {
                left = midIdx + 1;
            }
        }

        System.out.println(ans);
    }

    private static boolean check(int limit, int target) {
        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] <= limit) {
                    adj[i].add(j);
                }
            }
        }

        match = new int[M];
        Arrays.fill(match, -1);
        int count = 0;

        for (int i = 0; i < N; i++) {
            visited = new boolean[M];
            if (dfs(i)) {
                count++;
            }
        }

        return count >= target;
    }

    private static boolean dfs(int u) {
        for (int v : adj[u]) {
            if (!visited[v]) {
                visited[v] = true;
                if (match[v] == -1 || dfs(match[v])) {
                    match[v] = u;
                    return true;
                }
            }
        }
        return false;
    }
}