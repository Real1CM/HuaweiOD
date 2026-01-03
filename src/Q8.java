import java.util.*;
import java.util.regex.*;

public class Q8 {

    // 1 单位货币 = ? CNY
    static Map<String, Double> RATE_TO_CNY = new HashMap<>();
    static Map<String, String> SUB_UNIT = new HashMap<>();

    static {
        RATE_TO_CNY.put("CNY", 1.0);
        RATE_TO_CNY.put("HKD", 100.0 / 123.0);
        RATE_TO_CNY.put("JPY", 100.0 / 1825.0);
        RATE_TO_CNY.put("EUR", 100.0 / 14.0);
        RATE_TO_CNY.put("GBP", 100.0 / 12.0);

        SUB_UNIT.put("CNY", "fen");
        SUB_UNIT.put("HKD", "cents");
        SUB_UNIT.put("JPY", "sen");
        SUB_UNIT.put("EUR", "eurocents");
        SUB_UNIT.put("GBP", "pence");
    }

    // 将一行金额转换为人民币 fen
    static long convertToFen(String line) {
        double totalFen = 0.0;

        for (String cur : SUB_UNIT.keySet()) {
            String sub = SUB_UNIT.get(cur);

            // 主单位
            Matcher m1 = Pattern.compile("(\\d+)" + cur).matcher(line);
            if (m1.find()) {
                long amount = Long.parseLong(m1.group(1));
                // 主单位 → CNY → fen
                totalFen += amount * RATE_TO_CNY.get(cur) * 100;
            }

            // 辅单位
            Matcher m2 = Pattern.compile("(\\d+)" + sub).matcher(line);
            if (m2.find()) {
                long amount = Long.parseLong(m2.group(1));
                totalFen += amount * RATE_TO_CNY.get(cur);
            }
        }

        return (long) totalFen; // 直接截断小数
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());
        long result = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            result += convertToFen(line);
        }

        System.out.println(result);
    }
}
