import java.util.*;

public class DFSandBFS {
    static int M, N;
    static int[][] grid;
    static boolean[][] visited;
    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        grid = new int[M][N];
        visited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
    }

    private static void dfsRecursive(int i, int j) {
        //此处注意if语句中条件判断顺序，先是保证坐标在图中，后保证是否访问
        if (i < 0 || i >= M || j < 0 || j >= N || visited[i][j] || grid[i][j] == 0) return;

        visited[i][j] = true;

        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            dfsRecursive(x, y);
        }
    }

    private static void dfsIterative(int i, int j) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{i, j});
        visited[i][j] = true;

        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            int curX = cur[0];
            int curY = cur[1];

            for (int[] dir : dirs) {
                int x = curX + dir[0];
                int y = curY + dir[1];

                if (x >= 0 && x < M && y >= 0 && y < N && !visited[x][y] && grid[x][y] == 1) {
                    stack.push(new int[]{x, y});
                    visited[x][y] = true;
                }
            }

        }
    }

    private static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int[] dir : dirs) {
                int x = curX + dir[0];
                int y = curY + dir[1];

                if (x >= 0 && x < M && y >= 0 && y < N && !visited[x][y] && grid[x][y] == 1) {
                    queue.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
    }
}