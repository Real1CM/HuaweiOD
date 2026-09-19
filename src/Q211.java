import java.util.*;

public class Q211 {
    static class Task {
        int sla;
        int v;
        boolean used;

        Task(int sla, int v) {
            this.sla = sla;
            this.v = v;
            this.used = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();

        Task[] tasks = new Task[n];
        for (int i = 0; i < n; i++) {
            int sla = sc.nextInt();
            int v = sc.nextInt();
            tasks[i] = new Task(sla, v);
        }

        Arrays.sort(tasks, (a, b) -> {
            if (a.sla != b.sla) return Integer.compare(a.sla, b.sla);
            return Integer.compare(b.v, a.v);
        });

        int res = 0;
        for (int i = 1; i <= t; i++) {
            PriorityQueue<Task> pq = new PriorityQueue<>((a, b) -> {
                return Integer.compare(b.v, a.v);
            });

            for (Task cur : tasks) {
                if (!cur.used && cur.sla <= i) {
                    cur.used = true;
                    pq.offer(cur);
                }
            }

            if (!pq.isEmpty())
                res += pq.poll().v;
        }

        System.out.println(res);
    }
}
