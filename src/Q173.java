import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q173 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        List<int[]> points = new ArrayList<>();
        while (st.hasMoreTokens())
            points.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});

        int n = points.size();
        if (n <= 2) {
            System.out.println(line.trim());
            return;
        }

        List<int[]> res = new ArrayList<>();
        res.add(points.get(0));
        for (int i = 1; i < n - 1; i++) {
            int[] pre = points.get(i - 1);
            int[] cur = points.get(i);
            int[] nxt = points.get(i + 1);

            int x1 = cur[0] - pre[0];
            int y1 = cur[1] - pre[1];

            int x2 = nxt[0] - cur[0];
            int y2 = nxt[1] - cur[1];

            if (x1 * y2 != x2 * y1) res.add(cur);
        }

        res.add(points.get(n - 1));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.size(); i++) {
            sb.append(res.get(i)[0]).append(" ").append(res.get(i)[1]);
            if (i < res.size() - 1) {
                sb.append(" ");
            }
        }
        System.out.print(sb);
    }
}
