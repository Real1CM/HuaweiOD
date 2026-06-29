import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
    static class Edge{
        int to;
        int weight;
        public Edge(int to, int w){
            this.to = to;
            this.weight = w;
        }
    }

    static class Node implements Comparable<Node> {
        int id;
        int dist;
        public Node(int id, int dist){
            this.id = id;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.dist, o.dist);
        }
    }

    public int[] dijkstra(int n, List<List<Edge>> adj, int start) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        boolean[] visited = new boolean[n];

        while (!pq.isEmpty()){
            Node cur = pq.poll();
            int u = cur.id;

            if(visited[u]) continue;
            visited[u] = true;

            for(Edge edge : adj.get(u)){
                int v = edge.to;

                if(!visited[v] && dist[u] + edge.weight < dist[v]){
                    dist[v] = dist[u] + edge.weight;
                    pq.offer(new Node(v, dist[v]));
                }
            }
        }

        return dist;
    }
}
