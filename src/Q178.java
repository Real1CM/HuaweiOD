import java.util.Scanner;

public class Q178 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();

        int res = 0;
        while (n != 1) {
            if (n == 3) {
                n -= 1;
            } else if (n % 2 == 0) {
                n /= 2;
            } else {
                if (n % 4 == 1) n -= 1;
                else if (n % 4 == 3) n += 1;
            }
            res++;
        }

        System.out.print(res);
    }
}