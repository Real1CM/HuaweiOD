import java.util.*;

public class Q183 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int k = sc.nextInt();

        Map<Character, Integer> map = new HashMap<>();
        int curL = 1;
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1 || s.charAt(i) != s.charAt(i + 1)) {
                char c = s.charAt(i);
                map.put(c, Math.max(map.getOrDefault(c, 0), curL));
                curL = 1;
            } else curL++;
        }

        List<Integer> list = new ArrayList<>(map.values());
        list.sort(Collections.reverseOrder());

        if (k > 0 && k <= list.size()) {
            System.out.println(list.get(k - 1));
        } else System.out.println(-1);
    }
}
