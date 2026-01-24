import java.util.*;

public class ok {
    static int M, N;
    static int[][] adv;
    static boolean[] visited;
    static int[] match;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        adv = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                adv[i][j] = sc.nextInt();
            }
        }

        match = new int[M];
        Arrays.fill(match, -1);
    }

    private static boolean dfs(int u) {
        for (int i = 0; i < N; i++) {
            if (adv[u][i] == 1 && !visited[i]) {
                visited[i] = true;

                if(match[i] == -1 || dfs(match[i])) {
                    match[i] = i;
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