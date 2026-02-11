import java.util.*;

public class ok {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] gird = new int[N][N];
        int startX = 0, startY = 0, endX = 0, endY = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                gird[i][j] = sc.nextInt();
                if (gird[i][j] == -3) {
                    gird[i][j] = 0;
                    startX = i;
                    startY = j;
                } else if (gird[i][j] == -2) {
                    gird[i][j] = 0;
                    endX = i;
                    endY = j;
                }
            }
        }

        int[][] minSteps = new int[N][N];
        for (int[] i : minSteps) Arrays.fill(i, Integer.MAX_VALUE);
        int[][] maxCandies = new int[N][N];
        for (int[] i : maxCandies) Arrays.fill(i, -1);

        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        minSteps[startX][startY] = 0;
        maxCandies[startX][startY] = 0;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startX, startY});
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
                    } else if (nextStep == minSteps[nextX][nextY])
                        if (nextCandy > maxCandies[nextX][nextY])
                            maxCandies[nextX][nextY] = nextCandy;
                }
            }
        }

        System.out.println(maxCandies[endX][endY]);
    }
}