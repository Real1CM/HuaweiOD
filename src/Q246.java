import java.util.Arrays;
import java.util.Scanner;

public class Q246 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        int[] a = Arrays.stream(sc.nextLine().trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int xorSum = 0;
        long totalSum = 0;
        int min = Integer.MAX_VALUE;

        for (int num : a) {
            xorSum ^= num;
            totalSum += num;
            min = Math.min(min, num);
        }

        if (xorSum != 0) {
            System.out.println("NO");
        } else {
            // 把最小的一块留给 Koko，其余全给 Solo
            System.out.println(totalSum - min);
        }
    }
}
