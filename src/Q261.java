import java.util.Arrays;
import java.util.Scanner;

public class Q261 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();

        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        Arrays.sort(a);

        int num = 0;
        int i = 0, j = a.length - 1;
        while (i <= j) {
            if (i == j) {
                num++;
                break;
            }

            if (a[i] + a[j] <= m) i++;

            j--;
            num++;

        }

        System.out.println(num);
    }
}
