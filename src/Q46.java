import java.util.Arrays;
import java.util.Scanner;

public class Q46 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().replace("[", "").replace("]", "").split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] books = new int[arr.length / 2][2];
        for (int i = 0; i < arr.length; i += 2) {
            books[i / 2][0] = arr[i];
            books[i / 2][1] = arr[i + 1];
        }

        if (books == null || books.length == 0) {
            System.out.println(0);
            return;
        }

        Arrays.sort(books, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        //动态规划 O(n^2)
        /*int[] dp = new int[books.length];
        int max = 0;
        for (int i = 0; i < books.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (books[j][1] < books[i][1])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);*/

        //O(nlogn)
        int size = 0;
        int[] tmp = new int[books.length];
        for (int[] book : books) {
            int i = 0, j = size;

            while (i != j) {
                int m = (i + j) / 2;
                if (book[1] > tmp[m]) i = m + 1;
                else j = m;
            }

            tmp[i] = book[1];
            if (i == size) size++;
        }
        System.out.println(size);
    }
}