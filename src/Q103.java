import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Q103 {
    static int m, n;
    static int[][] map;
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        map = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        solve();

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 1) res++;
            }
        }

        System.out.print(res);
    }

    private static void solve() {
        Queue<int[]> q = new ArrayDeque<>();

        map[0][0] = 1;
        q.offer(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] cor = q.poll();
            int curX = cor[0];
            int curY = cor[1];

            for (int[] d : dirs) {
                int newX = curX + d[0];
                int newY = curY + d[1];

                if (newX >= 0 && newX < m && newY >= 0 && newY < n && map[newX][newY] == 0) {
                    map[newX][newY] = 1;
                    q.offer(new int[]{newX, newY});
                }
            }
        }
    }
}
