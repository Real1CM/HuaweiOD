import java.util.Arrays;
import java.util.Scanner;

public class Q171 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] s = sc.nextLine().trim().replace("[", "").replace("]", "").split(",");
        int k = Integer.parseInt(s[s.length - 1]);
        int[] a = new int[s.length - 1];
        for (int i = 0; i < a.length; i++) a[i] = Integer.parseInt(s[i]);

        int[] b = Arrays.copyOf(a, a.length);
        Arrays.sort(b);

        int tar = b[k];
        int res = Integer.MAX_VALUE;
        int resIdx = -1;
        for (int i = 0; i < a.length - k; i++) {
            int curSum = a[i];
            for (int j = i + 1; j < i + k; j++) curSum -= a[j];

            int cur = Math.abs(tar - curSum);

            if (cur < res) {
                res = cur;
                resIdx = i;
            }
        }

        System.out.println(resIdx);
    }
}