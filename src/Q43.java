import java.util.*;

public class Q43 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nodes = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = nodes.length;
        if (n == 1) {
            System.out.println(nodes[0]);
            return;
        }

        int lastNonLeafIndex = n / 2 - 1;
        List<Integer> list = new ArrayList<>();

        postOrder(0, lastNonLeafIndex, nodes, list);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + (i == list.size() - 1 ? "" : " "));
        }
    }

    private static void postOrder(int index, int lastNonLeaf, int[] nodes, List<Integer> res) {
        int left = 2 * index + 1;
        if (left <= lastNonLeaf) {
            postOrder(left, lastNonLeaf, nodes, res);
        }

        int right = 2 * index + 2;
        if (right <= lastNonLeaf) {
            postOrder(right, lastNonLeaf, nodes, res);
        }

        res.add(nodes[index]);
    }
}