import java.util.*;

public class Q238 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] opTokens = sc.nextLine().trim().split("\\s+");

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] map = new int[n][m];
        int headX = -1, headY = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                String cell = sc.next();
                if ("F".equals(cell)) map[i][j] = 1;
                else if ("H".equals(cell)) {
                    headX = i;
                    headY = j;
                    map[i][j] = 0;
                } else map[i][j] = 0;
            }
        }

        Map<Character, int[]> dirs = new HashMap<>();
        dirs.put('U', new int[]{-1, 0});
        dirs.put('D', new int[]{1, 0});
        dirs.put('L', new int[]{0, -1});
        dirs.put('R', new int[]{0, 1});

        char curDir = 'L';

        Deque<int[]> snake = new ArrayDeque<>();
        snake.addFirst(new int[]{headX, headY});

        for (String op : opTokens) {
            if (op.isEmpty()) continue;
            char c = op.charAt(0);

            if (c == 'U' || c == 'D' || c == 'L' || c == 'R') {
                curDir = c;
            } else if (c == 'G') {
                int[] dir = dirs.get(curDir);
                int[] curHead = snake.peekFirst();
                int nxtX = curHead[0] + dir[0];
                int nxtY = curHead[1] + dir[1];

                if (nxtX < 0 || nxtX >= n || nxtY < 0 || nxtY >= m) break;

                if (map[nxtX][nxtY] == 1) map[nxtX][nxtY] = 0;
                else snake.pollLast();

                boolean collide = false;
                for (int[] body : snake) {
                    if (body[0] == nxtX && body[1] == nxtY) {
                        collide = true;
                        break;
                    }
                }

                if (collide) break;

                snake.addFirst(new int[]{nxtX, nxtY});
            }
        }

        System.out.println(snake.size());
    }
}
