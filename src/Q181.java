import java.util.Scanner;

public class Q181 {
    private static int cnt = 0;
    private static String res = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        boolean[] used = new boolean[n + 1];

        solve(n, k, new StringBuilder(), used);

        System.out.println(res);
    }

    private static void solve(int n, int k, StringBuilder path, boolean[] used) {
        if (!res.isEmpty()) return;

        if (path.length() == n) {
            cnt++;
            if (cnt == k) {
                res = path.toString();
            }
        }

        for (int i = 1; i <= n; i++) {
            if (used[i]) continue;

            path.append(i);
            used[i] = true;

            solve(n, k, path, used);

            used[i] = false;
            path.deleteCharAt(path.length() - 1);
        }
    }
}