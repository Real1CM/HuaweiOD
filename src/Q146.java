import java.util.Scanner;

public class Q146 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().trim().split(",");

        int n = str.length;
        int[] desk = new int[n];
        for (int i = 0; i < n; i++) desk[i] = Integer.parseInt(str[i]);

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (desk[i] == 0) {
                boolean l = (i == 0) || desk[i - 1] == 0;
                boolean r = (i == n - 1) || desk[i + 1] == 0;
                if (l && r) {
                    cnt++;
                    desk[i] = 1;
                }
            }
        }

        System.out.println(cnt);
    }
}
