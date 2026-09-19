import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Q237 {
    static int m, n;
    static int[][] map;
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();

        sc.nextLine();
        int[] a = Arrays.stream(sc.nextLine().trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        map = new int[m][n];
        for (int[] line : map) Arrays.fill(line, -1);

        int[] idx = new int[m];
        Arrays.fill(idx, 0);
        for (int i = 0; i < a.length; i++) {
            int x = a[i] - 1;
            if (x < 0 || x >= m) {
                System.out.println(i + 1 + ",error");
                return;
            }

            int y = idx[a[i] - 1]++;
            if (y >= n) {
                System.out.println(i + 1 + ",error");
                return;
            }

            boolean isRed = i % 2 == 0;

            if (isRed) map[x][y] = 1;
            else map[x][y] = 2;

            if (i >= 4) {
                if (solve(x, y)) {
                    System.out.print(i + 1);
                    if (isRed) System.out.println(",Red");
                    else System.out.println(",Blue");
                    return;
                }
            }
        }

        System.out.println("0,draw");
    }

    private static boolean solve(int x, int y) {
        int color = map[x][y];

        // 检查 4 个轴向
        for (int[] axis : dirs) {
            int count = 1; // 包含当前落下的棋子

            // 1. 沿着正方向进行非递归 DFS 搜索
            count += dfsIterative(x + axis[0], y + axis[1], axis[0], axis[1], color);

            // 2. 沿着反方向进行非递归 DFS 搜索
            count += dfsIterative(x - axis[0], y - axis[1], -axis[0], -axis[1], color);

            if (count >= 4) {
                return true;
            }
        }

        return false;
    }

    private static int dfsIterative(int startX, int startY, int dx, int dy, int color) {
        // 节点数组结构: [r, c, dx, dy]
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{startX, startY, dx, dy});

        int steps = 0;

        while (!stack.isEmpty()) {
            int[] curr = stack.pop();
            int cx = curr[0];
            int cy = curr[1];
            int cdx = curr[2];
            int cdy = curr[3];

            // 边界判断及颜色校验
            if (cx < 0 || cx >= m || cy < 0 || cy >= n || map[cx][cy] != color) {
                continue;
            }

            steps++; // 匹配到同色子，计数 + 1

            // 沿着【锁定方向】继续将下一个位置压入栈中
            stack.push(new int[]{cx + cdx, cy + cdy, cdx, cdy});
        }

        return steps;
    }
}
