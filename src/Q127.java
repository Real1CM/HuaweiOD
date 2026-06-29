import java.util.Scanner;
import java.util.Stack;

public class Q127 {
    static class Node {
        char id;
        Node left;
        Node right;

        Node(char id) {
            this.id = id;

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Stack<Node> stack = new Stack<>();
        Node root = null;
        Node curNode = null;

        boolean isRight = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (Character.isLetter(c)) {
                curNode = new Node(c);
                if (root == null) root = curNode;

                if (!stack.isEmpty()) {
                    Node parent = stack.peek();
                    if (!isRight) parent.left = curNode;
                    else parent.right = curNode;
                }
            } else if (c == '{') {
                stack.push(curNode);
                isRight = false;
            } else if (c == ',') {
                isRight = true;
            } else if (c == '}') {
                if (!stack.isEmpty()) stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        inOrder(root, sb);
        System.out.println(sb );
    }

    private static void inOrder(Node root, StringBuilder sb) {
        if (root == null) return;

        inOrder(root.left, sb);
        sb.append(root.id);
        inOrder(root.right, sb);
    }
}