import java.util.Arrays;
import java.util.Scanner;

public class Q202 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] a = Arrays.stream(sc.nextLine().trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int k = sc.nextInt();

        int cnt = 0;
        for (int n : a) {
            if (n < k) cnt++;
        }

        if (cnt <= 1) {
            System.out.println(0);
            return;
        }

        int upCnt = 0;
        for (int i = 0; i < cnt; i++) {
            if (a[i] >= k)
                upCnt++;
        }

        int minCnt = upCnt;
        for (int i = cnt; i < a.length; i++) {
            if (a[i - cnt] >= k) upCnt--;
            if (a[i] >= k) upCnt++;

            minCnt = Math.min(minCnt, upCnt);
        }

        System.out.println(minCnt);
    }
}