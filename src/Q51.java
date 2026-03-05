import java.util.Scanner;

public class Q51 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int[] counts = new int[R + 1];
        long[] capacities = new long[R + 1];
        for (int i = 0; i <= R; i++) {
            counts[i] = sc.nextInt();
            capacities[i] = (long) Math.pow(2, i);
        }
        int D = sc.nextInt();

        int totalUsers = 0;

        for (int i = 0; i < R; i++) {
            if (capacities[i] >= D) {
                totalUsers += capacities[i];
                capacities[i] = 0;
            }
        }

        while (true) {
            long currentSum = 0;
            int[] used = new int[R + 1];

            for (int i = R; i >= 0; i--) {
                if (counts[i] > 0 && capacities[i] < D) {
                    int need = (int) ((D - currentSum) / capacities[i]);
                    int take = Math.min(counts[i], need);
                    currentSum += take * capacities[i];
                    used[i] = take;
                }
            }

            if (currentSum < D) {
                for (int i = 0; i <= R; i++) {
                    if (counts[i] > used[i]) {
                        int canTake = counts[i] - used[i];
                        int need = (int) Math.ceil((double) (D - currentSum) / capacities[i]);
                        int take = Math.min(canTake, need);

                        currentSum += take * (long) capacities[i];
                        used[i] += take;

                        if (currentSum >= D) break;
                    }
                }
            }

            if (currentSum >= D) {
                totalUsers++;
                for (int i = 0; i <= R; i++) {
                    counts[i] -= used[i];
                }
            } else {
                break;
            }
        }

        System.out.println(totalUsers);
    }
}
