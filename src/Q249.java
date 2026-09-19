import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q249 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        String s = sc.nextLine();
        String res = "";
        if (n == 1) res = encode(s);
        else if (n == 2) res = decode(s);

        System.out.println(res);
    }

    private static String encode(String s) {
        if (s == null || s.isEmpty() || s.length() > 1000) return "ENCODE_ERROR";

        List<String> items = splitTopLevel(s);
        if (items == null) return "ENCODE_ERROR";

        StringBuilder sb = new StringBuilder();
        for (String item : items) {
            item = item.trim();

            if (!item.startsWith("[") || !item.endsWith("]")) continue;

            String inner = item.substring(1, item.length() - 1);
            List<String> parts = splitInner(inner);

            if (parts.size() < 3) continue;

            String pos = parts.get(0).trim();
            String type = parts.get(1).trim();

            StringBuilder valBuilder = new StringBuilder();
            for (int i = 2; i < parts.size(); i++) {
                if (i > 2) valBuilder.append(",");
                valBuilder.append(parts.get(i));
            }

            String val = valBuilder.toString();

            if (!isNumeric(pos)) continue;

            if ("Integer".equals(type)) {
                sb.append(pos).append("#0#").append(val.length()).append("#").append(val);
            } else if ("String".equals(type)) {
                sb.append(pos).append("#1#").append(val.length()).append("#").append(val);
            } else if ("Compose".equals(type)) {
                String subEncode = encode(val);
                if ("ENCODE_ERROR".equals(subEncode)) {
                    continue;
                }
                sb.append(pos).append("#2#").append(subEncode.length()).append("#").append(subEncode);
            } else {
                continue;
            }
        }
        return sb.toString();
    }

    private static String decode(String s) {
        if (s == null || s.isEmpty() || s.length() > 1000) return "DECODE_ERROR";

        List<String> res = new ArrayList<>();
        int i = 0;
        int n = s.length();

        while (i < n) {
            int p1 = s.indexOf('#', i);
            if (p1 == -1) break;
            String pos = s.substring(i, p1);

            int p2 = s.indexOf('#', p1 + 1);
            if (p2 == -1) break;
            String type = s.substring(p1 + 1, p2);

            int p3 = s.indexOf('#', p2 + 1);
            if (p3 == -1) break;
            String lengthStr = s.substring(p2 + 1, p3);

            if (!isNumeric(pos) || !isNumeric(lengthStr) || !("0".equals(type) || "1".equals(type) || "2".equals(type)))
                return "DECODE_ERROR";

            int length = Integer.parseInt(lengthStr);
            int dataStart = p3 + 1;
            int dataEnd = dataStart + length;

            if (dataEnd > n) return "DECODE_ERROR";

            String rawVal = s.substring(dataStart, dataEnd);
            i = dataEnd;

            if ("0".equals(type)) res.add("[" + pos + ",Integer," + rawVal + "]");
            else if ("1".equals(type)) res.add("[" + pos + ",String," + rawVal + "]");
            else if ("2".equals(type)) {
                String subDecode = decode(rawVal);
                if ("DECODE_ERROR".equals(rawVal)) continue;
                res.add("[" + pos + ",Compose," + subDecode + "]");
            }
        }

        if (res.isEmpty() && n > 0) return "DECODE_ERROR";

        return String.join(",", res);
    }

    private static List<String> splitTopLevel(String s) {
        List<String> list = new ArrayList<>();
        int depth = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') depth++;
            else if (c == ']') depth--;
            else if (c == ',' && depth == 0) {
                list.add(s.substring(start, i));
                start = i + 1;
            }
        }

        if (depth != 0) return null;

        if (start < s.length()) list.add(s.substring(start));

        return list;
    }

    private static List<String> splitInner(String s) {
        List<String> list = new ArrayList<>();
        int depth = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '[') depth++;
            else if (c == ']') depth--;
            else if (c == ',' && depth == 0) {
                list.add(s.substring(start, i));
                start = i + 1;
            }
        }

        if (start < s.length()) list.add(s.substring(start));

        return list;
    }

    private static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) return false;
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
}
