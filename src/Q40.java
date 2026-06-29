import java.util.*;

public class Q40 {
    static int M, N;
    static int[][] gird;
    static boolean[][] visited;
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> lines = new ArrayList<>();
        while (sc.hasNextLine()) {
            String str = sc.nextLine().trim();

            if (str.isEmpty()) {
                if (lines.isEmpty()) continue;
                else break;
            }
            lines.add(str);
        }

        if (lines.isEmpty()) {
            System.out.println(0);
            return;
        }

        M = lines.size();
        N = lines.getFirst().length();
        gird = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                gird[i][j] = lines.get(i).charAt(j) - '0';
            }
        }

        int max = -1;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(gird[i][j] != 0 && !visited[i][j]){
                    int curV = dfs(i, j);
                    max = Math.max(max, curV);
                }
            }
        }

        System.out.println(max);
    }

    private static int dfs(int i, int j) {
        if (i < 0 || i >= M || j < 0 || j >= N || visited[i][j] || gird[i][j] == 0)
            return 0;

        visited[i][j] = true;
        int sum = gird[i][j];

        for (int[]  dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            sum += dfs(x, y);
        }
        return sum;
    }

}
