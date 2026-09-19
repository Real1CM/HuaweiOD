import com.sun.jdi.connect.Connector;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q239 {
    static int x, y;
    static int[][] map;
    static boolean[][] used;
    static int[][] dirs = {{1, 0}, {0, 1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        x = sc.nextInt();
        y = sc.nextInt();

        map = new int[x][y];

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int cx = sc.nextInt();
            int cy = sc.nextInt();
            map[cx][cy] = 1;
        }

        int unreach = x * y - n - bfs();
        int trap = x * y - n - solve();
        System.out.println(trap + " " + unreach);
    }

    private static int bfs() {
        used = new boolean[x][y];
        Queue<int[]> q = new LinkedList<>();

        used[0][0] = true;
        q.offer(new int[]{0, 0});

        int res = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0], cy = cur[1];

            for (int[] dir : dirs) {
                int nx = cx + dir[0];
                int ny = cy + dir[1];

                if (nx >= 0 && nx < x && ny >= 0 && ny < y && !used[nx][ny] && map[nx][ny] != 1) {
                    used[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                    res++;
                }
            }
        }

        return res;
    }

    private static int solve() {
        used = new boolean[x][y];
        Queue<int[]> q = new LinkedList<>();

        used[x - 1][y - 1] = true;
        q.offer(new int[]{x - 1, y - 1});

        int res = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0], cy = cur[1];

            for (int[] dir : dirs) {
                int nx = cx - dir[0];
                int ny = cy - dir[1];

                if (nx >= 0 && nx < x && ny >= 0 && ny < y && !used[nx][ny] && map[nx][ny] != 1) {
                    used[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                    res++;
                }
            }
        }
        return res;
    }
}