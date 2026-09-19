import java.util.Scanner;

public class Q166 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int r = sc.nextInt();

        int[] a = new int[m];
        for (int i = 0; i < m; i++) a[i] = sc.nextInt();
        int[] b = new int[n];
        for (int i = 0; i < n; i++) b[i] = sc.nextInt();

        int j = 0;
        for (int i = 0; i < m; i++) {
            while (j < n && a[i] > b[i]) j++;

            if (j < n && b[j] - a[i] <= r) System.out.println(a[i] + " " + b[i]);
        }
    }
}
