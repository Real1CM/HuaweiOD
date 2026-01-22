import java.util.Scanner;

public class Q35 {
    private static final String[] CN_NUMS = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    private static final String[] CN_UNITS = {"元", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "万"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double amount = sc.nextDouble();

    }

    private static String convert(double n) {
        if (n == 0) return "人民币零元整";

        long money = Math.round(n * 100);   //四舍五入
        long integerPart = money / 100;
        int decimalPart = (int) money % 100;

        StringBuilder sb = new StringBuilder("人民币");

        if (integerPart > 0) {
            sb.append();
        }
    }

    private static String convertInteger(long n) {
        StringBuilder res = new StringBuilder();
        String s = String.valueOf(n);
        int len = s.length();

        for (int i = 0; i < len; i++) {
            int num = s.charAt(i) - '0';    //将字符‘1’变成int的1
            int unidIdx = len - i - 1;

            if (num != 0) {
                if (!(num == 1 && unidIdx % 4 == 1 && i == 0)) res.append(CN_NUMS[num]);
                else if () {
                    
                }
            }
        }
    }
}
