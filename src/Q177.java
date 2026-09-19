import java.util.Arrays;
import java.util.Scanner;

public class Q177 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] str = sc.nextLine().trim().split("\\s+");

        if (str[0].length() > str[1].length()) {
            System.out.print(-1);
            return;
        }

        int[] s1 = new int[26];
        int[] s2 = new int[26];

        for (int i = 0; i < str[0].length(); i++) {
            s1[str[0].charAt(i) - 'a']++;
            s2[str[1].charAt(i) - 'a']++;
        }

        if (Arrays.equals(s1, s2)) {
            System.out.print(0);
            return;
        }

        int res = -1;
        for (int i = str[0].length(); i < str[1].length(); i++) {
            char tmp = str[1].charAt(i);
            char last = str[1].charAt(i - str[0].length());

            s2[tmp - 'a']++;
            s2[last - 'a']--;

            if (Arrays.equals(s1, s2)) {
                res = i - str[0].length() + 1;
                break;
            }
        }

        System.out.print(res);
    }
}
