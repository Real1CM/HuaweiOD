import java.util.*;

public class ok {
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
        int n = Integer.parseInt(sc.nextLine());
        
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("=");
            
            if(input[0].equals("REQUEST")) {
                
            } else if (input[0].equals("RELEASE")) {
                
            }
        }
    }

    private static void Request(int size) {
        if(size <0||size>100) {
            System.out.println("error");
            return;
        }

        blocks.sort(Comparator.comparingInt(b -> b.start));

        int curEnd = 0;
        for(Block block : blocks) {
            if(block.start - curEnd >= size) {
                blocks.add(new Block(curEnd, size));
                System.out.println(curEnd);
                return;
            }
            curEnd = block.end();
        }

        if(TOTAL_SIZE-curEnd >= size) {
            blocks.add(new Block(curEnd, size));
            System.out.println(curEnd);
        } else {
            System.out.println("error");
        }
    }

    private static void Release(int first) {
        Iterator<Block> iterator = blocks.iterator();

        while (iterator.hasNext()) {
            Block block = iterator.next();
            if(block.start == first) {
                iterator.remove();
                return;
            }
        }

        System.out.println("error");
    }
}