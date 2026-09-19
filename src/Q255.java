import java.util.Scanner;

public class Q255 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n == 0) {
            System.out.println("1");
            return;
        } else if (n == 1) {
            System.out.println("11");
            return;
        }

        String cur = "11";
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();

            int len = cur.length();
            int cnt = 1;
            for (int j = 1; j < len; j++) {
                if (cur.charAt(j) == cur.charAt(j - 1)) cnt++;
                else {
                    sb.append(cnt).append(cur.charAt(j - 1));
                    cnt = 1;
                }
            }
            sb.append(cnt).append(cur.charAt(len - 1));
            cur = sb.toString();
        }
        System.out.println(cur);
    }
}
