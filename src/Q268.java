import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q268 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int maxDist = -1;
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
           long a = sc.nextLong();

            if (map.containsKey(a)) {
                maxDist = Math.max(maxDist, i - map.get(a));
            } else map.put(a, i);
        }

        System.out.println(maxDist);
    }
}