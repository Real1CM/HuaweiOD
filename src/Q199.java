import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q199 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        List<Queue<String>> lists = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line.trim());
            Queue<String> queue = new LinkedList<>();
            while (st.hasMoreTokens()) {
                queue.offer(st.nextToken());
            }
            lists.add(queue);
        }

        List<String>[] windows = new List[n];
        for (int j = 0; j < n; j++) windows[j] = new ArrayList<>();

        int totalNeed = n * k;
        int totalCollected = 0;

        int listIdx = 0, winIdx = 0;
        int listNum = lists.size();
        while (totalCollected < totalNeed) {
            Queue<String> curList = lists.get(listIdx);

            int takeCount = Math.min(n, curList.size());
            for (int i = 0; i < takeCount; i++) {
                while (windows[winIdx].size() == k) {
                    winIdx = (winIdx + 1) % n;
                }

                windows[winIdx].add(curList.poll());
                totalCollected++;
                winIdx = (winIdx + 1) % n;

                if (totalNeed == totalCollected) break;
            }

            listIdx = (listIdx + 1) % listNum;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (String val : windows[i]) {
                sb.append(val).append(" ");
            }
        }

        if (!sb.isEmpty()) {
            sb.setLength(sb.length() - 1);
        }
        System.out.println(sb);
    }
}
