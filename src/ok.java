import java.util.*;

public class ok {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split("\\s+");

        int[] nums = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            nums[i] = Integer.parseInt(words[i]);
        }

        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            boolean surrive = true;

            while (!stack.isEmpty() && stack.peek() > 0 && num < 0 && surrive) {
                int top = stack.peek();
                if (Math.abs(top) < Math.abs(num)) {
                    num = top + num;
                    stack.pop();
                } else if (Math.abs(top) > Math.abs(num)) {
                    surrive = false;
                    stack.pop();
                    stack.push(top + num);
                } else {
                    surrive = false;
                    stack.pop();
                }
            }

            if (surrive) {
                stack.push(num);
            }
        }

        System.out.println(stack.size());
    }
}