import java.util.Arrays;
import java.util.Scanner;

public class Q208 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] a = Arrays.stream(sc.nextLine().trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int curSum = 0;
        int curMinus = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            curSum += a[i];

            if (i > 0) {
                for (int j = i - 1; j >= 0; j--)
                    curMinus += a[j];
            }

            res = Math.max(res, curSum - curMinus);
        }

        System.out.println(res);
    }
}
