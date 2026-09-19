import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q231 {
    static int m, n, k;
    static int[][] map;
    static boolean[][] used;
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        k = sc.nextInt();
        map = new int[m][n];
        used = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int minStep = 0, maxHeight = 0;

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, 0, 0});
        used[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            int step = cur[2];
            int h = map[x][y];

            if (h > maxHeight) {
                maxHeight = h;
                minStep = step;
            } else if (h == maxHeight) {
                minStep = Math.min(minStep, step);
            }

            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !used[nx][ny]) {
                    if (Math.abs(map[nx][ny] - map[x][y]) <= k) {
                        used[nx][ny] = true; // 标记已访问
                        q.offer(new int[]{nx, ny, step + 1});
                    }
                }
            }
        }

        System.out.println(maxHeight + " " + minStep);
    }
}
