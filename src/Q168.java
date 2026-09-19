import java.util.Scanner;

public class Q168 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();

        int len = 0;
        for (int i = 1; i < n; i++) {
            if (a[i] + a[i - 1] < 100) len += (100 - a[i] - a[i - 1]);
        }

        System.out.println(len);
    }
}