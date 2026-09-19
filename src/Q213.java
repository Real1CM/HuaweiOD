import java.util.Arrays;
import java.util.Scanner;

public class Q213 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String keyS = sc.nextLine().trim().toLowerCase();
        int[] key = new int[26];
        for (int i = 0; i < keyS.length(); i++) {
            char tmp = keyS.charAt(i);
            key[tmp - 'a']++;
        }

        String[] boxes = sc.nextLine().trim().toLowerCase().split("\\s+");

        int res = 1;
        for (String b : boxes) {
            int[] box = new int[26];
            for (int i = 0; i < b.length(); i++) {
                int tmp = b.charAt(i) - 'a';
                if (tmp >= 0 && tmp <= 26) box[tmp]++;
            }

            if (Arrays.compare(box, key) == 0) {
                System.out.println(res);
                return;
            }

            res++;
        }

        System.out.println(-1);
    }
}
