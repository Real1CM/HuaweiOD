import java.util.Scanner;
import java.util.Stack;

public class Q215 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] c = sc.nextLine().trim().toCharArray();
        Stack<Character> s = new Stack<>();
        int max = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(' || c[i] == '[' || c[i] == '{') {
                s.push(c[i]);
            } else if (c[i] == ')' || c[i] == ']' || c[i] == '}') {
                if (s.isEmpty()) {
                    System.out.println(0);
                    return;
                }

                char curC = s.pop();
                if ((c[i] == ')' && curC == '(') || (c[i] == ']' && curC == '[') || (c[i] == '}' && curC == '{')) {
                    max = Math.max(max, s.size() + 1);
                } else {
                    System.out.println(0);
                    return;
                }
            } else {
                System.out.println(0);
                return;
            }
        }

        if (!s.isEmpty()) System.out.println(0);
        else System.out.println(max);
    }
}
