import java.util.Scanner;

public class Q5 {
    static int M;   //节点
    static int N;   //边
    static boolean[][] adj; //邻接矩阵
    static int[] color; //染色列
    static long num = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();

        adj = new boolean[M + 1][M + 1];
        color = new int[M + 1];

        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj[a][b] = true;
            adj[b][a] = true;
        }

        solve(1);

        System.out.println(num);
    }

    private static void solve(int n) {
        if(n > M) {
            num++;
            return;
        }

        color[n] = 0;
        solve(n + 1);

        boolean canRed = true;
        for (int i = 1; i <= M; i++) {
            if(adj[n][i] && color[i] == 1) {
                canRed = false;
                break;
            }
        }
        if(canRed) {
            color[n] = 1;
            solve(n + 1);
        }

        color[n] = 0;
    }
}
