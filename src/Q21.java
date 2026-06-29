import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Q21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        String[] nums = sc.nextLine().split("\\s+");
        for(String num : nums) {
            list.add(Integer.parseInt(num));
        }

        Stack<Integer> stack = new Stack<>();

        for (int u : list) {
            boolean flag = true;

            while (flag && u < 0 && !stack.isEmpty() && stack.peek() > 0) {
                int tmp = stack.peek();

                if (Math.abs(u) > Math.abs(tmp)) {
                    stack.pop();
                    u = u + tmp;
                } else if (Math.abs(u) < Math.abs(tmp)) {
                    stack.pop();
                    stack.push(tmp + u);
                    flag = false;
                } else {
                    stack.pop();
                    flag = false;
                }

            }

            if (flag) {
                stack.push(u);
            }
        }

        System.out.println(stack.size());
    }
}