import java.util.*;

public class Q226 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] a = Arrays.stream(sc.nextLine().trim().replaceAll("\\(", "").replaceAll("\\)", "").split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        Set<String> set = new HashSet<>();
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < a.length; i += 2) {
            int val = a[i];
            int priority = a[i + 1];
            String key = val + "," + priority;

            if (!set.contains(key)) {
                set.add(key);
                list.add(new int[]{val, priority});
            }
        }

        list.sort((x, y) -> Integer.compare(y[1], x[1]));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)[0]);
            if (i < list.size() - 1) sb.append(",");
        }
        System.out.println(sb);
    }
}