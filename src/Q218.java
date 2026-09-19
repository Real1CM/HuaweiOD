import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q218 {
    static int m, n;
    static int[][] map;
    static boolean[][] used;
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int maxStep = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        map = new int[m][n];
        used = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                used[i][j] = true;
                solve(i, j, 0, 0);
                used[i][j] = false;
            }
        }

        System.out.println(maxStep);
    }

    private static void solve(int i, int j, int lastState, int steps) {
        maxStep = Math.max(maxStep, steps);

        for (int[] dir : dirs) {
            int nx = i + dir[0];
            int ny = j + dir[1];

            if (nx >= 0 && nx < m && ny >= 0 && ny < n && !used[nx][ny]) {
                int diff = map[nx][ny] - map[i][j];

                if (diff == 0) continue;

                int curState = 0;
                boolean canMove = false;
                if (diff > 0) {
                    if (lastState <= 0) {
                        canMove = true;
                        curState = 1;
                    }
                } else {
                    if (lastState >= 0) {
                        canMove = true;
                        curState = -1;
                    }
                }

                if (canMove) {
                    used[nx][ny] = true;
                    solve(nx, ny, curState, steps + 1);
                    used[nx][ny] = false;
                }
            }
        }
    }
}
