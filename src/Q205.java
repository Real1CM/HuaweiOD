import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q205 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine().trim();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                i++;
                StringBuilder sb = new StringBuilder();
                while (s.charAt(i) != ')') {
                    sb.append(s.charAt(i));
                    i++;
                }
                list.add(sb.toString());
            }
        }

        String maxS = "";
        int max = 0;
        for (String str : list) {
            String[] token = str.split(",");
            if (token[0].startsWith("0") || token[1].startsWith("0")) continue;

            int x = Integer.parseInt(token[0]);
            int y = Integer.parseInt(token[1]);
            if (x == 0 || y == 0) continue;

            int cur = x * x + y * y;
            if (cur > max) {
                max = cur;
                maxS = str;
            }
        }

        if (maxS == "") System.out.println("(0,0)");
        else System.out.println("(" + maxS + ")");
    }
}
