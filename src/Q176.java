import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringJoiner;

public class Q176 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] a = Arrays.stream(sc.nextLine().trim().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = a.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * n; i++) {
            int num = a[i % n];
            while (!stack.isEmpty() && a[stack.peek()] < num) res[stack.pop()] = num;

            if (i < n) stack.push(i);
        }

        StringJoiner sj = new StringJoiner(",");
        for (int val : res) {
            sj.add(String.valueOf(val));
        }
        System.out.print(sj);
    }
}
