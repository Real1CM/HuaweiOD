import java.util.Scanner;

public class Q209 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] s = sc.nextLine().trim().toCharArray();

        for (int i = 0; i < s.length; i++) {
            char minC = s[i];
            int minIdx = -1;

            for (int j = i + 1; j < s.length; j++) {
                if (s[j] <= minC) {
                    minC = s[j];
                    minIdx = j;
                }
            }

            if (minC < s[i]) {
                char tmp = s[i];
                s[i] = s[minIdx];
                s[minIdx] = tmp;
                break;
            }
        }

        System.out.println(new String(s));
    }
}
