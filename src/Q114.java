import java.util.Arrays;
import java.util.Scanner;

public class Q114 {
    static int[] arr;
    static int sum = 0;
    static int diff = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().trim().split("\\s+");

        arr = new int[str.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
            sum += arr[i];
        }
        Arrays.sort(arr);

        dfs(0, 0, 0);
        System.out.println(diff);
    }

    private static void dfs(int idx, int count, int curSum) {
        if (count == 5) {
            int otherSum = sum - curSum;
            int curDiff = Math.abs(curSum - otherSum);
            diff = Math.min(diff, curDiff);
            return;
        }

        if (idx >= arr.length || (5 - count) > (arr.length - idx)) return;

        dfs(idx + 1, count + 1, curSum + arr[idx]);
        dfs(idx + 1, count, curSum);
    }
}
