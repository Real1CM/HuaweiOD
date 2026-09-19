import java.util.Scanner;

public class Q252 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        if (n < 6) {
            System.out.println(0);
            return;
        }

        int[] sum = new int[n + 1];
        for (int i = 1; i <= n / 2; i++) {
            for (int j = i * 2; j <= n; j += i) {
                sum[j] += i;
            }
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (sum[i] == i) {
                count++;
            }
        }

        System.out.println(count);
    }
}
