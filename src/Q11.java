import java.util.Scanner;
import java.util.Stack;

public class Q11 {
    /*static int[][] map;
    static boolean[][] visited;

    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();   //长
        int n = sc.nextInt();   //宽
        map = new int[m][n];    //地图
        int[][] x = new int[2][2];  //起点
        int k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = sc.nextInt();
                if (num == 2) {
                    x[k][0] = i;
                    x[k][1] = j;
                    k++;
                }
                map[i][j] = num;
            }
        }

        visited = new boolean[m][n];
        solve(x[0][0], x[0][1]);
        boolean[][] result1 = visited;

        visited = new boolean[m][n];
        solve(x[1][0], x[1][1]);
        boolean[][] result2 = visited;

        int way = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (result1[i][j] && result2[i][j] && map[i][j] == 3) {
                    way++;
                }
            }
        }
        System.out.println(way);
    }

    private static void solve(int x, int y) {
        if (x < 0 || x >= map.length || y < 0 || y >= map[0].length) {
            return;
        }
        if (map[x][y] == 1 || visited[x][y]) {
            return;
        }
        visited[x][y] = true;

        for (int[] dir : dirs) {
            solve(x + dir[0], y + dir[1]);
        }
    }*/

    static int[][] map;
    static boolean[][] visited;
    static int[][] begin;
    static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        map = new int[M][N];
        visited = new boolean[M][N];

        int k = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int x = sc.nextInt();
                map[i][j] = x;
                if (x == 2) {
                    begin[k][0] = i;
                    begin[k][1] = j;
                    k++;
                }
            }
        }

        visited = new boolean[M][N];
        dfs(begin[0][0],begin[0][1]);
        boolean[][] res1 = visited;

        visited = new boolean[M][N];
        dfs(begin[1][0],begin[1][1]);
        boolean[][] res2 = visited;

        int way = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(res1[i][j] && res2[i][j] && map[i][j] == 3) way++;
            }
        }

        System.out.println(way);
    }

    private static void dfs(int i, int j) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{i, j});

        while (!stack.isEmpty()) {
            int[] ok = stack.pop();
            int x = ok[0];
            int y = ok[1];
            if (x < 0 || x >= map.length || y < 0 || y >= map[0].length
                    || map[x][y] == 1 || visited[x][y]) {
                continue;
            }

            visited[x][y] = true;

            for (int[] d : direction) {
                stack.push(new int[]{x + d[0], y + d[1]});
            }
        }
    }
}
