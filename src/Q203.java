import java.util.Scanner;

public class Q203 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] str = sc.nextLine().replace("[", "").replace("]", "").replace("\"", "").trim().split("[,\\s]+");

        String cur = str[0];
        for (int i = 1; i < str.length; i++) {
            String tmp = str[i];
            cur = solve(tmp, cur);
            if (cur == "") {
                System.out.println("@Zero");
                return;
            }
        }

        System.out.println("\"" + cur + "\"");
    }

    private static String solve(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 && j >= 0 && a.charAt(i) == b.charAt(j)) {
            i--;
            j--;
        }
        return a.substring(i + 1);
    }
}
