import java.util.Arrays;
import java.util.Scanner;

public class Q142 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt() + sc.nextInt();
        }
        Arrays.sort(a);

        int cnt = 0;
        int time = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] >= time) {
                cnt++;
                time = a[i] + m;
            }
        }

        System.out.println(cnt);
    }
}