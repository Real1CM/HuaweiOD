import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q267 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] tokens = sc.nextLine().trim().split("\\s+");
        Set<String> wordSet = new HashSet<>(Arrays.asList(tokens));

        String bestPwd = "";

        for (String s : tokens) {
            boolean isValid = true;

            for (int i = 1; i <= s.length(); i++) {
                if (!wordSet.contains(s.substring(0, i))) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                if (s.length() > bestPwd.length()) bestPwd = s;
                else if (s.length() == bestPwd.length() && s.compareTo(bestPwd) > 0) bestPwd = s;
            }
        }

        System.out.println(bestPwd);
    }
}
