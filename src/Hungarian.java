import java.util.*;

public class Hungarian {
    static int M, N;
    static int[][] adj;
    static boolean[] visited;
    static int[] match;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        for (int j = 0; j < M; j++) {
            for (int i = 0; i < N; i++) {
                adj[j][i] = sc.nextInt();
            }
        }
        adj = new int[M][N];
        match = new int[N];

        Arrays.fill(match, -1);
        int max = maxMatch();
    }

    private static boolean dfs(int u) {
        for (int i = 0; i < N; i++) {
            if (adj[u][i] == 1 && !visited[i]) {
                visited[i] = true;

                if (match[i] == -1 || dfs(i)) {
                    match[i] = 1;
                    return true;
                }
            }
        }
        return false;
    }

    private static int maxMatch() {
        int count = 0;
        for (int i = 0; i < M; i++) {
            visited = new boolean[N];
            if (dfs(i)) count++;
        }
        return count;
    }
}
