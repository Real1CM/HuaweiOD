import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q185 {
    static String[] alphabet = {
            "abc", "def", "ghi", "jkl", "mno", "pqr", "st", "uv", "wx", "yz"
    };
    static List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String digits = sc.nextLine().trim();
        String deny = sc.nextLine().trim();

        solve(digits, 0, new StringBuilder(), deny);
        System.out.println(String.join(" ", res));
    }

    private static void solve(String digits, int idx, StringBuilder cur, String deny) {
        if (idx == digits.length()) {
            String combined = cur.toString();
            if (!filter(combined, deny)) res.add(combined);
            return;
        }

        int digitNum = digits.charAt(idx) - '0';
        String letters = alphabet[digitNum];

        for (int i = 0; i < letters.length(); i++) {
            cur.append(letters.charAt(i));
            solve(digits, idx + 1, cur, deny);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    private static boolean filter(String combined, String deny) {
        if (deny.isEmpty()) return false;

        for (int i = 0; i < deny.length(); i++) {
            char denyChar = deny.charAt(i);
            if (combined.indexOf(denyChar) == -1) return false;
        }
        return true;
    }
}
