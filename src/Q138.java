import java.util.Arrays;
import java.util.Scanner;

public class Q138 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        int[] b = new int[n];
        for (int i = 0; i < n; i++) b[i] = sc.nextInt();

        Arrays.sort(a);
        Arrays.sort(b);

        int cnt = 0;
        int aMin = 0, aMax = n - 1;
        int bMin = 0, bMax = n - 1;

        while (aMin <= aMax) {
            if (a[aMax] > b[bMax]) {
                cnt++;
                aMax--;
                bMax--;
            } else if (a[aMin] > b[bMin]) {
                cnt++;
                aMin++;
                bMin++;
            } else {
                if (a[aMin] < b[bMax]) cnt--;

                aMin++;
                bMax--;
            }
        }

        System.out.println(cnt);
    }
}
