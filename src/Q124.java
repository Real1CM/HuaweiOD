import java.util.*;

public class Q124 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] s1 = sc.nextLine().trim().split(",");
        Map<Integer, Integer> m1 = new HashMap<>();
        for (String s : s1) {
            int num = Integer.parseInt(s);
            m1.put(num, m1.getOrDefault(num, 0) + 1);
        }

        String[] s2 = sc.nextLine().trim().split(",");
        Map<Integer, Integer> m2 = new HashMap<>();
        for (String s : s2) {
            int num = Integer.parseInt(s);
            m2.put(num, m2.getOrDefault(num, 0) + 1);
        }

        Map<Integer, List<Integer>> resMap = new TreeMap<>();
        for (int num : m1.keySet()) {
            if (m2.containsKey(num)) {
                int minCount = Math.min(m1.get(num), m2.get(num));

                resMap.putIfAbsent(minCount, new ArrayList<>());
                resMap.get(minCount).add(num);
            }
        }

        if (resMap.isEmpty()) {
            System.out.println("NULL");
            return;
        }

        for (Map.Entry<Integer, List<Integer>> entry : resMap.entrySet()) {
            int cnt = entry.getKey();
            List<Integer> list = entry.getValue();

            Collections.sort(list);

            StringBuilder sb = new StringBuilder();
            sb.append(cnt).append(":");
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i));
                if (i < list.size() - 1) sb.append(",");
            }

            System.out.println(sb);
        }
    }
}
