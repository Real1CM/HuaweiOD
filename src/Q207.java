import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Q207 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();

        if (m < 8) {
            System.out.println(0);
            return;
        }

        BigInteger[] a = new BigInteger[m + 1];
        BigInteger[] b = new BigInteger[m + 1];
        for (int i = 0; i <= m; i++) {
            a[i] = BigInteger.ZERO;
            b[i] = BigInteger.ZERO;
        }

        a[7] = BigInteger.ZERO;
        b[7] = BigInteger.ONE;

        for (int i = m; i >= 7; i--) {
            a[i] = b[i - 1].add(b[i - 2]);
            b[i] = a[i - 1].add(a[i - 2]);
        }
        System.out.println(a[m]);
    }
}