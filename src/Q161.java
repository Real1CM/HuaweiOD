import java.util.Scanner;

public class Q161 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int money = sc.nextInt();
        int risk = sc.nextInt();
        int[][] product = new int[n][3];
        for (int i = 0; i < n; i++) product[i][0] = sc.nextInt();
        for (int i = 0; i < n; i++) product[i][1] = sc.nextInt();
        for (int i = 0; i < n; i++) product[i][2] = sc.nextInt();

        int[] res = new int[n];
        long max = 0;

        for (int i = 0; i < n; i++) {
            if (product[i][1] <= risk) {
                int invest = Math.min(money, product[i][2]);

                long income = (long) invest * product[i][0];
                if (income > max) {
                    max = income;
                    res = new int[n];
                    res[i] = invest;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (product[i][1] + product[i][1] <= risk) {
                    int p1 = i, p2 = j;
                    if (product[i][0] < product[j][0]) {
                        p1 = j;
                        p2 = i;
                    }

                    int invest1 = Math.min(money, product[p1][2]);
                    int invest2 = Math.min(money - invest1, product[p2][2]);

                    long income = (long) invest1 * product[p1][0] + (long) invest2 * product[p2][0];

                    if (income > max) {
                        max = income;
                        res = new int[n];
                        res[p1] = invest1;
                        res[p2] = invest2;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + ((i == n - 1 ? "" : " ")));
        }
    }
}
