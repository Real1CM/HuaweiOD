import java.util.*;

public class Q33 {
    //BFS
    static int M, N;
    static char[][] grid;
    static boolean[][] visited;
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        M = sc.nextInt();
        N = sc.nextInt();
        grid = new char[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = sc.next().charAt(0);
            }
        }

        visited = new boolean[M][N];
        int maxSize = -1;   //最大单入口区域尺寸
        int targetR = -1, targetC = -1;    //入口横坐标和纵坐标
        boolean multiMax = false;   //是否多解

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == '0' && !visited[i][j]) {
                    List<int[]> entries = new ArrayList<>();
                    int size = bfs(i, j, entries);

                    if (entries.size() == 1) {
                        if (size > maxSize) {
                            maxSize = size;
                            targetR = entries.get(0)[0];
                            targetC = entries.get(0)[1];
                            multiMax = false;
                        } else if (size == maxSize) {
                            multiMax = true;
                        }
                    }
                }
            }
        }

        if (maxSize == -1) {
            System.out.println("NULL");
        } else if (multiMax) {
            System.out.println(maxSize);
        } else {
            System.out.println(targetR + " " + targetC + " " + maxSize);
        }
    }

    private static int bfs(int r, int c, List<int[]> entries) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        visited[r][c] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            count++;
            int currR = curr[0];
            int currC = curr[1];

            if (currR == 0 || currR == M - 1 || currC == 0 || currC == N - 1) {
                entries.add(new int[]{currR, currC});
            }

            for (int[] dir : dirs) {
                int newR = currR + dir[0];
                int newC = currC + dir[1];

                if (newR >= 0 && newR < M && newC >= 0 && newC < N && !visited[newR][newC] && grid[newR][newC] == '0') {
                    visited[newR][newC] = true;
                    queue.offer(new int[]{newR, newC});
                }
            }
        }
        return count;
    }

    /*
    * static int m, n;
    static char[][] grid;
    static boolean[][] visited;
    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    // 用于记录当前连通区域内的入口坐标
    static List<int[]> currentEntries;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        m = sc.nextInt();
        n = sc.nextInt();
        grid = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.next().charAt(0);
            }
        }

        visited = new boolean[m][n];
        int maxSize = -1;
        int targetR = -1, targetC = -1;
        boolean multiMax = false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 发现未访问的空闲点，开始递归搜索整个区域
                if (grid[i][j] == 'O' && !visited[i][j]) {
                    currentEntries = new ArrayList<>();
                    int size = dfs(i, j);

                    // 判断是否为单入口区域
                    if (currentEntries.size() == 1) {
                        if (size > maxSize) {
                            maxSize = size;
                            targetR = currentEntries.get(0)[0];
                            targetC = currentEntries.get(0)[1];
                            multiMax = false;
                        } else if (size == maxSize) {
                            multiMax = true;
                        }
                    }
                }
            }
        }

        // 结果输出逻辑
        if (maxSize == -1) {
            System.out.println("NULL");
        } else if (multiMax) {
            System.out.println(maxSize);
        } else {
            System.out.println(targetR + " " + targetC + " " + maxSize);
        }
    }

    private static int dfs(int r, int c) {
        // 1. 递归终止条件
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 'X' || visited[r][c]) {
            return 0;
        }

        // 2. 标记已访问
        visited[r][c] = true;
        int count = 1;

        // 3. 检查是否是入口
        if (r == 0 || r == m - 1 || c == 0 || c == n - 1) {
            currentEntries.add(new int[]{r, c});
        }

        // 4. 向四个方向递归扩展
        for (int[] d : dirs) {
            count += dfs(r + d[0], c + d[1]);
        }

        return count;
    }
    * */
}
