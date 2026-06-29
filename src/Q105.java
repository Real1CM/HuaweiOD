import java.util.Arrays;
import java.util.Scanner;

public class Q105 {
    static int[] device;
    static int[][] history;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        device = new int[n + 1];
        for (int i = 1; i <= n; i++) device[i] = sc.nextInt();

        history = new int[m + 1][2];
        for (int i = 1; i <= m; i++) {
            int opType = sc.nextInt();
            int val = sc.nextInt();

            if (opType == 1) {
                int res = acquire(i, val);
                System.out.println(res);
            } else if (opType == 2) {
                release(val);
            }
        }
    }

    private static int acquire(int opIdx, int num) {
        int bestId = 0;
        int min = Integer.MAX_VALUE;

        for (int id = 1; id < device.length; id++) {
            int curFree = device[id];

            if (curFree >= num && curFree < min) {
                min = curFree;
                bestId = id;
            }
        }

        if (bestId != 0) {
            device[bestId] -= num;
            history[opIdx][0] = bestId;
            history[opIdx][1] = num;
        }

        return bestId;
    }

    private static void release(int num) {
        if (num >= history.length || history[num][0] == 0) return;

        int tar = history[num][0];
        int resource = history[num][1];

        device[tar] += resource;

        history[num][0] = 0;
        history[num][1] = 0;
    }
}