import java.util.Scanner;

public class Q7 {
    static int n;   //总运动数
    static int t;   //总卡路里数
    static int k;   //要选择的运动数
    static int num = 0; //可行解数量
    static int[] arr;   //输入运动卡路里数

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = sc.nextInt();
        k = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        solve(0, 0, 0);
        System.out.println(num);
    }

    private static void solve(int index, int count, int sum) {
        if(count == k && sum == t) {
            num++;
            return;
        }

        if(count > k || sum > t || index == n) return;

        solve(index + 1, count, sum + arr[index]);
        solve(index + 1, count, sum - arr[index]);

    }
}
