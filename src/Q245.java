import java.util.*;

public class Q245 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<String> all = new LinkedHashSet<>();
        Map<String, List<String>> reverse = new HashMap<>();

        String[] edge = sc.nextLine().trim().split(",");
        for (String e : edge) {
            String[] tokens = e.split("-");

            String a = tokens[0];
            String b = tokens[1];

            all.add(a);
            all.add(b);

            reverse.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
        }

        String[] fault = sc.nextLine().trim().split(",");

        Queue<String> q = new LinkedList<>();
        Set<String> failSet = new HashSet<>();
        for (String f : fault) {
            failSet.add(f);
            q.offer(f);
        }

        while (!q.isEmpty()) {
            String cur = q.poll();
            if (reverse.containsKey(cur)) {
                for (String nxt : reverse.get(cur)) {
                    if (!failSet.contains(nxt)) {
                        failSet.add(nxt);
                        q.offer(nxt);
                    }
                }
            }
        }

        List<String> normal = new ArrayList<>();
        for (String s : all) {
            if (!failSet.contains(s)) normal.add(s);
        }

        if (normal.isEmpty()) {
            System.out.println(",");
        } else {
            System.out.println(String.join(",", normal));
        }
    }
}
