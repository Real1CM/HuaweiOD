import java.util.Scanner;

public class Q275 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        int t = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        int d = t - s;

        int res = 0;
        while (true) {
            if ((d - res * a) % b == 0) break;
            if ((d + res * a) % b == 0) break;
            res++;
        }
        System.out.println(res);
    }
}
