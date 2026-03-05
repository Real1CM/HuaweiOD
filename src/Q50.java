import java.util.*;

public class Q50 {
    static int t, c;
    static int n, m;
    static char[][] map;
    static int startX, startY;

    //boolean[][] visited;
    static int[][][] minTurns;
    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        t = sc.nextInt();
        c = sc.nextInt();
        n = sc.nextInt();
        m = sc.nextInt();
        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            String row = sc.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = row.charAt(j);

                if (map[i][j] == 'S') {
                    startX = i;
                    startY = j;
                }
            }
        }

        if (solve()) System.out.println("YES");
        else System.out.println("NO");
    }

    static boolean solve() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        minTurns = new int[n][m][c + 1];
        for (int[][] row : minTurns) {
            for (int[] cell : row) Arrays.fill(cell, Integer.MIN_VALUE);
        }

        pq.offer(new int[]{startX, startY, 0, 0, -1});
        minTurns[startX][startY][c] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0], y = cur[1], curT = cur[2], curC = cur[3], lastDir = cur[4];

            if (map[x][y] == 'T') return true;
            if (curT > t) continue;

            for (int i = 0; i < 4; i++) {
                int nx = x + dirs[i][0];
                int ny = y + dirs[i][1];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    int nextC = curC + (map[nx][ny] == '*' ? 1 : 0);

                    if (nextC <= c) {
                        int nextT = (lastDir != -1 && lastDir != i) ? curT + 1 : curT;
                        if (nextT <= t && nextT < minTurns[x][y][nextC]) {
                            minTurns[x][y][nextC] = nextT;
                            pq.offer(new int[]{nx, ny, nextT, nextC, i});
                        }
                    }
                }
            }
        }
        return false;
    }
}
