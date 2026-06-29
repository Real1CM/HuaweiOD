import java.io.*;
import java.util.*;

public class Q280 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] configs = sc.nextLine().split(",");
        String s = sc.nextLine();

        List<String> res = new ArrayList<>();
        for (String config : configs) {
            if (solve(config, s)) res.add(config);
        }

        if (res.isEmpty()) System.out.println("null");
        else {
            Collections.sort(res);
            System.out.println(String.join(",", res));
        }
    }

    private static boolean solve(String config, String s) {
        if (!config.contains("*")) {
            if (config.length() != s.length()) return false;
            return questionMark(config, s, 0, 0, config.length());
        } else {
            int starMarkIdx = config.indexOf("*");
            String prefix = config.substring(0, starMarkIdx);
            String suffix = config.substring(starMarkIdx + 1);

            if (prefix.length() + suffix.length() > s.length()) return false;

            if (!questionMark(prefix, s, 0, 0, prefix.length())) return false;

            int suffixIdx = s.length() - suffix.length();
            if (!questionMark(suffix, s, 0, suffixIdx, suffix.length())) return false;

            return true;
        }
    }

    private static boolean questionMark(String sub, String s, int subIdx, int sIdx, int length) {
        for (int i = 0; i < length; i++) {
            char curSub = sub.charAt(i + subIdx);
            int idx = i + sIdx;

            if (curSub == '?') {
                if (idx % 2 == 0) return false;
            } else {
                if (curSub != s.charAt(idx)) return false;
            }
        }
        return true;
    }
}