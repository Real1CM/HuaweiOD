import java.util.*;

public class Q240 {
    static int n, m;
    static int[] data;
    static int[][] password;
    static boolean[][] used;

    static int[][] dirs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    static List<int[]> bestPath = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        data = new int[n];
        for (int i = 0; i < n; i++) data[i] = sc.nextInt();

        m = sc.nextInt();
        password = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                password[i][j] = sc.nextInt();
            }
        }

        used = new boolean[m][m];
        List<int[]> path = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (password[i][j] == data[0]) {
                    used[i][j] = true;
                    path.add(new int[]{i, j});

                    if (dfs(1, i, j, path)) {
                        printPath(bestPath);
                        return;
                    }

                    path.removeLast();
                    used[i][j] = false;
                }
            }
        }

        System.out.println("error");
    }

    private static boolean dfs(int dataIdx, int curX, int curY, List<int[]> path) {
        if (dataIdx == n) {
            bestPath = new ArrayList<>(path);
            return true;
        }

        for (int[] dir : dirs) {
            int nxtX = curX + dir[0];
            int nxtY = curY + dir[1];

            if (nxtX >= 0 && nxtX < m && nxtY >= 0 && nxtY < m) {
                if (!used[nxtX][nxtY] && password[nxtX][nxtY] == data[dataIdx]) {
                    used[nxtX][nxtY] = true;
                    path.add(new int[]{nxtX, nxtY});

                    if (dfs(dataIdx + 1, nxtX, nxtY, path)) return true;

                    path.removeLast();
                    used[nxtX][nxtY] = false;
                }
            }
        }

        return false;
    }

    private static void printPath(List<int[]> path) {
        StringJoiner sj = new StringJoiner(" ");
        for (int[] point : path) {
            sj.add(point[0] + "").add(point[1] + "");
        }
        System.out.println(sj.toString());
    }
}
