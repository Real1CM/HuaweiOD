import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Q253 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine().trim();

        int curL = 0;
        int maxL = 0;
        int last = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!Character.isDigit(c)) continue;

            int num = c - '0';
            if (num >= last) {
                curL++;
                maxL = Math.max(maxL, curL);
            } else {
                curL = 1;
            }
            last = num;
        }

        System.out.println(maxL);
    }
}