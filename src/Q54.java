import java.util.Scanner;

public class Q54 {
    static int M, N;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        map = new int[M][N];
        visited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int max = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] > 0 && !visited[i][j]) {
                    int curMax = solve(i, j);
                    max = Math.max(curMax, max);
                }
            }
        }

        System.out.println(max);
    }

    private static int solve(int x, int y) {
        if (x < 0 || y < 0 || x >= M || y >= N || visited[x][y] || map[x][y] == 0) {
            return 0;
        }

        visited[x][y] = true;

        int total = map[x][y];

        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];

            total += solve(nextX, nextY);
        }

        return total;
    }
}
