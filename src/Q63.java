import java.util.*;

public class Q63 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] cards = sc.nextLine().split(" ");

        Map<String, Integer> map = new HashMap<>();
        for (int i = 3; i <= 10; i++) map.put(String.valueOf(i), i);
        map.put("J", 11);
        map.put("Q", 12);
        map.put("K", 13);
        map.put("A", 14);

        String[] val2Card = new String[15];
        for (int i = 3; i <= 10; i++) val2Card[i] = String.valueOf(i);
        val2Card[11] = "J";
        val2Card[12] = "Q";
        val2Card[13] = "K";
        val2Card[14] = "A";

        boolean[] hasCard = new boolean[15];
        for (String c : cards)
            if (map.containsKey(c))
                hasCard[map.get(c)] = true;

        List<List<String>> res = new ArrayList<>();

        int i = 3;
        while (i <= 14) {
            if (hasCard[i]) {
                int j = i;
                while (j <= 14 && hasCard[j]) j++;
                if (j - i >= 5) {
                    List<String> str = new ArrayList<>();
                    for (int k = i; k < j; k++) str.add(val2Card[i]);
                    res.add(str);
                }
                i = j;
            } else i++;
        }

        if (res.isEmpty()) System.out.println("No");
        else for (List<String> s : res) System.out.println(String.join(" ", s));
    }
}