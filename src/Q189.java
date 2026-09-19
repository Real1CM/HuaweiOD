import java.util.Arrays;
import java.util.Scanner;

public class Q189 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String content = sc.nextLine();
        String word = sc.nextLine();
        int cL = content.length();
        int wL = word.length();

        if (wL > cL) {
            System.out.println(0);
            return;
        }

        int[] wArr = new int[26];
        int[] curArr = new int[26];
        for (int i = 0; i < wL; i++) {
            wArr[word.charAt(i) - 'a']++;
            curArr[content.charAt(i) - 'a']++;
        }

        int res = 0;
        if (Arrays.equals(wArr, curArr)) res++;

        for (int i = wL; i < cL; i++) {
            curArr[content.charAt(i) - 'a']++;
            curArr[content.charAt(i - wL) - 'a']--;

            if (Arrays.equals(wArr, curArr)) res++;
        }

        System.out.println(res);
    }
}
