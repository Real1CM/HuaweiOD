import java.util.Arrays;
import java.util.Scanner;

public class Q28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] xl = new int[3];
        int[] yl = new int[3];
        int[] xr = new int[3];
        int[] yr = new int[3];
        for (int i = 0; i < 3; i++) {
            xl[i] = sc.nextInt();
            yl[i] = sc.nextInt();
            xr[i] = sc.nextInt() + xl[i];
            yr[i] = yl[i] - sc.nextInt();
        }

        Arrays.sort(xl);
        Arrays.sort(yl);
        Arrays.sort(xr);
        Arrays.sort(yr);

        int h = yl[0] - yr[2];
        int w = xr[0] - xl[2];
        if (h > 0 && w > 0) {
            System.out.println(h * w);
        } else {
            System.out.println(0);
        }
    }
}
