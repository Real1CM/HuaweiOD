import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q158 {
    static class Node {
        int val;
        int id;
        int day;

        Node(int val, int id, int day) {
            this.val = val;
            this.id = id;
            this.day = day;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int N = sc.nextInt();

        int[] travel = new int[N + 1];
        int travelSum = 0;
        for (int i = 0; i < N + 1; i++) {
            travel[i] = sc.nextInt();
            travelSum += travel[i];
        }

        int K = T - travelSum;
        int[] M = new int[N];
        int[] D = new int[N];

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> b.val - a.val);

        for (int i = 0; i < N; i++) {
            if (M[i] > 0) pq.offer(new Node(M[i], i, 0));
        }

        long ans = 0;
        for (int i = 0; i < K; i++) {
            if (pq.isEmpty()) break;

            Node cur = pq.poll();
            ans += cur.val;

            int nextDay = cur.day + 1;
            int nextVal = M[cur.day] - nextDay * D[cur.id];
            if (nextVal > 0) pq.offer(new Node(nextVal, cur.id, nextDay));
        }

        System.out.println(ans);
    }
}