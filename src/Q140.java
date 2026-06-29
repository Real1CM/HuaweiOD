import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q140 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().trim().split("\\s+");

        int len = str.length;
        int[] a = new int[len];
        for (int i = 0; i < len; i++) a[i] = Integer.parseInt(str[i]);

        System.out.println(solve(a));
    }

    private static int solve(int[] a) {
        int len = a.length;

        if (len <= 1) return 0;

        Queue<Integer> q = new LinkedList<>();

        int[] visited = new int[len];
        for (int i = 0; i < len; i++) visited[i] = -1;

        int maxFirstStep = len / 2;
        for (int step = 1; step < maxFirstStep; step++) {
            visited[step] = 1;
            q.offer(step);
        }

        while (!q.isEmpty()) {
            int curIdx = q.poll();
            int curSteps = visited[curIdx];

            if (curIdx == len - 1) return curSteps;

            int nextIdx = curIdx + a[curIdx];

            if (nextIdx < len && visited[nextIdx] == -1) {
                visited[nextIdx] = curSteps + 1;
                q.offer(nextIdx);
            }
        }

        return visited[len - 1];
    }
}
