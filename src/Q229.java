import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q229 {
    static int m, n;
    static int[] a;
    static boolean[] used;

    static int maxReachBelowM = Integer.MIN_VALUE;
    static List<Integer> bestPath = new ArrayList<>();
    static boolean foundExact = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();

        Arrays.sort(a);
        for (int i = 0; i < n / 2; i++) {
            int tmp = a[i];
            a[i] = a[n - 1 - i];
            a[n - 1 - i] = tmp;
        }

        used = new boolean[n];
        List<Integer> curPath = new ArrayList<>();
        dfs(0, 0, true, curPath);

        for (int i = 0; i < bestPath.size(); i++) {
            System.out.println(bestPath.get(i) + ((i == bestPath.size() - 1) ? "" : " "));
        }
        System.out.println();
    }

    private static void dfs(int depth, int curFloor, boolean isUp, List<Integer> path) {
        if (foundExact) return;

        if (depth == n) {
            if (curFloor == n) {
                foundExact = true;
                maxReachBelowM = curFloor;
                bestPath = new ArrayList<>(path);
            } else if (curFloor < m) {
                if (curFloor > maxReachBelowM) {
                    maxReachBelowM = curFloor;
                    bestPath = new ArrayList<>(path);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                used[i] = true;
                path.add(a[i]);

                int nextFloor = isUp ? curFloor + a[i] : curFloor - a[i];
                dfs(depth + 1, nextFloor, !isUp, path);

                path.removeLast();
                used[i] = false;

                if (foundExact) return;
            }
        }
    }
}