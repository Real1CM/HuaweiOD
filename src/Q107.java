import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q107 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        List<String> res = new ArrayList<>();
        for (int a = N; a <= M; a++) {
            for (int b = N + 1; b <= M; b++) {
                int c2 = a * a + b * b;
                int c = (int) Math.sqrt(c2);

                if (c > M) break;

                if (c * c == c2 && gcd(a, b) == 1) {
                    res.add(a + " " + b + " " + c);
                }
            }
        }

        if (res.isEmpty()) System.out.println("NA");
        else for (String s : res)
            System.out.println(s);
    }

    private static int gcd(int x, int y) {
        while (y != 0) {
            int tmp = x % y;
            x = y;
            y = tmp;
        }
        return x;
    }
}
