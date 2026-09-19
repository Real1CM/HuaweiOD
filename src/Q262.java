import java.util.Arrays;
import java.util.Scanner;

public class Q262 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] s = Arrays.stream(sc.nextLine().trim().split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        int l = 0;
        int maxL = 0;
        int start = 0, end = 0;
        while (l < s.length) {
            int r = l;
            if ((l == 0 && s[l] == 0) || (s[l] == 0 && s[l - 1] == 0)) {
                int want = 0;
                while (r < s.length && s[r] == want) {
                    want = (want + 1) % 2;
                    r++;
                }
                r--;
                if ((r == s.length - 1 && s[r] == 0) || (s[r] == 0 && s[r + 1] == 0)) {
                    if (maxL < r - l + 1) {
                        maxL = r - l + 1;
                        start = l;
                        end = r;
                    }
                }
                l = r;
            }
            l++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) sb.append(s[i]);
        System.out.println(sb.toString().isEmpty() ? "-1" : sb.toString());
    }
}
