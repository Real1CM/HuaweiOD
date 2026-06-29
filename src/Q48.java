import java.util.*;

public class Q48 {
    static int N;
    static int[][] gird;
    static int startX, startY, endX, endY;
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int[][] minSteps;
    static int[][] maxCandies;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        gird = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                gird[i][j] = sc.nextInt();
                if (gird[i][j] == -3) {
                    startX = i;
                    startY = j;
                    gird[i][j] = 0;
                }
                if (gird[i][j] == -2) {
                    endX = i;
                    endY = j;
                    gird[i][j] = 0;
                }
            }
        }

        minSteps = new int[N][N];
        maxCandies = new int[N][N];
        for (int[] row : minSteps) Arrays.fill(row, Integer.MAX_VALUE);
        for (int[] row : maxCandies) Arrays.fill(row, -1);

        bfs(startX, startY);

        System.out.println(maxCandies[endX][endY]);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        minSteps[x][y] = 0;
        maxCandies[x][y] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            for (int[] dir : dirs) {
                int nextX = curX + dir[0];
                int nextY = curY + dir[1];

                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && gird[nextX][nextY] != -1) {
                    int nextStep = minSteps[curX][curY] + 1;
                    int nextCandy = maxCandies[curX][curY] + gird[nextX][nextY];

                    if (nextStep < minSteps[nextX][nextY]) {
                        minSteps[nextX][nextY] = nextStep;
                        maxCandies[nextX][nextY] = nextCandy;
                        q.offer(new int[]{nextX, nextY});
                    } else if (nextStep == minSteps[nextX][nextY]) {
                        if (nextCandy > maxCandies[nextX][nextY])
                            maxCandies[nextX][nextY] = nextCandy;
                    }
                }
            }
        }
    }
}
