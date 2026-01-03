import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Q17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();   //子串
        String L = sc.nextLine();

        int j = 0;  //s子串指针
        int lastPos = -1;
        int sLen = S.length();
        int lLen = L.length();

        for (int i = 0; i < lLen; i++) {
            if (j < sLen && S.charAt(j) == L.charAt(i)) {
                if (j == sLen - 1) {
                    lastPos = i;
                    break;
                }
                j++;
            }
        }

        System.out.println(lastPos);
    }
}
