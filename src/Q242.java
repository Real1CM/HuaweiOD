import java.util.Scanner;
import java.util.StringJoiner;

public class Q242 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        int n = sc.nextInt();

        if (s < n) {
            System.out.println(-1);
            return;
        }

        int res = -1;
        for (int i = s / (n + 1); i < s / (n - 1); ) {
            int start = i;
            int curSum = start;
            for (int j = 1; j < n; j++) curSum += start + j;

            if (curSum == s) {
                res = i;
                break;
            }

            int diff = s - curSum;
            if (diff < 0) {
                System.out.println(-1);
                return;
            }

            if (diff >= n) {
                i += diff / n;
            } else i++;
        }

        StringJoiner sj = new StringJoiner(" ");
        for (int i = 0; i < 6; i++) {
            sj.add(res + "");
            res++;
        }
        System.out.println(sj);
    }
}
