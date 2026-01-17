import java.util.*;

public class Q27 {
    // 预定义水仙花数
    private static final Set<Integer> NARCISSISTIC_NUMS = new HashSet<>(Arrays.asList(153, 370, 371, 407));

    private static int totalWays = 0; // 记录总分割方案数
    private static int firstWayCount = 0; // 记录第一种方案的子串数

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;
        String s = sc.nextLine();

        dfs(s, 0, 0);

        if (totalWays == 0) {
            System.out.println(0);
        } else if (totalWays > 1) {
            System.out.println(-1);
        } else {
            System.out.println(firstWayCount);
        }
    }

    /**
     * @param s 输入字符串
     * @param start 当前处理的起始索引
     * @param currentCount 当前已经分割出的子串数量
     */
    private static void dfs(String s, int start, int currentCount) {
        // 如果已经处理完整个字符串
        if (start == s.length()) {
            totalWays++;
            firstWayCount = currentCount;
            return;
        }

        int asciiSum = 0;
        for (int i = start; i < s.length(); i++) {
            asciiSum += s.charAt(i);

            // 如果和超过了最大的水仙花数(407)，后续再加字符肯定也不行了，直接剪枝
            if (asciiSum > 407) {
                break;
            }

            // 如果当前的 ASCII 和是水仙花数
            if (NARCISSISTIC_NUMS.contains(asciiSum)) {
                dfs(s, i + 1, currentCount + 1);

                // 优化：如果已经发现多种方案，可以提前终止部分搜索（可选）
                if (totalWays > 1) return;
            }
        }
    }
}
