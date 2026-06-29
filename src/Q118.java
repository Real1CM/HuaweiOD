import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q118 {
    static int m, n;
    static int[][] map;
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] line = sc.nextLine().trim().split(",");
        m = Integer.parseInt(line[0]);
        n = Integer.parseInt(line[1]);

        map = new int[m][n];
        for (int i = 0; i < m; i++) {
            String[] str = sc.nextLine().trim().split("[,\\s]+");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        int l = 1, r = 100;
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (solve(mid)) {
                ans = mid;
                r = mid - 1;
            } else l = mid + 1;
        }

        System.out.println(ans);
    }

    private static boolean solve(int gas) {
        int[][] maxRemain = new int[m][n];
        for (int[] row : maxRemain) Arrays.fill(row, -1);

        Queue<int[]> q = new LinkedList<>();

        int start = gas;
        if (map[0][0] == 0) return false;
        if (map[0][0] == -1) start = 100;
        else start -= map[0][0];

        if (start < 0) return false;

        maxRemain[0][0] = start;
        q.offer(new int[]{0, 0, start});

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            int thisGas = curr[2];

            if (thisGas < maxRemain[x][y]) continue;

            if (x == m - 1 && y == n - 1) return true;

            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n || map[nx][ny] == 0) continue;

                int nGas = thisGas;
                if (map[nx][ny] == -1) nGas = 100;
                else nGas -= map[nx][ny];

                if (nGas < 0 || nGas <= maxRemain[nx][ny]) continue;

                maxRemain[nx][ny] = nGas;
                q.offer(new int[]{nx, ny, nGas});
            }
        }

        return maxRemain[m - 1][n - 1] >= 0;
    }
}
