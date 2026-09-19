import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q191 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();

        List<String> s = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            s.add(sc.nextLine().trim());
        }

        StringBuilder sb = new StringBuilder();
        String cur = s.get(k);
        s.remove(k);
        sb.append(cur);

        while (true) {
            char lastChar = cur.charAt(cur.length() - 1);

            PriorityQueue<String> pq = new PriorityQueue<>((x, y) -> {
                if (x.length() != y.length())
                    return Integer.compare(y.length(), x.length());

                return x.compareTo(y);
            });

            for (String str : s) {
                if (str.charAt(0) == lastChar) pq.offer(str);
            }

            if (pq.isEmpty()) break;

            String nxtWord = pq.poll();
            sb.append(nxtWord);

            s.remove(nxtWord);
            cur = nxtWord;
        }

        System.out.println(sb);
    }
}
