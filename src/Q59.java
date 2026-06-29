import java.io.*;
import java.util.*;

public class Q59 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        String line1 = br.readLine();
        if (line1 == null || line1.trim().isEmpty()) return;
        StringTokenizer st = new StringTokenizer(line1);
        List<int[]> time = new ArrayList<>();
        while (st.hasMoreTokens()) {
            time.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        time.sort(Comparator.comparingInt(x -> x[0]));

        String line2 = br.readLine();
        if (line2 == null || line2.trim().isEmpty()) return;
        String[] subTokens = line2.trim().split("\\s+");
        List<int[]> subscriber = new ArrayList<>();
        int importance = 0;
        for (int i = 0; i < subTokens.length; i += 2) {
            if (i + 1 < subTokens.length) {
                int subTime = Integer.parseInt(subTokens[i]);
                int unsubTime = Integer.parseInt(subTokens[i + 1]);
                subscriber.add(new int[]{subTime, unsubTime, importance});
                importance++;
            }
        }

        List<Integer>[] res = new List[importance];
        for (int i = 0; i < importance; i++) res[i] = new ArrayList<>();

        for (int[] t : time) {
            int arriveTime = t[0];
            int content = t[1];

            int maxImportant = Integer.MIN_VALUE;
            for (int i = subscriber.size() - 1; i >= 0; i--) {
                int[] s = subscriber.get(i);
                int subTime = s[0];
                int unsubTime = s[1];
                int important = s[2];

                if (arriveTime >= subTime && arriveTime < unsubTime) {
                    maxImportant = important;
                    break;
                }
            }
            if (maxImportant != Integer.MIN_VALUE)
                res[maxImportant].add(content);
        }

        for (int i = 0; i < importance; i++) {
            int size = res[i].size();

            if (size == 0) {
                pw.println(-1);
            }else {
                for (int j = 0; j < size; j++) {
                    pw.print(res[i].get(j));
                    pw.print(j != size - 1 ? " " : "");
                }
                pw.println();
            }
        }

        pw.flush();
        pw.close();
    }
}
