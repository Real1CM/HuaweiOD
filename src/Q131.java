import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q131 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> map = new HashMap<>();
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;

            if (Character.isDigit(line.charAt(0))) {
                int n = Integer.parseInt(line);
                solve(map, n);
            } else map.put(line, map.getOrDefault(line, 0) + 1);
        }
    }

    private static void solve(Map<String, Integer> map, int n) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((a, b) -> {
            int cmp = b.getValue().compareTo(a.getValue());
            if (cmp != 0) return cmp;

            return a.getKey().compareTo(b.getKey());
        });

        StringJoiner sj = new StringJoiner(",");
        int limit = Math.min(n, list.size());
        for (int i = 0; i < limit; i++) sj.add(list.get(i).getKey());

        System.out.println(sj);
    }
}