import java.util.Scanner;

public class Q210 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine().trim();
        String s2 = sc.nextLine().trim();
        int k = sc.nextInt();

        int n1 = s1.length();
        int n2 = s2.length();
        int window = k + n1;

        if (n2 < window) {
            System.out.println(-1);
            return;
        }

        int[] c1 = new int[26];
        for (int i = 0; i < n1; i++) {
            c1[s1.charAt(i) - 'a']++;
        }

        int[] c2 = new int[26];
        for (int i = 0; i < window; i++) {
            c2[s2.charAt(i) - 'a']++;
        }

        if (check(c1, c2)) {
            System.out.println(0);
            return;
        }

        for (int i = window; i < n2; i++) {
            c2[s2.charAt(i) - 'a']++;
            c2[s2.charAt(i - window) - 'a']--;

            if (check(c1, c2)) {
                System.out.println(i - window + 1);
                return;
            }
        }
        System.out.println(-1);
    }

    private static boolean check(int[] c1, int[] c2) {
        for (int i = 0; i < 26; i++) {
            if (c2[i] < c1[i]) return false;
        }
        return true;
    }
}
