import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T > 0) {
            int n = sc.nextInt();
            long k = sc.nextInt();

            char result = recurrsive(n, k);

            if(result == 'R'){
                System.out.println("RED");
            } else {
                System.out.println("BLUE");
            }
            T--;
        }
    }

    public static char recurrsive(int n, long k) {
        if(n == 1)
            return 'R';

        long half = 1L << (n - 2); //右移，相当于乘2，即2^n

        if(k < half)
            return invert(recurrsive(n - 1, k));
        else
            return recurrsive(n - 1, k - half);
    }

    public static char invert(char c) {
        if(c == 'R')
            return 'B';
        else
            return 'R';
    }
}
