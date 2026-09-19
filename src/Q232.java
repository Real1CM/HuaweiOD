import java.util.*;

public class Q232 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String blockS = sc.nextLine().trim();
        String[] blockT = blockS.replaceAll("[\\[\\]\\s]", "").split(",");
        List<int[]> intervals = new ArrayList<>();
        for (int i = 0; i < blockT.length; i += 2) {
            intervals.add(new int[]{Integer.parseInt(blockT[i]), Integer.parseInt(blockT[i + 1])});
        }

        String subS = sc.nextLine().trim();
        String[] subT = subS.replaceAll("[\\[\\]\\s]", "").split(",");
        int[] connectors = new int[subT.length];
        for (int i = 0; i < subT.length; i++) {
            connectors[i] = Integer.parseInt(subT[i].trim());
        }

        if (intervals.isEmpty()) {
            System.out.println(0);
            return;
        }

        intervals.sort(Comparator.comparingInt(a -> a[0]));

        List<int[]> merged = new ArrayList<>();
        int[] cur = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            int[] nxt = intervals.get(i);
            if (nxt[0] <= cur[1]) {
                cur[1] = Math.max(cur[1], nxt[1]);
            } else {
                merged.add(cur);
                cur = nxt;
            }
        }
        merged.add(cur);

        int m = merged.size();
        if (m <= 1) {
            System.out.println(m);
            return;
        }

        List<Integer> gaps = new ArrayList<>();
        for (int i = 0; i < m - 1; i++) {
            gaps.add(merged.get(i + 1)[0] - merged.get(i)[1]);
        }

        Collections.sort(gaps);
        Arrays.sort(connectors);

        int gapIdx = 0;
        int connIdx = 0;
        int connectedCount = 0;
        while (gapIdx < gaps.size() && connIdx < connectors.length) {
            if(connectors[connIdx]>=gaps.get(gapIdx)){
                gapIdx++;
                connectedCount++;
            }
            connIdx++;
        }
        System.out.println(m-connectedCount);
    }
}
