import java.util.Arrays;
import java.util.Scanner;

public class Q270 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] a = Arrays.stream(sc.nextLine().trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        long r = 1;
        for (int i = 1; i < a.length; i++) r *= a[i];

        if (r == 1) {
            System.out.println(0);
            return;
        }

        int l = 1;
        for (int i = 1; i < a.length; i++) {
            l *= a[i - 1];
            r /= a[i];
            if (l == r) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(-1);
    }
}
