import java.util.Scanner;

public class Q206 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int col = (n + m - 1) / m;
        String[][] map = new String[m][col];

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        int r = 0, c = 0;
        int dir = 0;

        int totalCells = m * col;
        for (int cnt = 1; cnt <= totalCells; cnt++) {
            if (cnt <= n) {
                map[r][c] = cnt + "";
            } else {
                map[r][c] = "*";
            }

            int nr = r + dr[dir];
            int nc = c + dc[dir];
            if (nr < 0 || nr >= m || nc < 0 || nc >= col || map[nr][nc] != null) {
                dir = (dir + 1) % 4;
                nr = r + dr[dir];
                nc = c + dc[dir];
            }
            r = nr;
            c = nc;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < col; j++) {
                sb.append(map[i][j]);
                if (j < col - 1) sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
