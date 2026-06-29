import java.util.Scanner;

public class Q56 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int number = sc.nextInt();
        int days = sc.nextInt();

        int[] item = new int[number];
        for (int i = 0; i < number; i++) {
            item[i] = sc.nextInt();
        }

        long profit = 0;
        for (int i = 0; i < number; i++) {
            int prePrice = sc.nextInt();
            for (int j = 1; j < days; j++) {
                int curPrice = sc.nextInt();
                if (curPrice > prePrice) {
                    profit += (long) (curPrice - prePrice) * item[i];
                }
                prePrice = curPrice;
            }
        }

        System.out.println(profit);
    }
}
