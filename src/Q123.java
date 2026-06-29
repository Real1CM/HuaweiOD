import java.util.Scanner;
import java.util.Stack;

public class Q123 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] op = sc.nextLine().trim().split("\\s+");

        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (int i = 0; i < op.length; i++) {
            if ("+".equals(op[i])) {
                int cur1 = stack.pop();
                int cur2 = stack.pop();
                int tmp = cur1 + cur2;
                sum += cur1 + cur2;
                stack.push(cur2);
                stack.push(cur1);
                stack.push(tmp);
            } else if ("D".equals(op[i])) {
                int tmp = stack.peek() * 2;
                sum += tmp;
                stack.push(tmp);
            } else if ("C".equals(op[i])) {
                int tmp = stack.pop();
                sum -= tmp;
            } else {
                int cur = Integer.parseInt(op[i]);
                stack.push(cur);
                sum += cur;
            }
        }

        System.out.print(sum);
    }
}
