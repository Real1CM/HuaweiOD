import java.util.*;

public class Q250 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        List<Set<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] a = Arrays.stream(sc.nextLine().trim().split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            Arrays.sort(a);

            boolean is = false;
            if (a.length >= 2) {
                for (Set<Integer> l : list) {
                    if (l.size() < 2) continue;
                    int cnt = 0;
                    for (int num : a) {
                        if (l.contains(num)) cnt++;
                    }
                    if (cnt >= 2) is = true;
                    if (is) {
                        for (int num : a) l.add(num);
                    }
                }
            }

            if (!is) {
                Set<Integer> nxt = new TreeSet<>();
                for (int num : a) nxt.add(num);
                list.add(nxt);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            Set<Integer> cur = list.get(i);
            if (cur.size() == 1) continue;

            int j = (i + 1) % list.size();
            while (i != j) {
                Set<Integer> nxt = list.get(j);

                if (nxt.size() == 1) {
                    j=(j + 1) % list.size();
                } else {
                    int cnt = 0;
                    for (int num : nxt) {
                        if (cur.contains(num)) cnt++;
                    }
                    if (cnt == 2) {
                        cur.addAll(nxt);
                        list.remove(j);
                    }
                    j=(j + 1) % list.size();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < list.size(); i++) {
            sb.append("[");

            StringJoiner sj = new StringJoiner(",");
            for (int num : list.get(i)) {
                sj.add(num + "");
            }
            sb.append(sj);

            sb.append("]");
            if (i != list.size() - 1) sb.append(",");
        }
        sb.append("]");

        System.out.println(sb.toString());
    }
}