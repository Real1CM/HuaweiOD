import java.io.*;
import java.util.*;

public class Q169 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] str = sc.nextLine().trim().split("\\s+");

        String s1 = str[0];
        String s2 = str[1];
        if (s1.length() > s2.length()) {
            s1 = str[1];
            s2 = str[0];
        }

        int l1 = s1.length();
        int l2 = s2.length();

        int[] dp = new int[l1 + 1];
        for (int i = 0; i <= l1; i++) dp[i] = i;

        for (int i = 1; i <= l2; i++) {
            int last = dp[0];
            dp[0]=i;
            for (int j = 1; j <= l1; j++) {
                int min = Math.min(dp[j] + 1, dp[j - 1] + 1);

                if (s1.charAt(j-1) == s2.charAt(i-1))
                    min = Math.min(min, last + 1);

                last = dp[j];
                dp[j] = min;
            }
        }

        System.out.println(dp[l1]);
    }
}