import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q201 {
    static class Node {
        int len;
        int offset;

        Node(int len, int offset) {
            this.len = len;
            this.offset = offset;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine().trim();

        int i = 0;
        Map<Integer, Node> map = new HashMap<>();
        while (i + 4 <= s.length()) {
            int tag = Integer.parseInt(s.substring(i, i + 2), 16);
            int len = Integer.parseInt(s.substring(i + 2, i + 4), 16);

            int valueOffset = (i / 2) + 2;

            if (i + 4 + len * 2 > s.length()) break;

            map.put(tag, new Node(len, valueOffset));

            i += 4 + len * 2;
        }

        int n = sc.nextInt();
        for (int j = 0; j < n; j++) {
            int cur = sc.nextInt();
            if (!map.containsKey(cur)) {
                System.out.println("0 0");
            } else {
                Node find = map.get(cur);
                System.out.println(find.len + " " + find.offset);
            }
        }
    }
}
