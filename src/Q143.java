import java.util.Scanner;

public class Q143 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine().trim();

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';

            if (digit > 4) digit--;

            res = res * 9 + digit;
        }

        System.out.println(res);
    }
}
