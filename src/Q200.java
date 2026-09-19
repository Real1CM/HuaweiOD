import java.util.*;

public class Q200 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] s = sc.nextLine().trim().split("\\s+");

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length; i++) {
            int tmp = Integer.parseInt(s[i]);
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }

        int cnt = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int k = entry.getKey();
            int count = entry.getValue();
            int groupSize = k + 1;

            int groups = (count + k) / groupSize;
            cnt += groups * groupSize;
        }
        System.out.println(cnt);
    }
}
