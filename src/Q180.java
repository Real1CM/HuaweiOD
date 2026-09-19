import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q180 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] tokens = sc.nextLine().trim().split(",");
        int tar = sc.nextInt();

        Arrays.sort(tokens, (a, b) -> {
            int vA = Integer.parseInt(a.contains("-") ? a.split("-")[0] : a);
            int vB = Integer.parseInt(b.contains("-") ? b.split("-")[0] : b);
            return Integer.compare(vA, vB);
        });

        List<String> list = new ArrayList<>();
        for (String s : tokens) {
            if (!s.contains("-")) {
                int tmp = Integer.parseInt(s);
                if (tmp == tar) continue;
                list.add(tmp + "");
            } else {
                String[] str = s.split("-");
                int n1 = Integer.parseInt(str[0]);
                int n2 = Integer.parseInt(str[1]);

                if (tar > n1 && tar < n2) {
                    if (n1 == tar - 1) list.add(n1 + "");
                    else list.add(n1 + "-" + (tar - 1));

                    if (tar + 1 == n2) list.add(n2 + "");
                    else list.add((tar + 1) + "-" + n2);

                } else if (tar == n1) {
                    if (tar + 1 == n2) list.add(n2 + "");
                    else list.add((tar + 1) + "-" + n2);

                } else if (tar == n2) {
                    if (n1 == tar - 1) list.add(n1 + "");
                    else list.add(n1 + "-" + (tar - 1));

                } else list.add(n1 + "-" + n2);
            }
        }

        System.out.println(String.join(",", list));
    }
}
