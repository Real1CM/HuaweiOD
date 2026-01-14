import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q24 {
    /***
     * import java.util.Scanner;
     *
     * public class Q24 {
     *     public static void main(String[] args) {
     *         Scanner sc = new Scanner(System.in);
     *         if (!sc.hasNextLine()) return;
     *         String s = sc.nextLine();
     *         char[] rooms = s.toCharArray();
     *         int n = rooms.length;
     *
     *         boolean[] hasPower = new boolean[n];
     *         int count = 0;
     *
     *         for (int i = 0; i < n; i++) {
     *             if (rooms[i] == 'M') {
     *                 // 1. 检查左边是否已经有前一个机柜放好的电箱了
     *                 if (i > 0 && hasPower[i - 1]) {
     *                     continue; // 已经满足，跳过
     *                 }
     *
     *                 // 2. 贪婪尝试：优先放在右边 (i+1)
     *                 if (i + 1 < n && rooms[i + 1] == 'I') {
     *                     hasPower[i + 1] = true;
     *                     count++;
     *                 }
     *                 // 3. 实在不行，放在左边 (i-1)
     *                 else if (i - 1 >= 0 && rooms[i - 1] == 'I') {
     *                     hasPower[i - 1] = true;
     *                     count++;
     *                 }
     *                 // 4. 左右都没地方放，说明无解
     *                 else {
     *                     System.out.println(-1);
     *                     return;
     *                 }
     *             }
     *         }
     *         System.out.println(count);
     *     }
     * }
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split("");

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals("M")) {
                list.add(i);
            }
        }

        int res = 0;

        if (list.size() ==1 && str.length != 1) {
            res = 1;
        }

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) - list.get(i - 1) == 1) {
                continue;
            } else if (list.get(i) - list.get(i - 1) == 2) {
                res++;
            } else if (list.get(i) - list.get(i - 1) >= 3) {
                res += 2;
            }
        }
        if (res == 0) {
            res = -1;
        }
        System.out.println(res);
    }
}
