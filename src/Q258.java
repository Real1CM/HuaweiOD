import java.util.*;

public class Q258 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] time = new int[n][2];
        for (int i = 0; i < n; i++) {
            time[i][0] = sc.nextInt();
            time[i][1] = sc.nextInt();
        }
        Arrays.sort(time, (x, y) -> {
            if (x[0] != y[0]) return Integer.compare(x[0], y[0]);
            return Integer.compare(x[1], y[1]);
        });

        int start = (n + m - 1) / m;
        int end = n;
        int res = n;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (isOk(mid, time, m)) {
                res = mid;
                end = mid - 1;
            } else start = mid + 1;
        }

        System.out.println(res);
    }

    private static boolean isOk(int num, int[][] time, int m) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < num; i++) pq.offer(new int[]{0, 0});

        for (int[] t : time) {
            int start = t[0];
            int end = t[1];

            List<int[]> tmp = new ArrayList<>();
            boolean assigned = false;

            while (!pq.isEmpty()) {
                int[] interviewer = pq.poll();

                if (interviewer[1] < m && interviewer[0] <= start) {
                    interviewer[0] = end;
                    interviewer[1]++;
                    pq.offer(interviewer);
                    assigned = true;
                    break;
                } else tmp.add(interviewer);
            }

            pq.addAll(tmp);
            if (!assigned) return false;
        }

        return true;
    }
}
