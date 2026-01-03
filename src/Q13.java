import java.util.Scanner;

public class Q13 {
    static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        map = new int[M][N];
        visited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        dfs(0, 0);

        int ok = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    ok++;
                }
            }
        }
        System.out.println(ok);
    }

    private static void dfs(int i, int j) {
        if (i < 0 || i >= map.length || j < 0 || j >= map[0].length) {
            return;
        }
        if (visited[i][j] || map[i][j] == 2) {
            return;
        }

        visited[i][j] = true;

        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            dfs(x, y);
        }
    }
}
