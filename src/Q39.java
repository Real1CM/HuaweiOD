import java.util.Scanner;

public class Q39 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();

        int firstDash = str.indexOf("-");
        if (firstDash == -1) {
            System.out.println(str);
            return;
        }

        String firstString = str.substring(0, firstDash);
        String restString = str.substring(firstDash + 1).replace("-", "").toUpperCase();

        StringBuilder sb = new StringBuilder(firstString + "-");
        for (int i = 0; i < restString.length(); i++) {
            sb.append(restString.charAt(i));
            if ((i + 1) % N == 0 && i != restString.length() - 1) sb.append("-");
        }

        System.out.println(sb);
    }
}
