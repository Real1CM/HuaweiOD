import java.util.Scanner;

public class Q149 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int tar = Integer.bitCount(n);

        int m = n + 1;
        while (Integer.bitCount(m) != tar) m++;

        System.out.println(m);
    }

    private static int countOne(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt += (n & 1);
            n >>>= 1;
        }
        return cnt;
    }

    private static int count(int n) {
        int cnt = 0;
        while (n != 0) {
            n = n & (n - 1);
            cnt++;
        }
        return cnt;
    }
}