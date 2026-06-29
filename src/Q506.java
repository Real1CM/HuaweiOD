import java.io.*;
import java.util.*;

public class Q506 {
    static int[] parent;
    static int[] size;

    static int find(int p) {
        if (parent[p] == p) return p;
        return parent[p] = find(parent[p]);
    }

    static void union(int p, int q) {
        int p1 = find(p);
        int q1 = find(q);
        if (p1 != q1) {
            parent[p1] = q1;
            size[p1] += size[q1];
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] gird = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) gird[i][j] = line.charAt(j) - '0';
        }

        parent = new int[n * n];
        size = new int[n * n];
        for (int i = 0; i < n * n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int[][] neighbors = {{1, 0}, {0, 1}};
                for (int[] d : neighbors) {
                    int ni = i + d[0];
                    int nj = j + d[1];
                    if (ni < n && nj < n && gird[ni][nj] != gird[i][j]) {
                        union(i + n * j, ni + n * nj);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            sb.append(size[find(a * n + b)]).append('\n');
        }
        System.out.println(sb);
    }
}
