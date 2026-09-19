import java.util.Arrays;
import java.util.Scanner;

public class Q222 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int l = sc.nextInt();

        int rest = 0;
        for (int i = 0; i < l; i++) {
            int task = sc.nextInt();
            rest += task;

            if (rest > n) rest -= n;
            else rest = 0;
        }

        int restTime = (rest + n - 1) / n;
        System.out.println(restTime + l);
    }
}
