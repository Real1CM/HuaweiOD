import java.util.Arrays;
import java.util.Scanner;

public class Q266 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] a = Arrays.stream(sc.nextLine().trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int win = sc.nextInt();

        int zero = 0, one = 0, two = 0;
        for (int i = 0; i < Math.min(a.length, win); i++) {
            if (a[i] == 0) zero++;
            else if (a[i] == 1) one++;
            else if (a[i] == 2) two++;

        }
        int max = Math.max(zero, Math.max(one, two));

        if (a.length <= win) {
            System.out.println(max);
            return;
        }

        for (int i = 1; i <= a.length - win; i++) {
            if (a[i - 1] == 0) zero--;
            else if (a[i - 1] == 1) one--;
            else if (a[i - 1] == 2) two--;

            if (a[i + win - 1] == 0) zero++;
            else if (a[i + win - 1] == 1) one++;
            else if (a[i + win - 1] == 2) two++;

            int curMax = Math.max(zero, Math.max(one, two));

            max = Math.max(max, curMax);
        }
        System.out.println(max);
    }
}
