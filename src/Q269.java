import java.util.Arrays;
import java.util.Scanner;

public class Q269 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int[] a = new int[m];

        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < m; i++) {
            a[i] = sc.nextInt();
            sum += a[i];
            max = Math.max(max, a[i]);
        }

        Arrays.sort(a);
        for (int i = 0; i < m / 2; i++) {
            int temp = a[i];
            a[i] = a[m - 1 - i];
            a[m - 1 - i] = temp;
        }

        for (int i = max; i <= sum; i++) {
            if (sum % i != 0) continue;

            int tarPart = sum / i;
            boolean[] used = new boolean[m];
            if (canPartition(a, used, i, tarPart, 0, 0)) {
                System.out.println(tarPart);
                return;
            }
        }

        System.out.println(-1);
    }

    private static boolean canPartition(int[] arr, boolean[] used, int tarSum, int k, int curIdx, int curSum) {
        if (k == 1) return true;

        if (curSum + arr[curIdx] == tarSum) return canPartition(arr, used, tarSum, k - 1, 0, 0);

        for (int i = curIdx; i < arr.length; i++) {
            if (used[i]) continue;
            if(curSum+arr[i]>tarSum) continue;

            used[i] = true;

            if (canPartition(arr, used, tarSum, k, i + 1, curSum + arr[i])) return true;

            used[i] = false;

            if (curSum == 0) return false;

            if (curSum + arr[i] == tarSum) return false;

            while (i + 1 < arr.length && arr[i] == arr[i + 1]) i++;
        }

        return false;
    }
}
