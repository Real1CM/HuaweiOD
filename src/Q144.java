import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Q144 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().trim().split(",");
        int strength = sc.nextInt();

        int[] a = new int[s.length];
        List<Integer> ground = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(s[i]);
            if (a[i] == 0) ground.add(i);
        }

        if (ground.isEmpty()) {
            System.out.println(0);
            return;
        }

        List<Integer> peaks = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if (i == 0) {
                if (a[i] > a[i + 1]) peaks.add(i);
            } else if (i == a.length - 1) {
                if (a[i] > a[i - 1]) peaks.add(i);
            } else {
                if (a[i] > a[i - 1] && a[i] > a[i + 1]) peaks.add(i);
            }
        }

        int res = 0;
        for (int peak : peaks) {
            int best = Integer.MAX_VALUE;

            for (int g1 : ground) {
                for (int g2 : ground) {
                    int up = getCost(a, g1, peak);
                    int down = getCost(a, peak, g2);

                    best = Math.min(best, up + down);
                }
            }

            if (best < strength) res++;
        }

        System.out.println(res);
    }

    private static int getCost(int[] a, int start, int end) {
        int cost = 0;
        if (start < end) {
            for (int i = start; i < end; i++) {
                int diff = a[i + 1] - a[i];
                cost += (diff > 0) ? diff * 2 : -diff;
            }
        } else {
            for (int i = start; i > end; i--) {
                int diff = a[i - 1] - a[i];
                cost += (diff > 0) ? diff * 2 : -diff;
            }
        }
        return cost;
    }
}
