import java.util.Arrays;
import java.util.Scanner;

public class Q106 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        Arrays.sort(a);

        int left = a[0], right = a[0] + m;
        int ans = a[0];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            boolean flag = false;
            int curM = m;
            for (int i = 0; i < n; i++) {
                if (mid > a[i]) curM -= mid - a[i];
                if (curM < 0) {
                    flag = true;
                    break;
                }
            }

            if (flag) right = mid - 1;
            else {
                ans = mid;
                left = mid + 1;
            }
        }

        System.out.println(ans);
    }
}