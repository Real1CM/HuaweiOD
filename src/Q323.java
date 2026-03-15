import java.util.Scanner;

public class Q323 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int charIdx = s.charAt(i) - 'a';
            int numIdx = s.charAt(i) - '0';

            if (charIdx >= 0 && charIdx <= 26) {
                sb.append(s.charAt(i));
                continue;
            }
            if (numIdx > 2 && numIdx <= 9) {
                i++;

                for (int j = 0; j < numIdx; j++) {
                    sb.append(s.charAt(i));
                }
                continue;
            }

            break;
        }

        if (sb.length() > s.length()) System.out.println(sb);
        else System.out.println("!error");
    }
}
