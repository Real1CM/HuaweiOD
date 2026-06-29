import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q72 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().trim().split("\\s+");
        String S = s[0];
        String[] dictionary = s[1].split(",");

        Arrays.sort(dictionary, (x, y) -> Integer.compare(y.length(), x.length()));

        String[] segments = S.split("[,;.]");
        List<String> res = new ArrayList<>();
        for (String seg : segments) {
            if (seg.isEmpty()) continue;

            int i = 0;
            while (i < seg.length()) {
                boolean find = false;

                for (String word : dictionary) {
                    if (seg.startsWith(word, i)) {
                        res.add(word);
                        i += word.length();
                        find = true;
                        break;
                    }
                }

                if (!find) {
                    res.add(String.valueOf(seg.charAt(i)));
                    i++;
                }
            }
        }

        for (int j = 0; j < res.size(); j++) {
            System.out.print(res.get(j) + (j == res.size() - 1 ? "" : ","));
        }
    }
}
