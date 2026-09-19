import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q152 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int minAverageLost = sc.nextInt();
        sc.nextLine();
        int[] a = Arrays.stream(sc.nextLine().trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = a.length;

        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) prefix[i + 1] = prefix[i] + a[i];

        int maxL = 0;
        List<String> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int len = j - i + 1;
                int sum = prefix[j + 1] - prefix[i];

                if (sum <= minAverageLost * len) {
                    if (len > maxL) {
                        maxL = len;
                        res.clear();
                        res.add(i + "-" + j);
                    } else if (len == maxL) {
                        res.add(i + "-" + j);
                    }
                }
            }
        }

        if (res.isEmpty()) System.out.println("NULL");
        else System.out.println(String.join(" ", res));
    }
}