import java.util.*;

public class Q278 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int edge = sc.nextInt();

        List<int[]>[] edges = new List[n + 1];
        for (int i = 1; i <= n; i++) edges[i] = new ArrayList<>();

        for (int num = 0; num < edge; num++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            int t = sc.nextInt();
            edges[i].add(new int[]{j, t});
        }

        int start = sc.nextInt();

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0];
            int d = cur[1];

            if (d > dist[u]) continue;

            for (int[] e : edges[u]) {
                int v = e[0];
                int t = e[1];
                if (dist[v] > dist[u] + t) {
                    dist[v] = dist[u] + t;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println(-1);
                return;
            }
            ans = Math.max(ans, dist[i]);
        }
        System.out.println(ans);
    }
}
