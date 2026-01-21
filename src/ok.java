import java.util.*;

public class ok {
    static int M, N;
    static char[][] gird;
    static boolean[][] visited;
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        gird = new char[M][N];
        visited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                gird[i][j] = sc.next().charAt(0);
            }
        }

        int maxArea = 0;
        boolean duelSol = false;
        int entryX = -1, entryY = -1;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (gird[i][j] == 'o' && !visited[i][j]) {
                    List<int[]> entries = new ArrayList<>();
                    int curArea = bfs(i, j, entries);

                    if (entries.size() == 1) {
                        if (curArea > maxArea) {
                            maxArea = curArea;
                            entryX = entries.get(0)[0];
                            entryY = entries.get(0)[1];
                        }
                    } else if (curArea == maxArea) {
                        duelSol = true;
                    }
                }
            }
        }

        if (maxArea == -1) {
            System.out.println("NULL");
        } else if (duelSol) {
            System.out.println(maxArea);
        } else {
            System.out.println(entryX + " " + entryY + " " + maxArea);
        }
    }

    private static int bfs(int x, int y, List<int[]> entries) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        int count = 0;
        while (!q.isEmpty()) {
            count++;
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            if (curX == 0 || curY == 0 || curX == M - 1 || curY == N - 1) entries.add(new int[]{curX, curY});

            for (int[] dir : dirs) {
                int newX = curX + dir[0];
                int newY = curY + dir[1];

                if (newX < 0 || newX >= M || newY < 0 || newY >= N || !visited[newX][newY] || gird[newX][newY] == 'o') {
                    q.offer(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }
        return count;
    }
}