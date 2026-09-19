import java.util.Arrays;
import java.util.Scanner;

public class Q187 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] a = Arrays.stream(sc.nextLine().trim().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        int lSum = 0;
        int rSum = 0;
        for (int i = 1; i < a.length; i++) {
            rSum += a[i];
        }

        if (lSum == rSum) {
            System.out.println(0);
            return;
        }

        int res = -1;
        for (int i = 1; i < a.length; i++) {
            lSum += a[i - 1];
            rSum -= a[i];

            if (lSum == rSum) {
                res = i;
                break;
            }
        }

        System.out.println(res);
    }
}
