import java.util.Scanner;
import java.util.Stack;

public class Q228 {
    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine().trim();
        String[] tokens = line.split("\\s+");
        int n = tokens.length;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(tokens[i]);
        }

        if (!isValid(a)) {
            System.out.println("0 0 0");
            return;
        }

        Node root = build(a, 0, n - 1);

        int l = 0;
        if (root.left != null) {
            Node cur = root.left;
            while (cur.left != null || cur.right != null) {
                if (cur.left != null) cur = cur.left;
                else cur = cur.right;
            }
            l = cur.val;
        }

        int r = 0;
        if (root.right != null) {
            Node cur = root.right;
            while (cur.left != null || cur.right != null) {
                if (cur.right != null) cur = cur.right;
                else cur = cur.left;
            }
            r = cur.val;
        }

        System.out.println("1 " + l + " " + r);
    }

    private static boolean isValid(int[] a) {
        Stack<Integer> stack = new Stack<>();
        int lower = Integer.MIN_VALUE;

        for (int val : a) {
            if (val < lower) {
                return false;
            }

            while (!stack.isEmpty() && val > stack.peek()) {
                lower = stack.pop();
            }

            stack.push(val);
        }
        return true;
    }

    private static Node build(int[] a, int start, int end) {
        if (start > end) return null;

        Node root = new Node(a[start]);
        int rStart = start + 1;
        while (rStart <= end && a[rStart] < a[start]) rStart++;

        root.left = build(a, start + 1, rStart - 1);
        root.right = build(a, rStart, end);

        return root;
    }
}