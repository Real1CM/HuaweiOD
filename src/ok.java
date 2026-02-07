import java.util.*;

public class ok {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ok = Arrays.stream(sc.nextLine().replace("[", "").replace("]", "").split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] books = new int[ok.length / 2][2];
        for (int i = 0; i < ok.length; i += 2) {
            books[i / 2][0] = ok[i];
            books[i / 2][1] = ok[i + 1];
        }

        Arrays.sort(books, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        int[] dp = new int[books.length];
        int max = 0;
        for (int i = 0; i < books.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (books[i][1] > books[j][1])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}