import java.util.Scanner;

public class Q192 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] a = new long[n + 1];
        long[] family = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
            family[i] = a[i];
        }

        for (int i = 0; i < n - 1; i++) {
            int father = sc.nextInt();
            int son = sc.nextInt();
            family[father] += a[son];
        }

        long max = 0;
        for (int i = 1; i <= n; i++) max = Math.max(max, family[i]);

        System.out.println(max);
    }
}
