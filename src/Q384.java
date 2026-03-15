import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q384 {
    static int N;
    static char[][] map;
    static boolean[][] visited;
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static char[] target;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();

        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            String[] str = sc.nextLine().split(",");
            for (int j = 0; j < N; j++) {
                map[i][j] = str[j].charAt(0);
            }
        }

        target = sc.nextLine().toCharArray();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                List<String> path = new ArrayList<>();
                visited = new boolean[N][N];
                if (dfs(i, j, 0, path)) ;
                {
                    System.out.println(String.join(",", path));
                    return;
                }
            }
        }
    }

    private static boolean dfs(int x, int y, int idx, List<String> path) {
        if (x < 0 || x >= N || y < 0 || y >= N || visited[x][y] || map[x][y] != target[idx]) return false;

        visited[x][y] = true;
        path.add(x + "," + y);

        if (idx == target.length - 1) return true;

        for (int[] dir : dirs) {
            if (dfs(x + dir[0], y + dir[1], idx + 1, path)) return true;
        }

        visited[x][y] = false;
        path.removeLast();
        return false;
    }
}
