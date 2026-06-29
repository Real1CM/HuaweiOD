import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q129 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int amount = sc.nextInt();
        sc.nextLine();
        int[] arr = Arrays.stream(sc.nextLine().trim().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(arr);

        List<List<Integer>> res = new ArrayList<>();
        solve(res, new ArrayList<>(), arr, amount, 0);
        System.out.println(res);
    }

    private static void solve(List<List<Integer>> res, List<Integer> path, int[] arr, int remain, int startIdx) {
        if (remain == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIdx; i < arr.length; i++) {
            if (remain < arr[i]) break;

            path.add(arr[i]);

            solve(res, path, arr, remain - arr[i], i);

            path.removeLast();
        }
    }
}