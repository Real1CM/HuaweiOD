import java.util.*;
import java.io.*;

public class Q324 {
    // 存储每一层的评论，索引 0 对应深度 1
    static List<List<String>> levels = new ArrayList<>();
    static String[] tokens;
    static int ptr = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        if (input == null || input.isEmpty()) return;

        // 1. 预处理：按逗号分割
        tokens = input.split(",");

        // 2. 解析：输入可能包含多个根评论（如示例1）
        while (ptr < tokens.length) {
            parse(0);
        }

        // 3. 输出：最大深度及每层内容
        System.out.println(levels.size());
        for (List<String> level : levels) {
            System.out.println(String.join(" ", level));
        }
    }

    /**
     * @param depth 当前嵌套深度（从0开始计数）
     */
    private static void parse(int depth) {
        if (ptr >= tokens.length) return;

        // 获取当前评论内容
        String content = tokens[ptr++];
        // 获取子评论数量
        int childCount = Integer.parseInt(tokens[ptr++]);

        // 确保 levels 列表足够大
        if (levels.size() <= depth) {
            levels.add(new ArrayList<>());
        }

        // 将评论存入对应的深度层
        levels.get(depth).add(content);

        // 递归处理子评论
        for (int i = 0; i < childCount; i++) {
            parse(depth + 1);
        }
    }
}