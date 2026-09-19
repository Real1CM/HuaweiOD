import java.util.*;

public class Q196 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] str = sc.nextLine().trim().split("@", -1);

        if (str[1].isEmpty()) {
            System.out.println(str[0] + "@");
            return;
        }

        Map<String, Integer> map = new LinkedHashMap<>();

        String[] all = str[0].split(",");
        for (String s : all) {
            String[] tmp = s.split(":");
            map.put(tmp[0], Integer.parseInt(tmp[1]));
        }

        String[] already = str[1].split(",");
        for (String s : already) {
            String[] tmp = s.split(":");
            String tar = tmp[0];
            int val = Integer.parseInt(tmp[1]);
            map.put(tar, map.get(tar) - val);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        StringJoiner sj = new StringJoiner(",");
        for (Map.Entry<String, Integer> m : list) {
            if (m.getValue() > 0) {
                String s = m.getKey() + ":" + m.getValue();
                sj.add(s);
            }
        }

        System.out.println(sj.toString());
    }
}
