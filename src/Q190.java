import java.util.*;

public class Q190 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine().trim();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((a, b) -> {
            if (!a.getValue().equals(b.getValue())) return b.getValue() - a.getValue();

            char c1 = a.getKey();
            char c2 = b.getKey();

            boolean isLower1 = Character.isLowerCase(c1);
            boolean isLower2 = Character.isLowerCase(c2);

            if (isLower1 != isLower2) return isLower1 ? -1 : 1;

            return c1 - c2;
        });

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : list) {
            sb.append(entry.getKey()).append(":").append(entry.getValue()).append(";");
        }
        System.out.println(sb.toString());
    }
}