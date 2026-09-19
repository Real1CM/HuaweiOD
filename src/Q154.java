import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q154 {
    static int n, m;
    static char[][] map;
    static boolean[][] isVisited;
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static public void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        map = new char[n][m];
        isVisited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            char[] tmp = sc.nextLine().trim().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = tmp[j];
            }
        }

        int num = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!isVisited[i][j] && map[i][j] != '#') {
                    int cnt = solve(i, j);
                    if (cnt < k) num++;
                }
            }
        }

        System.out.println(num);
    }

    static private int solve(int x, int y) {
        int cnt = 0;

        Queue<int[]> q = new LinkedList<>();

        if (map[x][y] == 'E') cnt++;
        isVisited[x][y] = true;
        q.offer(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int curX = cur[0];
            int curY = cur[1];

            for (int[] dir : dirs) {
                int nX = curX + dir[0];
                int nY = curY + dir[1];

                if (nX >= 0 && nX < n && nY >= 0 && nY < m && !isVisited[nX][nY] && map[nX][nY] != '#') {
                    isVisited[nX][nY] = true;
                    q.offer(new int[]{nX, nY});
                    if (map[nX][nY] == 'E') cnt++;
                }
            }
        }

        return cnt;
    }
}
