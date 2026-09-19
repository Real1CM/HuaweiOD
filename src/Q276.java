import java.util.Scanner;
import java.util.StringJoiner;

public class Q276 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();

        for (int i = 0; i < n - 1; i++) {
            if (a[i] < a[i + 1]) a[i] = (a[i + 1] - a[i]) * (i + 1);
        }

        StringJoiner sj = new StringJoiner(" ");
        for (int i = 0; i < n; i++) sj.add(a[i] + "");
        System.out.println(sj.toString());
    }
}
