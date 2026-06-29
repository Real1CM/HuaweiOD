import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q126 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        Map<Integer, Integer> m1 = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();
            m1.put(num, m1.getOrDefault(num, 0) + 1);
        }

        int n = sc.nextInt();
        Map<Integer, Integer> m2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            m2.put(num, m2.getOrDefault(num, 0) + 1);
        }

        int ans = 0;
        for (Map.Entry<Integer, Integer> e1 : m1.entrySet()) {
            int k = e1.getKey();

            int v2 = 0;
            if (m2.containsKey(k)) v2 = m2.get(k);

            int v1 = e1.getValue();

            ans += v1 * v2;
        }

        System.out.println(ans);
    }
}