import java.util.Scanner;

public class Q36 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().toUpperCase();
        String s1 = sc.nextLine().toUpperCase();
        char tar = s1.charAt(0);

        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == tar) j++;
        }

        System.out.println(j);
    }
}
