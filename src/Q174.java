import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q174 {
    private static int minLeafVal = Integer.MAX_VALUE;
    private static List<Integer> best = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] parts = sc.nextLine().trim().split("\\s+");
        int n = parts.length;

        int[] a = new int[n + 1];
        for (int i = 0; i < n; i++) a[i + 1] = Integer.parseInt(parts[i]);

        List<Integer> path = new ArrayList<>();
        dfs(a, 0, path);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < best.size(); i++) {
            sb.append(best.get(i));
            if (i < best.size() - 1) sb.append(" ");
        }
        System.out.print(sb);
    }

    private static void dfs(int[] a, int idx, List<Integer> path) {
        if (idx >= a.length || a[idx] == -1) return;

        path.add(a[idx]);

        int lC = idx * 2;
        int rC = idx * 2 + 1;

        boolean noL = lC > a.length || a[lC] == -1;
        boolean noR = rC > a.length || a[rC] == -1;

        if (noL && noR) {
            int curVal = a[idx];
            if (curVal < minLeafVal) {
                minLeafVal = curVal;
                best = new ArrayList<>(path);
            }
        } else {
            dfs(a, lC, path);
            dfs(a, rC, path);
        }

        path.removeLast();
    }
}
