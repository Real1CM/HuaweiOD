import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Q10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().trim().split(" ");
        int[] peach = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            peach[i] = Integer.parseInt(s[i]);
        }
        int limitHours = sc.nextInt();

        if (limitHours < s.length) System.out.println("-1");

        Arrays.sort(peach);

        int sum = 0;
        for (int i : peach) {
            sum += i;
        }

        int eatSpeed = 1;
        while (eatSpeed <= peach[peach.length - 1]) {
            if ((sum + eatSpeed - 1) / eatSpeed < limitHours) {
                int realHours = 0;
                for (int i = peach.length - 1; i >= 0; i--) {
                    int ok = (peach[i] + eatSpeed - 1) / eatSpeed;
                    realHours += ok;
                }
                if (realHours <= limitHours) {
                    break;
                }
            }
            eatSpeed++;
        }
        System.out.println(eatSpeed);
    }
}