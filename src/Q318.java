import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q318 {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] inorder = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] preorder = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = inorder.length;

        TreeNode root = buildTree(inorder, preorder, 0, n - 1, 0, n - 1);

        sumTree(root);

        List<Integer> list = new ArrayList<>();
        traverse(root, list);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + (i == list.size() - 1 ? "" : ", "));
        }
    }

    private static TreeNode buildTree(int[] inorder, int[] preorder, int inStart, int inEnd, int preStart, int preEnd) {
        if (inStart > inEnd || preStart > preEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                index = i;
                break;
            }
        }

        int leftSize = index - inStart;
        root.left = buildTree(inorder, preorder, inStart, index - 1, preStart + 1, preStart + leftSize);
        root.right = buildTree(inorder, preorder, index + 1, inEnd, preStart + leftSize + 1, preEnd);
        return root;
    }

    private static int sumTree(TreeNode node) {
        if (node == null) return 0;

        int old = node.val;

        int leftNum = sumTree(node.left);
        int rightNum = sumTree(node.right);

        node.val = leftNum + rightNum;
        return node.val + old;
    }

    private static void traverse(TreeNode node, List<Integer> list) {
        if (node == null) return;
        traverse(node.left, list);
        list.add(node.val);
        traverse(node.right, list);
    }
}