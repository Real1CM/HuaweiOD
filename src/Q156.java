import java.util.Scanner;

public class Q156 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        int res = 0;
        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().trim().split(",");

            StringBuilder sb = new StringBuilder();
            for (String num : s) sb.append(num);
            String base = sb.toString() + sb.toString();

            int cur = 0;
            for (int j = 0; j < n; j++) {
                String sub = base.substring(j, j + n);
                int curV = Integer.parseInt(sub, 2);
                if (curV > cur) cur = curV;
            }

            res += cur;
        }

        System.out.println(res);
    }
}