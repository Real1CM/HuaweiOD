import java.util.Scanner;

public class Q332 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 考虑到可能输入空行，建议用 hasNextLine 判断
        if (!sc.hasNextLine()) return;
        String s = sc.nextLine();

        String special = "(^|$|[,+])";
        // 记录方括号嵌套深度，其实用 int 计数比 Stack 更高效
        int bracketLevel = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            // 1. 处理括号嵌套
            if (cur == '[') {
                bracketLevel++;
            } else if (cur == ']') {
                bracketLevel--;
            }

            // 2. 处理下划线替换逻辑
            if (cur == '_') {
                boolean isEscaped = false;
                // 检查前一个字符是否为反斜杠
                if (i > 0 && s.charAt(i - 1) == '\\') {
                    // 进一步检查反斜杠本身是否被转义（例如 \\_）
                    // 统计连续反斜杠的数量
                    int slashCount = 0;
                    for (int j = i - 1; j >= 0 && s.charAt(j) == '\\'; j--) {
                        slashCount++;
                    }
                    if (slashCount % 2 != 0) {
                        isEscaped = true;
                    }
                }

                // 只有不在括号内且未被转义时才替换
                if (bracketLevel == 0 && !isEscaped) {
                    sb.append(special);
                } else {
                    sb.append(cur);
                }
            } else {
                // 非下划线字符直接拼接
                sb.append(cur);
            }
        }

        System.out.println(sb.toString());
    }
}