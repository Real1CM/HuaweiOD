import java.util.*;

public class Q198 {
    static class Node {
        int address;
        int val;
        int nxt;

        Node(int address, int val, int nxt) {
            this.address = address;
            this.val = val;
            this.nxt = nxt;

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int start = sc.nextInt();
        int n = sc.nextInt();

        Map<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int address = sc.nextInt();
            int val = sc.nextInt();
            int nxt = sc.nextInt();
            Node cur = new Node(address, val, nxt);
            map.put(address, cur);
        }

        List<Node> list = new ArrayList<>();
        int curAdd = start;
        while (curAdd != -1 && map.containsKey(curAdd)) {
            Node node = map.get(curAdd);
            list.add(node);
            curAdd = node.nxt;
        }

        int len = list.size();
        if (len == 0) return;

        int midIdx = len / 2;
        System.out.println(list.get(midIdx).val);
    }
}
