import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q216 {
    static int n, m;
    static int[][] map;
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    solve(i, j);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    private static void solve(int x, int y) {
        Queue<int[]> q = new LinkedList<>();

        map[x][y] = 0;
        q.offer(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0], cy = cur[1];

            for (int[] dir : dirs) {
                int nx = cx + dir[0];
                int ny = cy + dir[1];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 1) {
                    map[nx][ny] = 0;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}
