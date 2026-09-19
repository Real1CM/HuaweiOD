import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q197 {
    static class Block {
        char ch;
        long cnt;

        Block(char ch, long cnt) {
            this.ch = ch;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine().trim();
        String t = sc.nextLine().trim();

        List<Block> ls = parse(s);
        List<Block> lt = parse(t);

        long error = 0;
        int i = 0, j = 0;
        while (i < ls.size() && j < lt.size()) {
            Block b1 = ls.get(i);
            Block b2 = lt.get(j);

            long min = Math.min(b1.cnt, b2.cnt);

            if (b1.ch != b2.ch) {
                error += min;
            }

            b1.cnt -= min;
            b2.cnt -= min;

            if (b1.cnt == 0) i++;
            if (b2.cnt == 0) j++;
        }

        long total = 0;
        for (Block b : parse(s)) total += b.cnt;

        System.out.println(error + "/" + total);
    }

    private static List<Block> parse(String str) {
        List<Block> list = new ArrayList<>();
        int len = str.length();
        long count = 0;

        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);

            if (Character.isDigit(ch)) {
                count = count * 10 + (ch - '0');
            } else {
                list.add(new Block(ch, count));
                count = 0;
            }
        }
        return list;
    }
}