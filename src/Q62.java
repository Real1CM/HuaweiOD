import java.util.Arrays;
import java.util.Scanner;

public class Q62 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        Arrays.sort(arr);

        int tree = sc.nextInt();

        int high = (arr[n - 1] - arr[0]) / (tree - 1);
        int low = 1;
        int res = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            int curTree = 1;
            int lastPos = 0;
            boolean flag = false;
            for (int i = 1; i < n; i++) {
                if (arr[i] - arr[lastPos] >= mid) {
                    curTree++;
                    lastPos = i;
                    if (curTree >= tree) {
                        flag = true;
                        break;
                    }
                }
            }

            if (flag) {
                res = mid;
                low = mid + 1;
            } else high = mid - 1;
        }

        System.out.println(res);
    }
}
