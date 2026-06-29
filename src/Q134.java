import java.util.Scanner;

public class Q134 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n == 0) {
            System.out.println(1);
            return;
        } else if (n == 1 || n == 2) {
            System.out.println(1);
            return;
        } else if (n == 3) {
            System.out.println(2);
            return;
        }

        long[] a = new long[n + 1];
        a[1] = 1;
        a[2] = 1;
        a[3] = 2;
        for (int i = 4; i <= n; i++) {
            a[i] = a[i - 1] + a[i - 3];
        }

        System.out.println(a[n]);
    }
}