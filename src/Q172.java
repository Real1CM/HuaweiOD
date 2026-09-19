import java.util.Arrays;
import java.util.Scanner;

public class Q172 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] a = Arrays.stream(sc.nextLine().trim().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        int k = sc.nextInt();

        int curWindow = 0;
        for (int i = 0; i < k; i++) curWindow += a[i];

        int max = curWindow;
        for (int i = k; i < a.length; i++) {
            curWindow += a[i] - a[i - k];
            max = Math.max(max, curWindow);
        }

        System.out.println(max);
    }
}