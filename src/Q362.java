import java.util.Scanner;

public class Q362 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int len = s.length();
        char[] chars = s.toCharArray();

        int i = len - 1;
        chars[i]++; // 第一步：从最后一位开始尝试自增

        while (i >= 0 && i < len) {
            // 1. 如果当前位超过了字母范围，回退
            if (chars[i] >= 'a' + n) {
                i--;
                if (i >= 0) chars[i]++;
            }
            // 2. 检查是否构成回文 (aa 或 aba)
            else if ((i > 0 && chars[i] == chars[i - 1]) ||
                    (i > 1 && chars[i] == chars[i - 2])) {
                chars[i]++; // 冲突了，继续试下一个字符
            }
            // 3. 当前位合法，向右移动填充后续位
            else {
                i++;
                if (i < len) chars[i] = 'a'; // 下一位从 'a' 开始贪心尝试
            }
        }

        if (i < 0) {
            System.out.println("NO");
        } else {
            System.out.println(new String(chars));
        }
    }
}