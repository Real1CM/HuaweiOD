import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q182 {
    static class Block {
        char c;
        int cnt;

        public Block(char c, int cnt) {
            this.c = c;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine().toLowerCase().replaceAll("[^a-z]", "").trim();
        int l = s.length();

        List<Block> blocks = new ArrayList<>();
        for (int i = 0; i < l; ) {
            char c = s.charAt(i);

            if (i + 1 < l && s.charAt(i + 1) == c) {
                int curL = 0;
                while (i + curL < l && s.charAt(i + curL) == c) curL++;

                blocks.add(new Block(c, curL));
                i += curL;
            } else {
                int remain = 0;
                for (int j = i + 1; j < l; j++) {
                    if (s.charAt(j) == c) {
                        remain++;
                    }
                }
                blocks.add(new Block(c, remain));
                i++;
            }
        }

        blocks.sort((x, y) -> {
            if (x.cnt != y.cnt) return Integer.compare(y.cnt, x.cnt);
            return Character.compare(x.c, y.c);
        });

        StringBuilder sb = new StringBuilder();
        for (Block b : blocks) {
            sb.append(b.c).append(b.cnt);
        }
        System.out.println(sb);
    }
}
