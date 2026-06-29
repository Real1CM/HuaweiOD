import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Q68 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int q = 0, u = 0, a = 0, c = 0, k = 0;
        int maxNum = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == 'q') {
                if (k > 0) k--;
                q++;
            } else if (ch == 'u') {
                if (q > 0) {
                    u++;
                    q--;
                } else {
                    System.out.println(-1);
                    return;
                }
            } else if (ch == 'a') {
                if (u > 0) {
                    a++;
                    u--;
                } else {
                    System.out.println(-1);
                    return;
                }
            } else if (ch == 'c') {
                if (a > 0) {
                    c++;
                    a--;
                } else {
                    System.out.println(-1);
                    return;
                }
            } else if (ch == 'k') {
                if (c > 0) {
                    k++;
                    c--;
                } else {
                    System.out.println(-1);
                    return;
                }
            } else {
                System.out.println(-1);
                return;
            }

            int curTotal = q + u + a + c + k;
            maxNum = Math.max(curTotal, maxNum);
        }

        if (q == 0 && u == 0 && a == 0 && c == 0 && k > 0) System.out.println(maxNum);
        else System.out.println(-1);
    }
}
