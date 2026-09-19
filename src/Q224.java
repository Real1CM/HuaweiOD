import java.util.Arrays;
import java.util.Scanner;

public class Q224 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] cake = Arrays.stream(sc.nextLine().trim().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] gift = Arrays.stream(sc.nextLine().trim().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        int x = sc.nextInt();

        Arrays.sort(cake);
        Arrays.sort(gift);

        long res = 0;
        int l = 0, r = gift.length - 1;
        while (l < cake.length && r >= 0) {
            if (cake[l] + gift[r] <= x) {
                res += r + 1;
                l++;
            } else r--;
        }

        System.out.println(res);
    }
}