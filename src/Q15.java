import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(",");

        List<Integer> num = Arrays.stream(words).
                map(Integer::parseInt).
                sorted().
                limit(3).
                toList();

        List<String> ok = num.stream().
                map(String::valueOf).
                sorted((a, b) -> (a + b).compareTo(b + a)).
                toList();

        StringBuilder sb = new StringBuilder();
        for (String s : ok) {
            sb.append(s);
        }
        System.out.println(sb.toString());
    }
}
