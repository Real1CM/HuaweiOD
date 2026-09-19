import java.util.*;

public class Q227 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine().trim();
        String tar = sc.nextLine().trim();

        List<Set<Character>> pattern = new ArrayList<>();
        int tarL = tar.length();
        for (int i = 0; i < tarL; i++) {
            char c = tar.charAt(i);
            if (c == '[') {
                Set<Character> unit = new HashSet<>();
                i++;
                while (i < tarL && tar.charAt(i) != ']') {
                    unit.add(tar.charAt(i));
                    i++;
                }
                pattern.add(unit);
            } else {
                Set<Character> unit = new HashSet<>();
                unit.add(c);
                pattern.add(unit);
            }
        }

        int n = s.length();
        int m = pattern.size();
        if (m > n) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i <= n - m; i++) {
            boolean match = true;
            for (int j = 0; j < m; j++) {
                if (!pattern.get(j).contains(s.charAt(i + j))) {
                    match = false;
                    break;
                }
            }
            if (match) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(-1);
    }
}