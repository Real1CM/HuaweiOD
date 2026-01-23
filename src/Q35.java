import java.util.Scanner;

public class Q35 {
    // 大写数字
    private static final String[] CN_NUMS = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    // 整数部分单位
    private static final String[] CN_UNITS = {"元", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "万"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextDouble()) {
            double amount = sc.nextDouble();
            System.out.println(convert(amount));
        }
    }

    public static String convert(double n) {
        if (n == 0) return "人民币零元整";

        // 四舍五入处理精度，转为长整型分
        long money = Math.round(n * 100);
        long integerPart = money / 100;
        int decimalPart = (int) (money % 100);

        StringBuilder sb = new StringBuilder("人民币");

        // 1. 处理整数部分
        if (integerPart > 0) {
            sb.append(convertInteger(integerPart));
            sb.append("元");
        }

        // 2. 处理小数部分
        if (decimalPart == 0) {
            sb.append("整");
        } else {
            int jiao = decimalPart / 10;
            int fen = decimalPart % 10;
            if (jiao != 0) {
                sb.append(CN_NUMS[jiao]).append("角");
            } else if (integerPart > 0) {
                // 整数部分不为0且有分时，角位为0要补“零”
                sb.append("零");
            }
            if (fen != 0) {
                sb.append(CN_NUMS[fen]).append("分");
            }
        }

        return sb.toString();
    }

    private static String convertInteger(long n) {
        StringBuilder res = new StringBuilder();
        String s = String.valueOf(n);
        int len = s.length();

        for (int i = 0; i < len; i++) {
            int num = s.charAt(i) - '0';
            int unitIdx = len - 1 - i; // 单位索引

            if (num != 0) {
                // 特殊规则：10 在特定情况下写作“拾”而非“壹拾”
                // 但根据本题要求 110 写作“壹佰拾元”，这里做特殊判断
                if (!(num == 1 && unitIdx % 4 == 1 && i == 0)) {
                    res.append(CN_NUMS[num]);
                } else if (i == 0 && num == 1 && unitIdx == 1) {
                    // 如果是10-19之间的数且在最高位
                } else {
                    res.append(CN_NUMS[num]);
                }

                // 修正规则 5：110 写作 壹佰拾元
                if (num == 1 && unitIdx % 4 == 1 && i > 0 && s.charAt(i-1) != '0') {
                    // 这种情况下不加“壹”直接加单位（拾）
                }

                if (unitIdx > 0) res.append(CN_UNITS[unitIdx]);
            } else {
                // 处理“零”：当前位是0，且后面还有非0位，且下一位不是0
                if (unitIdx > 0 && unitIdx % 4 != 0 && s.charAt(i + 1) != '0') {
                    res.append(CN_NUMS[0]);
                }
            }

            // 处理 万、亿 的单位衔接
            if (unitIdx > 0 && unitIdx % 4 == 0) {
                if (unitIdx == 4 && !res.toString().endsWith("万")) res.append("万");
                if (unitIdx == 8 && !res.toString().endsWith("亿")) res.append("亿");
            }
        }
        return res.toString();
    }
}