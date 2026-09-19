import java.util.Scanner;
import java.util.StringJoiner;

public class Q260 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] questions = sc.nextLine().trim().split(",");
        String[] answers = sc.nextLine().trim().split(",");

        StringJoiner sj = new StringJoiner(",");
        for (String q : questions) {
            String qKey = getKey(q);
            String matched = "not found";

            for (String a : answers) {
                if (qKey.equals(getKey(a))) {
                    matched = a;
                    break;
                }
            }
            sj.add(matched);
        }
        System.out.println(sj.toString());
    }

    private static String getKey(String s) {
        boolean[] hasChar = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            hasChar[s.charAt(i) - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (hasChar[i]) sb.append((char) ('a' + i));
        }
        return sb.toString();
    }
}
