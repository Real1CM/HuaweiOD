import java.util.Scanner;
import java.util.Stack;

public class Q235 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine().trim().replaceAll("[^()]", "");

        Stack<Character> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (tmp == '(') stack.push(tmp);
            else if (tmp == ')') {
                stack.pop();
                ans++;
            }
        }

        if (stack.isEmpty()) System.out.println(ans);
        else System.out.println(-1);
    }
}
