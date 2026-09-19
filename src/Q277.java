import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q277 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] newspaper = sc.nextLine().trim().split("\\s+");
        String[] anonymousLetter = sc.nextLine().trim().split("\\s+");

        Set<Character>[] sets = new Set[newspaper.length];
        for (int i = 0; i < newspaper.length; i++) {
            sets[i] = new HashSet<>();
            String cur = newspaper[i];
            for (int j = 0; j < cur.length(); j++) {
                char c = cur.charAt(j);
                sets[i].add(c);
            }
        }


        int match = 0;
        for (String a : anonymousLetter) {
            int aL = a.length();

            for (Set<Character> s : sets) {
                if (s.size() != aL) continue;

                boolean isMatched = true;
                for (int i = 0; i < aL; i++) {
                    char c = a.charAt(i);
                    if (!s.contains(c)) {
                        isMatched = false;
                        break;
                    }
                }
                if (isMatched) {
                    match++;
                    break;
                }
            }
        }

        System.out.println(match == anonymousLetter.length);
    }
}
