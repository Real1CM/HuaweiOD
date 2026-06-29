import java.util.*;

public class Q372 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            for (int s = 0; s < N - i; s++) {
                System.out.print("    ");
            }

            List<String> list = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                cnt++;
                 list.add(form(cnt));
            }

            if (i % 2 == 0) Collections.reverse(list);

            StringJoiner sj = new StringJoiner("    ");
            for(String s : list) {
                sj.add(s);
            }
            System.out.println(sj);
        }
    }

    private static String form(int cnt) {
        StringBuilder sb = new StringBuilder(String.valueOf(cnt));
        while (sb.length() < 4) {
            sb.append("*");
        }

        return sb.toString();
    }
}
