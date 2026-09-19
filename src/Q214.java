import java.util.Arrays;
import java.util.Scanner;

public class Q214 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int num = sc.nextInt();

        if (num == 0) {
            System.out.println(Arrays.toString(new int[]{0}));
            return;
        }

        if (a == b) {
            System.out.println(Arrays.toString(new int[]{a * num}));
            return;
        }

        int min = Math.min(a, b);
        int max = Math.max(a, b);
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            res[i] = (num - i) * min + i * max;
        }
        System.out.println(Arrays.toString(res));
    }
}