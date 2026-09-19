import java.util.*;

public class Q257 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph[u].add(new int[]{v, w});
        }

        int start = sc.nextInt();
        int end = sc.nextInt();


        System.out.println(dijkstra(n, graph, start, end));
    }

    private static int dijkstra(int n, List<int[]>[] graph, int start, int end) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(x[1], y[1]));
        pq.offer(new int[]{start, dist[start]});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0];
            int w = cur[1];

            if (u == end) return w;

            if (w > dist[u]) continue;

            for (int[] edge : graph[u]) {
                int v = edge[0];
                int cw = edge[1];

                if (dist[u] + cw < dist[v]) {
                    dist[v] = dist[u] + cw;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }

        return dist[end] == Integer.MAX_VALUE ? -1 : dist[end];
    }
}
