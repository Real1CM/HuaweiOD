import java.util.Arrays;
import java.util.Scanner;

public class Q195 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        int[][] rope = new int[n][2];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String[] parts = line.split(",");
            rope[i][0] = Integer.parseInt(parts[0]);
            rope[i][1] = Integer.parseInt(parts[1]);
        }

        Arrays.sort(rope, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(b[1], a[1]);
        });

        int cnt = 1;
        int i = 0;
        int curR = rope[i][1];
        while (i < n) {
            int maxR = curR;

            while (i < n && rope[i][0] <= curR) {
                maxR = Math.max(maxR, rope[i][1]);
                i++;
            }

            if (maxR != curR) {
                cnt++;
                curR = maxR;
            }
        }

        System.out.println(cnt);
    }
}