import java.util.*;

public class Q116 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Map<Integer, List<int[]>> sum = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int curSum = 0;
            for (int j = 0; i < n; j++) {
                curSum += arr[j];
                sum.computeIfAbsent(curSum, k -> new ArrayList<>()).add(new int[]{i, j});
            }
        }

        int maxCnt = 0;
        for (List<int[]> lists : sum.values()) {
            lists.sort((a, b) -> Integer.compare(a[1], b[1]));

            int cnt = 0;
            int lastEnd = -1;

            for (int[] list : lists) {
                if (list[0] > lastEnd) {
                    cnt++;
                    lastEnd = list[1];
                }
            }

            maxCnt = Math.max(cnt, maxCnt);
        }

        System.out.println(maxCnt);
    }
}
