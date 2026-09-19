import java.util.Scanner;

public class Q150 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int p = -1, q = -1;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                int tmp = n / i;
                if (isPrime(i) && isPrime(tmp)) {
                    p = i;
                    q = tmp;
                    break;
                }
            }
        }

        if (p == -1 && q == -1) System.out.println("-1 -1");
        System.out.println(p + " " + q);
    }

    private static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}