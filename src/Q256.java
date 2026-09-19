import java.util.Scanner;

public class Q256 {
    static int n;
    static int[][] map;
    static boolean[] used;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        used = new boolean[n];
        int cnt = 0;
        for (int i = 0;i<n;i++){
            if(!used[i]) {
                cnt++;
                dfs(i);
            }
        }

        System.out.println(cnt);
    }

    private static void dfs(int idx) {
        used[idx] = true;
        for (int i = idx; i < n; i++) {
            if (map[idx][i] == 1 && !used[i]) dfs(i);
        }
    }
}
