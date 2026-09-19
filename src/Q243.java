import java.util.Arrays;
import java.util.Scanner;

public class Q243 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] a = Arrays.stream(sc.nextLine().trim().split(","))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        int load = sc.nextInt();

        int res = 0;
        int curW = 0;
        for (int i = 0; i < a.length; i++) {
            curW += a[i];
            if (curW > load) break;
            res++;
        }
        System.out.println(res);
    }
}