import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q279 {
    static int[][] map = new int[19][19];
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static List<int[]> black = new ArrayList<>();
    static List<int[]> white = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        while (st.hasMoreTokens()) {
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
            black.add(new int[]{x, y});
        }

        st = new StringTokenizer(br.readLine().trim());
        while (st.hasMoreTokens()) {
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 2;
            white.add(new int[]{x, y});
        }

        int blackRes = solve(black);
        int whiteRes = solve(white);
        System.out.println(blackRes + " " + whiteRes);
    }

    private static int solve(List<int[]> list) {
        Set<Integer> set = new HashSet<>();

        for (int[] cur : list) {
            for (int[] dir : dirs) {
                int nx = cur[0] + dir[0];
                int ny = cur[1] + dir[1];

                if (nx >= 0 && nx < 19 && ny >= 0 && ny < 19 && map[nx][ny] == 0)
                    set.add(nx * 19 + ny);
            }
        }

        return set.size();
    }
}
