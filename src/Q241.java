import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Q241 {
    static int[][] map = new int[64][64];
    static int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        StringTokenizer st;
        StringJoiner sj = new StringJoiner(" ");

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int startX = -1, startY = -1;
            while (st.hasMoreTokens()) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = num;

                if (startX == -1) {
                    startX = x;
                    startY = y;
                }
            }

            sj.add(bfs(startX, startY, num)+"");
        }
        System.out.println(sj.toString());
    }

    private static int bfs(int x, int y, int val) {
        boolean[][] used = new boolean[64][64];
        Queue<int[]> q = new LinkedList<>();

        int res = 0;

        used[x][y] = true;
        q.offer(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int[] dir : dirs) {
                int nx = cx + dir[0];
                int ny = cy + dir[1];

                if (nx < 0 || nx >= 64 || ny < 0 || ny >= 64 || map[nx][ny] != val) {
                    res++;
                    continue;
                }

                if (used[nx][ny]) continue;

                used[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }

        return res;
    }
}
