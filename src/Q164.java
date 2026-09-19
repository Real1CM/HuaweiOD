import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q164 {
    private static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] a = Arrays.stream(sc.nextLine().trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        dfs(a, 0, 0);

        System.out.print(max);
    }

    private static void dfs(int[] a, int i, int curVal) {
        if (i >= a.length || a[i] == -1) return;

        curVal += a[i];

        int l = i * 2 + 1;
        int r = i * 2 + 2;
        boolean noL = l >= a.length || a[l] == -1;
        boolean noR = r >= a.length || a[r] == -1;

        if (noL && noR) {
            max = Math.max(max, curVal);
        }

        if (!noL) dfs(a, l, curVal);
        if (!noR) dfs(a, r, curVal);
    }
}
