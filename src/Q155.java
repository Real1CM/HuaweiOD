import java.util.*;

public class Q155 {
    static int row, column;
    static int[][] map;
    static boolean[][] isVisited;
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String[]> lines = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) break;
            lines.add(line.split("\\s+"));
        }

        if (lines.isEmpty()) {
            System.out.println(-1);
            return;
        }

        row = lines.size();
        column = lines.get(0).length;
        map = new int[row][column];

        Queue<int[]> q = new LinkedList<>();

        int oneCnt = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                String tmp = lines.get(i)[j];
                if ("YES".equals(tmp)) {
                    q.offer(new int[]{i, j});
                    map[i][j] = 0;
                } else if ("NO".equals(tmp)) {
                    map[i][j] = 1;
                    oneCnt++;
                } else if ("NA".equals(tmp)) {
                    map[i][j] = 2;
                }
            }
        }

        if (oneCnt == 0) {
            System.out.println(0);
            return;
        }

        if (q.isEmpty()) {
            System.out.println(-1);
            return;
        }

        int cnt = 0;
        while (!q.isEmpty() && oneCnt > 0) {
            int size = q.size();
            cnt++;

            for (int i = 0; i < size; i++) {
                int[] c = q.poll();
                int cx = c[0];
                int cy = c[1];


                for (int[] dir : dirs) {
                    int nx = cx + dir[0];
                    int ny = cy + dir[1];

                    if (nx >= 0 && nx < row && ny >= 0 && ny < column && map[nx][ny] == 1) {
                        map[nx][ny] = 0;
                        oneCnt--;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        if (oneCnt != 0) System.out.println(-1);
        else System.out.println(cnt);
    }
}
