import java.util.Scanner;

public class Q45 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = arr[i][0] + arr[i][1] + 15;
        }

        int cnt = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i][0] >= arr[i - 1][2]) cnt++;
        }

        System.out.println(cnt);
    }
}
