import java.util.Scanner;

public class Q244 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        String s = sc.nextLine();
        String t = sc.nextLine();
        long oneNum = 0, zeroNum = 0;
        for (int i = 0; i < n; i++) {
            int sC = s.charAt(i) - '0';
            int tC = t.charAt(i) - '0';

            if (sC == 1) oneNum++;
            if (tC == 0 && sC == 0) zeroNum++;
        }

        System.out.println(oneNum * zeroNum);
    }
}