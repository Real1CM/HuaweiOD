import java.util.*;

public class Q64 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().trim().split("\\s+");

        Map<String, Integer> map = new HashMap<>();
        for (String s : str) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String string = String.valueOf(c);


            map.put(string, map.getOrDefault(string, 0) + 1);
        }

        List<String[]> list = new ArrayList<>();
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            String s = e.getKey();
            String num = e.getValue() + "";
            String l = e.getKey().length() + "";

            list.add(new String[]{s, num, l});
        }

        list.sort((x, y) -> {
            int xNum = Integer.parseInt(x[1]);
            int yNum = Integer.parseInt(y[1]);
            int xL = Integer.parseInt(x[2]);
            int yL = Integer.parseInt(y[2]);

            if (xNum != yNum) {
                return Integer.compare(yNum, xNum);
            } else if (xL != yL)
                return Integer.compare(xL, yL);
            else return x[0].compareTo(y[0]);
        });

        List<String> res = new ArrayList<>();
        for (String[] s : list) {
            String word = s[0];
            int cnt = Integer.parseInt(s[1]);
            for (int i = 0; i < cnt; i++) res.add(word);
        }
        int s = res.size();
        for (int i = 0; i < s; i++) {
            System.out.print(res.get(i));
            System.out.print(i != s - 1 ? " " : "");
        }
    }
}
