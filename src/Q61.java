import java.util.Scanner;

public class Q61 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int len = s.length();

        int[] alphabet = new int[4];
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'W') alphabet[0]++;
            else if (s.charAt(i) == 'A') alphabet[1]++;
            else if (s.charAt(i) == 'S') alphabet[2]++;
            else if (s.charAt(i) == 'D') alphabet[3]++;
        }

        int tar = len / 4;
        if (alphabet[0] == tar && alphabet[1] == tar && alphabet[2] == tar && alphabet[3] == tar) {
            System.out.println(0);
            return;
        }

        int res = 0;
        for (int i = 0; i < 4; i++) {
            int tmp = alphabet[i] - tar;
            if (tmp > 0)
                res += tmp;
        }

        System.out.println(res);
    }
}
