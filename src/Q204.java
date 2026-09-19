import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q204 {
    static int m, n, k;
    static boolean[][] isVisited;
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        k = sc.nextInt();

        if (m <= 0 || n <= 0) {
            System.out.println(0);
            return;
        }

        isVisited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, 0});
        isVisited[0][0] = true;

        int res = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            res++;

            for (int[] d : dirs) {
                int nx = x + d[0];
                int ny = y + d[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !isVisited[nx][ny]) {
                    if (digit(nx) + digit(ny) <= k) {
                        isVisited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        System.out.println(res);
    }

    private static int digit(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
