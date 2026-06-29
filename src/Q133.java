import java.util.Scanner;

public class Q133 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int width = sc.nextInt();
        int val = sc.nextInt();

        int[][] pre = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int curVal = sc.nextInt();

                pre[i][j] = curVal + pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1];
            }

        }

        if (width > m || width > n) {
            System.out.println(0);
            return;
        }

        int cnt = 0;
        for (int i = width; i <= m; i++) {
            for (int j = width; j <= n; j++) {
                int totalVal = pre[i][j] - pre[i - width][j] - pre[i][j - width] + pre[i - width][j - width];
                if (totalVal >= val) cnt++;
            }
        }

        System.out.println(cnt);
    }
}