import java.util.*;

public class Q30 {
    static class Block {
        int start;
        int size;

        Block(int start, int size) {
            this.start = start;
            this.size = size;
        }

        int end() {
            return start + size;
        }
    }

    static final int TOTAL_SIZE = 100;
    static List<Block> blocks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < N; i++) {
            String[] tokens = sc.nextLine().split("=");
            if (tokens[0].equals("RELEASE")) {
                Release(Integer.parseInt(tokens[1]));
            } else if (tokens[0].equals("REQUEST")) {
                Request(Integer.parseInt(tokens[1]));
            }
        }
    }

    static void Request(int s) {
        if (s <= 0 || s > TOTAL_SIZE) {
            System.out.println("error");
            return;
        }

        blocks.sort(Comparator.comparingInt(b -> b.start));

        int prevEnd = 0;
        for (Block block : blocks) {
            if (block.start - prevEnd >= s) {
                blocks.add(new Block(prevEnd, s));
                System.out.println(prevEnd);
                return;
            }
            prevEnd = block.end();
        }

        if (TOTAL_SIZE - prevEnd >= s) {
            blocks.add(new Block(prevEnd, s));
            System.out.println(prevEnd);
        } else {
            System.out.println("error");
        }
    }

    static void Release(int s) {
        Iterator<Block> it = blocks.iterator();

        while (it.hasNext()) {
            Block block = it.next();
            if(block.start == s) {
                it.remove();
                return;
            }
        }

        System.out.println("error");
    }
}
