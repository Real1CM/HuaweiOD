import java.util.Arrays;
import java.util.Scanner;

public class Q159 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n + 1];
        Arrays.fill(a, 1);
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) a[sc.nextInt()] = 0;
        int k = sc.nextInt();

        int ans = 0;
        int l = 1;
        int dead = 0;
        for (int r = 1; r <= n; r++) {
            if (a[r] == 0) dead++;

            while (dead > k) {
                if (a[l] == 0) dead--;
                l++;
            }

            ans = Math.max(ans, r - l + 1);
        }

        System.out.println(ans);
    }
}
