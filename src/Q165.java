import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q165 {
    private static int n, m;
    private static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    static class Node implements Comparable<Node> {
        int r, c, d, time;

        public Node(int r, int c, int d, int time) {
            this.r = r;
            this.c = c;
            this.d = d;
            this.time = time;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.time, other.time);

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        int[] lights = new int[n * m];
        for (int i = 0; i < n * m; i++) lights[i] = sc.nextInt();

        int timePerRoad = sc.nextInt();
        int startX = sc.nextInt();
        int startY = sc.nextInt();
        int endX = sc.nextInt();
        int endY = sc.nextInt();

        int res = calcTime(lights, timePerRoad, startX, startY, endX, endY);
        System.out.println(res);
    }

    private static int calcTime(int[] lights, int timePerRoad, int rowStart, int colStart, int rowEnd, int colEnd) {
        if (rowStart == rowEnd && colStart == colEnd) return 0;

        int[][][] dist = new int[n][m][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int d = 0; d < 4; d++) {
            int nR = rowStart + dirs[d][0];
            int nC = colStart + dirs[d][1];

            if (nR >= 0 && nR < n && nC >= 0 && nC < m) {
                dist[nR][nC][d] = timePerRoad;
                pq.offer(new Node(nR, nC, d, timePerRoad));
            }
        }

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (curr.time > dist[curr.r][curr.c][curr.d]) continue;

            if (curr.r == rowEnd && curr.c == colEnd) return curr.time;

            for (int nD = 0; nD < 4; nD++) {
                int nR = curr.r + dirs[nD][0];
                int nC = curr.c + dirs[nD][1];

                if (nR < 0 || nR >= n || nC < 0 || nC >= m) continue;

                int lightPeriod = lights[curr.r * m + curr.c];

                int wait = 0;
                if (nD == curr.d || (curr.d + 3) % 4 == nD) {
                    wait = lightPeriod;
                } else if ((curr.d + 1) % 4 == nD) {
                    wait = 0;
                } else continue;

                int nT = curr.time + wait + timePerRoad;

                if (nT < dist[nR][nC][nD]) {
                    dist[nR][nC][nD] = nT;
                    pq.offer(new Node(nR, nC, nD, nT));
                }
            }
        }

        return -1;
    }
}
