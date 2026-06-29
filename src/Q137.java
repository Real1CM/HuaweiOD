import java.util.Scanner;

public class Q137 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();

        if (m <= 1 || m > +100) {
            System.out.println("ERROR!");
            return;
        }

        boolean[] a = new boolean[101];
        int n = 100;
        int i = 1;
        int cnt = 0;
        while (n >= m) {
            if (!a[i]) {
                cnt++;
                if (cnt == m) {
                    a[i] = true;
                    n--;
                    cnt = 0;
                }
            }
            i++;
            if (i > 100) i = 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 1; j <= 100; j++) {
            if (!a[j]) {
                if (!sb.isEmpty())
                    sb.append(",");
                sb.append(j);
            }
        }
        System.out.println(sb);
    }
}
