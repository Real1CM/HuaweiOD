import java.util.Scanner;

public class Q70 {
    static String s = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        solve(num);
        System.out.println(s);
    }

    private static void solve(int num) {
        if (num <= 0) return;

        num--;
        char curC = (char) ('a' + num % 26);

        s = curC + s;

        solve(num / 26);
    }
}