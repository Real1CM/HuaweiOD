import java.util.*;

public class Q273 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int l = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        List<String>[] lists = new List[n];
        for (int i = 0; i < n; i++) {
            String[] tmp = sc.nextLine().trim().split(",");
            lists[i] = new ArrayList<>(Arrays.asList(tmp));
        }

        StringJoiner sj = new StringJoiner(",");
        int listIdx = 0;
        int curEmpty = 0;
        while (true) {
            if (curEmpty == n) break;

            List<String> curList = lists[listIdx];

            if (curList.isEmpty()) {
                curEmpty++;
                listIdx = (listIdx + 1) % n;
                continue;
            }

            int curRemove = Math.min(curList.size(), l);
            for (int i = 0; i < curRemove; i++) {
                sj.add(curList.removeFirst());
            }

            listIdx = (listIdx + 1) % n;
        }

        System.out.println(sj.toString());
    }
}
