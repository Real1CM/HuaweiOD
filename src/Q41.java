import java.util.*;
import java.util.stream.Collectors;

public class Q41 {
    static int N;
    static int[][] adj;
    static boolean[] visited;
    static Queue<Integer> infected;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        infected = Arrays.stream(sc.nextLine().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedList::new));
        adj = new int[N][N];
        for (int i = 0; i < N; i++) {
            adj[i] = Arrays.stream(sc.nextLine().split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        visited = new boolean[N];
        for (int i :  infected) {
            visited[i] = true;
        }

        int count = 0;
        while (!infected.isEmpty()) {
            int u = infected.poll();
            for (int v = 0; v < N; v++) {
                if (adj[u][v] == 1 && !visited[v]) {
                    infected.add(v);
                    visited[v] = true;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}