import java.util.Arrays;
import java.util.Scanner;

public class Q223 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] a = new long[n];
        long total = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
            total += a[i];
        }

        long l = 0;
        long res = 0;
        for (int i = 0; i < n - 1; i++) {
            l += a[i];
            long diff = Math.abs(2 * l - total);

            res = Math.max(res, diff);
        }
        System.out.println(res);
    }
}