import java.util.Scanner;

public class Q12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   //人批次
        int M = sc.nextInt();   //已准备的
        int[] P = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            P[i] = sc.nextInt();
            sum += P[i];
        }

        int left = 0;
        int right = sum;
        int ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isOk(N, M, P, mid)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(ans);
    }

    private static boolean isOk(int N, int M, int[] P, int mid) {
        int tmp = M;
        if (M < P[0]) return false;
        for (int i = 1; i < N; i++) {
            tmp = tmp + mid - P[i - 1];
            if (tmp < P[i]) return false;
        }
        return true;
    }
}
