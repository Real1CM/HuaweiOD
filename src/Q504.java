import java.io.*;
import java.util.*;

public class Q504 {
    static int N, K, M;
    static int[] scores;
    static List<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        scores = new int[N];
        for (int i = 0; i < N; i++) scores[i] = Integer.parseInt(st.nextToken());


        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) adj[i] = new ArrayList<>();

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        int left = 0, right = 1000000000;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(mid)) {
                ans = mid;
                left = mid + 1;
            } else right = mid - 1;
        }

        System.out.println(ans);
    }

    private static boolean check(int mid) {
        if (scores[0] < mid || scores[N - 1] < mid) return false;

        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[N];
        Arrays.fill(dist, -1);

        q.offer(0);
        dist[0] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == N - 1) return dist[cur] <= K;

            if (dist[cur] == K) continue;

            for (int i : adj[cur]) {
                if (dist[i] == -1 && scores[i] >= mid) {
                    dist[i] += dist[cur];
                    q.offer(i);
                }
            }
        }

        return false;
    }
}
