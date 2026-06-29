import java.util.Arrays;
import java.util.Scanner;

public class Q109 {
    private static int res = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] str = sc.nextLine().trim().split("\\s+");
        int[] nums = new int[str.length];
        for (int i = 0; i < str.length; i++) nums[i] = Integer.parseInt(str[i]);
        sc.nextLine();
        int k = sc.nextInt();
        long target = sc.nextLong();

        if (k > nums.length || k < 2) {
            System.out.println(0);
            return;
        }

        Arrays.sort(nums);

        res = dfs(nums, 0, k, target);

        System.out.println(res);
    }

    private static int dfs(int[] nums, int idx, int k, long tar) {
        int cnt = 0;
        int n = nums.length;

        if (idx + k > n) return 0;

        long minSum = 0;
        for (int i = 0; i < k; i++) minSum += nums[idx + i];
        if (minSum > tar) return 0;

        long maxSum = 0;
        for (int i = 0; i < k; i++) maxSum += nums[n - i - 1];
        if (maxSum < tar) return 0;

        if (k == 2) {
            int left = idx;
            int right = n - 1;

            while (left < right) {
                long sum = (long) nums[left] + nums[right];
                if (sum == tar) {
                    cnt++;

                    while (left < right && nums[left] == nums[left + 1]) left++;
                    left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    right--;
                } else if (sum < tar) left++;
                else right--;
            }

            return cnt;
        }

        for (int i = idx; i <= n - k; i++) {
            if (i > idx && nums[i] == nums[i - 1]) continue;

            cnt += dfs(nums, i + 1, k - 1, tar - nums[i]);
        }

        return cnt;
    }
}
