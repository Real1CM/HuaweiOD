import java.util.Scanner;

public class Q71 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] str = sc.nextLine().trim().split("\\s+");
        int[] pixel = new int[str.length];
        for (int i = 0; i < str.length; i++) pixel[i] = Integer.parseInt(str[i]);

        int res = 0;
        double ab = Double.MAX_VALUE;
        for (int i = -255; i <= 255; i++) {
            int val = 0;
            for (int j = 0; j < pixel.length; j++) {
                int cur = pixel[j] + i;
                if (cur < 0) cur = 0;
                if (cur > 255) cur = 255;
                val += cur;
            }

            double curAb = Math.abs((double) val / pixel.length - 128);
            if (curAb < ab) {
                ab = curAb;
                res = i;
            }
        }

        System.out.println(res);
    }
}
