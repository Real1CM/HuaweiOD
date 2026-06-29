import java.util.Arrays;
import java.util.Scanner;

public class Q102 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().trim().split(",");

        Arrays.sort(str, (x, y) -> (y + x).compareTo(x + y));

        if (str[0].equals("0")) {
            System.out.print("0");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (String s : str) sb.append(s);

        System.out.print(sb);
    }
}
