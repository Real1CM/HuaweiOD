import java.util.*;

public class Q175 {
    public static void main() {
        Scanner sc = new Scanner(System.in);

        int[] a = Arrays.stream(sc.nextLine().trim().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = a.length;
        int tar = (n + 1) / 2;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : a) map.put(num, map.getOrDefault(num, 0) + 1);

        List<Integer> frequency = new ArrayList<>(map.values());
        int cnt = 0;
        int res = 0;
        for (int fre : frequency) {
            cnt += fre;
            res++;
            if (cnt >= tar) break;
        }

        System.out.print(res);
    }
}
