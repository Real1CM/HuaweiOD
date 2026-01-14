import java.util.*;

public class Q22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;
        String[] str = sc.nextLine().split("\\s+");

        Map<String, List<String>> adj = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();
        Set<String> allNodes = new HashSet<>();

        for (String s : str) {
            String[] node = s.split("->");
            String u = node[0];
            String v = node[1];

            allNodes.add(u);
            allNodes.add(v);

            inDegree.put(u, inDegree.getOrDefault(u, 0) + 1);
            inDegree.putIfAbsent(v, 0);

            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        PriorityQueue<String> pq = new PriorityQueue<>();
        for (String u : allNodes) {
            if (inDegree.getOrDefault(u, 0) == 0) {
                pq.offer(u);
            }
        }

        List<String> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            String u = pq.poll();
            res.add(u);

            if (adj.containsKey(u)) {
                for (String v : adj.get(u)) {
                    inDegree.put(v, inDegree.get(v) - 1);
                    if (inDegree.get(v) == 0) {
                        pq.offer(v);
                    }
                }
            }
        }

        System.out.println(String.join(" ", res));
    }
}
