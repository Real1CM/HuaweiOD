import java.util.*;

public class Q179 {
    static class Node {
        int id;
        long money;
        Node parent;
        List<Node> children = new ArrayList<>();

        public Node(int id) {
            this.id = id;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Map<Integer, Node> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            int parentId = sc.nextInt();
            long money = sc.nextInt();

            Node node = map.computeIfAbsent(id, k -> new Node(id));
            node.money = money;

            Node parentNode = map.computeIfAbsent(parentId, k -> new Node(parentId));

            node.parent = parentNode;
            parentNode.children.add(node);
        }

        Node boss = null;
        for (Node node : map.values()) {
            if (node.parent == null) {
                boss = node;
                break;
            }
        }

        cal(boss);
        System.out.print(boss.id + " " + boss.money);
    }

    private static void cal(Node node) {
        for (Node c : node.children) {
            cal(c);
        }

        if (node.parent != null) {
            long money = (node.money / 100) * 15;
            node.parent.money += money;
        }
    }
}
