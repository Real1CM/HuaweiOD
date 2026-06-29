import java.util.*;

public class Q120 {
    static int m, n;
    static int[][] map;
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        map = new int[m][n];
        int startX = 0, startY = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] != 0 && map[i][j] != -1) {
                    startX = i;
                    startY = j;
                }
            }
        }
        int endX = sc.nextInt();
        int endY = sc.nextInt();

        int[][] res = solve(startX, startY);
        System.out.print(res[endX][endY]);
    }

    private static int[][] solve(int startX, int startY) {
        int[][] signal = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(signal[i], 0);

        signal[startX][startY] = map[startX][startY];
        if (signal[startX][startY] <= 0) return signal;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startX, startY, signal[startX][startY]});

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int curX = curr[0];
            int curY = curr[1];
            int curSig = curr[2];

            if (curSig < signal[curX][curY]) continue;

            for (int[] dir : dirs) {
                int nX = curX + dir[0];
                int nY = curY + dir[1];

                if (nX < 0 || nX >= m || nY < 0 || nY >= n || map[nX][nY] == -1) continue;

                int nSig = curSig - 1;
                if (nSig <= 0 || nSig < signal[nX][nY]) continue;

                signal[nX][nY] = nSig;
                q.offer(new int[]{nX, nY, signal[nX][nY]});
            }
        }

        return signal;
    }
}
