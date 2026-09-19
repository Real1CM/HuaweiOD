import java.util.*;

public class Q220 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        int[] inDegree = new int[n];

        while (sc.hasNextInt()) {
            int in = sc.nextInt();
            int out = sc.nextInt();
            adj.get(in).add(out);
            inDegree[out]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) q.offer(i);
        }

        int visitCnt = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            visitCnt++;

            for (int nxt : adj.get(cur)) {
                inDegree[nxt]--;
                if (inDegree[nxt] == 0) q.offer(nxt);
            }
        }

        if (visitCnt == n) System.out.println("yes");
        else System.out.println("no");
    }
}
