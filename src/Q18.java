import java.util.Scanner;

public class Q18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] costs = new int[n][3];
        for (int i = 0; i < n; i++) {
            costs[i][0] = sc.nextInt(); // 策略 A
            costs[i][1] = sc.nextInt(); // 策略 B
            costs[i][2] = sc.nextInt(); // 策略 C
        }

        int totalCost = 0;
        int lastStrategy = -1;

        for (int i = 0; i < n; i++) {
            int currentStrategy = -1;
            int minCost = Integer.MAX_VALUE;

            for (int j = 0; j < 3; j++) {
                if(j == lastStrategy) {
                    continue;
                }
                if(costs[i][j] < minCost) {
                    minCost = costs[i][j];
                    currentStrategy = j;
                }
            }

            totalCost += minCost;
            lastStrategy = currentStrategy;
        }
        System.out.println(totalCost);
    }
}
